package repositories;

import exceptions.EmployeeNotFoundException;
import models.Department;
import models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<Integer, Employee> employeeMap;

    public MapEmployeeRepositoryImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(employeeMap.containsKey(employee.getId())){
            throw new RuntimeException("Duplicate Id not allowed");
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }


    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee updateEmployee(int id, Department newDepartment, int newSalary) {
        //using the key get the employee
        //modify the current employee object
        Employee existingEmployee = employeeMap.get(id);
        if(existingEmployee!=null){
            existingEmployee.setDepartment(newDepartment);
            existingEmployee.setSalary(newSalary);
        }
        return existingEmployee;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if(employeeMap.containsKey(id)){
            employeeMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Employee updateEmployeeEmergencyContact(int id, String newContact) {
        Employee employee = employeeMap.get(id);
        if(employee!=null){
            employee.setEmemergencyContact(newContact);
        }
        return employee;
    }
}
