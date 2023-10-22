import hibernate.manyToMany.Children;
import hibernate.manyToMany.Section;
import hibernate.oneToMany.Department;
import hibernate.oneToOne.Detail;
import hibernate.oneToOne.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Program.manyToMany();
    }
}


//Для использования любого из ниже перечисленных методов
//должны быть реализованы соответствующие методу таблицы в БД
class Program {

    public static void oneToOne() {
        runProgram(Employee.class, Detail.class, 4,
                (Scanner scanner, Session session, int item) -> {
            System.out.println("Select the action you want to perform with the Employees/Details table:" +
                    "\n\t1. Add a employee" +
                    "\n\t2. Delete an employee" +
                    "\n\t3. Show all employees" +
                    "\n\t4. Exit");
            item = scanner.nextInt();
            if (item == 1) {
                Employee employee = Employee.scan();
                session.save(employee);
                System.out.println("Entry added!");
            } else if (item == 2) {
                System.out.print("Enter the id of the post you want to delete: ");
                int id = scanner.nextInt();
                Employee employee = session.get(Employee.class, id);
                session.delete(employee);
                System.out.println("Entry deleted!");
            } else if (item == 3) {
                List<Employee> allEmployees = session.createQuery("from Employee").list();
                allEmployees.forEach(System.out::println);
            } else if (item == 4) {
                return item;
            } else {
                System.out.println("Incorrect input!");
            }
            return item;
        });
    }

    public static void oneToMany() {
        runProgram(Employee.class, Department.class, 5,
                (Scanner scanner, Session session, int item) -> {
            System.out.println("Select the action you want to perform with the Employees/Departments table:" +
                    "\n\t1. Add an employee entry" +
                    "\n\t2. Add a department entry" +
                    "\n\t3. Delete an employee" +
                    "\n\t4. Show all entries" +
                    "\n\t5. Exit");
            item = scanner.nextInt();
            if (item == 1) {
                hibernate.oneToMany.Employee employee = hibernate.oneToMany.Employee.scan();
                System.out.print("Enter department ID: ");
                int departmentId = scanner.nextInt();
                Department department = session.get(Department.class, departmentId);
                if (department != null) {
                    employee.setDepartment(department);
                    session.save(employee);
                } else {
                    System.out.println("Department not found!");
                }
            } else if (item == 2) {
                Department department = Department.scan();
                session.save(department);
            } else if (item == 3) {
                System.out.print("Enter employee ID: ");
                int employeeId = scanner.nextInt();
                session.delete(session.get(hibernate.oneToMany.Employee.class, employeeId));
            } else if (item == 4) {
                List<Department> departments = session.createQuery("from Department").list();
                departments.forEach((department)
                        -> System.out.println(department.toString(true)));
            } else if (item == 5) {
                return item;
            } else {
                System.out.println("Incorrect input!");
            }
            return item;
        });
    }

    public static void manyToMany() {
        runProgram(Children.class, Section.class, 7,
                (Scanner scanner, Session session, int item) -> {
            System.out.println("Select the action you want to perform with the Children/Sections table:" +
                    "\n\t1. Add a child entry" +
                    "\n\t2. Delete a child entry" +
                    "\n\t3. Add a section" +
                    "\n\t4. Delete a section" +
                    "\n\t5. Add a child to a section" +
                    "\n\t6. Show all entries" +
                    "\n\t7. Exit");
            item = scanner.nextInt();
            if (item == 1) {
                Children children = Children.scan();
                session.save(children);
            } else if (item == 2) {
                System.out.print("Enter the id of the child entry you want to delete: ");
                session.delete(session.get(Children.class, scanner.nextInt()));
            } else if (item == 3) {
                session.save(Section.scan());
            } else if (item == 4) {
                System.out.print("Enter the id of the section entry you want to delete: ");
                session.delete(session.get(Section.class, scanner.nextInt()));
            } else if (item == 5) {
                System.out.print("Enter the child's id: ");
                int childId = scanner.nextInt();
                System.out.print("Enter section id: ");
                int sectionId = scanner.nextInt();
                Children child = session.get(Children.class, childId);
                Section section = session.get(Section.class, sectionId);
                if (child != null && section != null) {
                    section.addChildren(child);
                } else {
                    System.out.println("Child or section not found!");
                }
            } else if (item == 6) {
                System.out.println("CHILDREN:");
                List<Children> children = session.createQuery("from Children", Children.class).getResultList();
                children.forEach(System.out::println);
                System.out.println("\nSECTIONS:");
                List<Section> sections = session.createQuery("from Section", Section.class).getResultList();
                sections.forEach(System.out::println);
                System.out.println("\nCHILDREN-SECTIONS:");
                children.forEach(c -> {
                    System.out.println("ID: " + c.getId() + ": ");
                    c.getSections().forEach(System.out::println);
                });
            }
            return item;
        });
    }

    private static void runProgram(Class first, Class second, int maxItem, Function lambda) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i != maxItem;) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(first)
                    .addAnnotatedClass(second)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            i = lambda.communicationType(scanner, session, i);
            session.getTransaction().commit();
            factory.close();
        }
    }
}

interface Function {

    int communicationType(Scanner scanner, Session session, int item);
}