package repositories;

import models.Department;
import models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEmployeeRepositoryImpl implements EmployeeRepository{
    private Employee[] employees;
    private int employeeCount;

    public ArrayEmployeeRepositoryImpl(int employeeCount){
        employees = new Employee[employeeCount];
        this.employeeCount = 0;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee newEmployee=null;
        if(employees.length == 0){
            employees[employeeCount++] = employee;
            newEmployee = employee;
        }
        else if(employeeCount > employees.length){
            return null;
        }
        else{
            employees[employeeCount++] = employee;
            newEmployee = employee;
        }
        return newEmployee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee foundEmployee = null;
        for(int i = 0; i < employeeCount; i++){
            if(employees[i].getId() == id){
                foundEmployee = employees[i];
            }
        }
        return foundEmployee;
    }

    @Override
    public List<Employee> getEmployees() {
        Employee[] copiedEmployee = Arrays.copyOf(employees, employeeCount);
        return null;
    }

    @Override
    public Employee updateEmployee(Long id, Department newDepartment, int newSalary) {
        // first find the employee
        //update the required fields
        Employee existingEmployee = getEmployeeById(id);
        if(existingEmployee != null){
            //existingEmployee.setDepartment(newDepartment);
            existingEmployee.setSalary(newSalary);
        }
        return existingEmployee;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        //find the employee with the given id
        //delete
        boolean foundEmployee = false;
        for(int i = 0; i < employeeCount; i++){
            if(employees[i].getId() == id){
                for(int j = i; j < employeeCount; j++){
                    employees[j] = employees[j+1];
                }
                employees[employeeCount--] = null;
                foundEmployee = true;
            }
        }

        return foundEmployee;

    }

    @Override
    public Employee updateEmployeeEmergencyContact(Long id, String newContact) {
        //get the employee
        //update the new details

        Employee employee = getEmployeeById(id);
        if(employee != null){
            employee.setEmemergencyContact(newContact);
        }
        return employee;
    }
}
