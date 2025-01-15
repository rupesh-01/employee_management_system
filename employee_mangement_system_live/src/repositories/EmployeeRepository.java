package repositories;

import models.Department;
import models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    Employee updateEmployee(int id, Department newDepartment, int newSalary);
    boolean deleteEmployee(int id);
    Employee updateEmployeeEmergencyContact(int id, String newContact);
}
