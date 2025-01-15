package services;

import models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getEmployees();
    Employee updateEmployee(Long id, String newDepartment, int newSalary);
    boolean deleteEmployee(Long id);
    Employee updateEmployeeEmergencyContact(Long id, String newContact);
    Employee assignDepartment(Long empId, int deptId);

}
