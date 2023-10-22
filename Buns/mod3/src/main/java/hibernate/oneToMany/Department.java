package hibernate.oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department",
            fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Department() {}

    public Department(String name, int maxSalary, int minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public String toString(boolean includeEmployees) {
        StringBuilder employeeList = new StringBuilder();
        employees.forEach(employee -> employeeList.append("\n\t\t").append(employee));
        return "Department {" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\tmaxSalary=" + maxSalary +
                "\n\tminSalary=" + minSalary +
                "\n\temployees:" + employeeList + '\n' +
                '}';
    }

    @Override
    public String toString() {
        return "Department {" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\tmaxSalary=" + maxSalary +
                "\n\tminSalary=" + minSalary + '\n' +
                '}';
    }

    public static Department scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter department name: ");
        String name = scanner.nextLine();
        System.out.print("Enter maximum salary: ");
        int maxSalary = scanner.nextInt();
        System.out.print("Enter minimum salary: ");
        int minSalary = scanner.nextInt();
        return new Department(name, maxSalary, minSalary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
        employee.setDepartment(this);
    }
}
