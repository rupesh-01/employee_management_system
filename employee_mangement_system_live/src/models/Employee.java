package models;

//TODO: 1. display method in Employee 2. Department model in models package

public class Employee {
    private Long id;
    private String name;
    private String department;
    private int salary;
    private String dob;
    private String emergencyContact;

    public Employee(){
        
    }

    public Employee(String name, String department, int salary, String dob, String emergencyContact) {
        this.name = name;
        this.department = department;
        this.dob = dob;
        this.salary = salary;
        this.emergencyContact = emergencyContact;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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
