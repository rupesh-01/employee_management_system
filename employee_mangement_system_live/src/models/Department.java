package models;

public class Department {
    private int id;
    private String name;
    private String location;
    private String employeeCount;

    public Department(int id, String name, String location, String employeeCount) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employeeCount = employeeCount;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(String employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employeeCount='" + employeeCount + '\'' +
                '}';
    }
}
