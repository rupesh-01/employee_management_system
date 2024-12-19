package services;

import exceptions.EmployeeLimitReachedException;
import exceptions.EmployeeNotFoundException;
import models.Employee;
import repositories.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee createdEmployee = employeeRepository.addEmployee(employee);
        if(createdEmployee == null){
            throw new EmployeeLimitReachedException("No more employee can be added");
        }
        return createdEmployee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee id not found" + id);
        }
        return employee;
    }

    @Override
    public Employee[] getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee updateEmployee(int id, String newDepartment, int newSalary) {
        Employee employee = employeeRepository.updateEmployee(id, newDepartment, newSalary);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee id not found : "+ id);
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean isEmployeeDeleted = employeeRepository.deleteEmployee(id);
        if(isEmployeeDeleted == false){
            throw new EmployeeNotFoundException("Employee not found id : " + id);
        }
        return isEmployeeDeleted;
    }

    @Override
    public Employee updateEmployeeEmergencyContact(int id, String newContact) {
        Employee employee = employeeRepository.updateEmployeeEmergencyContact(id, newContact);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee not found id : " + id);
        }
        return employee;
    }
}
