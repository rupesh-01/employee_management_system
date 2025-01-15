package repositories;

import models.Department;
import models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getEmployees();
    Employee updateEmployee(Long id, Department newDepartment, int newSalary);
    boolean deleteEmployee(Long id);
    Employee updateEmployeeEmergencyContact(Long id, String newContact);
}
