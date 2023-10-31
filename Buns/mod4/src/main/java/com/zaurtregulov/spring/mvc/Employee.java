package com.zaurtregulov.spring.mvc;

import javax.validation.constraints.*;
import java.util.*;

public class Employee {

    @Size(min = 2, message = "The name must be at least 2 characters long")
    private String name;

    @NotBlank(message = "This is a required field")
    private String surname;

    @Min(value = 150, message = "salary should be more than 150")
    @Max(value = 10000, message = "salary must be less than 10,000")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String car;
    private Map<String, String> cars;
    private String[] languages;
    private List<String> languagesAsList;

    @Size(min = 11, message = "phone number must contain 11 digits")
    @Pattern(message = "The phone number must contain only numbers and +",
            regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    private String phoneNumber;

    @Pattern(message = "wrong email address",
            regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    public Employee() {
        departments = new HashMap<String, String>() {{
            put("IT", "IT");
            put("HR", "HR");
            put("Sales", "Sales");
        }};
        cars = new HashMap<String, String>() {{
            put("Audi", "Audi");
            put("MB", "MB");
            put("BMW", "BMW");
        }};
        languagesAsList = new ArrayList<String>() {{
            add("EN");
            add("FR");
            add("DE");
        }};
    }

    public Employee(String name,
                    String surname,
                    int salary,
                    String department,
                    Map<String, String> departments,
                    String car,
                    Map<String, String> cars,
                    String[] languages,
                    List<String> languagesAsList,
                    String phoneNumber,
                    String email) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.departments = departments;
        this.car = car;
        this.cars = cars;
        this.languages = languages;
        this.languagesAsList = languagesAsList;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", departments=" + departments +
                ", sex='" + car + '\'' +
                ", genders=" + cars +
                ", skills=" + Arrays.toString(languages) +
                ", skillsAsList=" + languagesAsList +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Map<String, String> getCars() {
        return cars;
    }

    public void setCars(Map<String, String> cars) {
        this.cars = cars;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] skills) {
        this.languages = skills;
    }

    public List<String> getLanguagesAsList() {
        return languagesAsList;
    }

    public void setLanguagesAsList(List<String> skillsAsList) {
        this.languagesAsList = skillsAsList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
