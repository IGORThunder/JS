package xml;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("Person bean is created");
    }

    public Person(Pet pet) {
        this();
        this.pet = pet;
    }

    public void callPet() {
        System.out.println("Hello, my lovely pet!");
        pet.say();
    }

    @Override
    public String toString() {
        return "Person{" +
                "pet=" + pet +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }
}
