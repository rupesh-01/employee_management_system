package services;

import models.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    Employee[] getEmployees();
    Employee updateEmployee(int id, String newDepartment, int newSalary);
    boolean deleteEmployee(int id);
    Employee updateEmployeeEmergencyContact(int id, String newContact);
    Employee assignDepartment(int empId, int deptId);

}
