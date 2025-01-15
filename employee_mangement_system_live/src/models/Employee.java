package models;

//TODO: 1. display method in Employee 2. Department model in models package

public class Employee {
    private Long id;
    private String name;
    private Department department;
    private int salary;
    private String dob;
    private String emergencyContact;

    public Employee(String name, int salary, String emergencyContact) {
        this.name = name;
        this.salary = salary;
        this.emergencyContact = emergencyContact;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmemergencyContact() {
        return emergencyContact;
    }

    public void setEmemergencyContact(String ememergencyContact) {
        this.emergencyContact = ememergencyContact;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", dob='" + dob + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                '}';
    }
}
