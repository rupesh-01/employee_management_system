package models;

//TODO: 1. display method in Employee 2. Department model in models package

public class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;
    private String dob;
    private String ememergencyContact;

    public Employee(int id, String name, String department, int salary, String ememergencyContact) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.ememergencyContact = ememergencyContact;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmemergencyContact() {
        return ememergencyContact;
    }

    public void setEmemergencyContact(String ememergencyContact) {
        this.ememergencyContact = ememergencyContact;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", ememergencyContact='" + ememergencyContact + '\'' +
                '}';
    }
}
