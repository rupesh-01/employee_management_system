package repositories;

import exceptions.EmployeeNotFoundException;
import models.Department;
import models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<Long, Employee> employeeMap;
    private Long id;

    public MapEmployeeRepositoryImpl() {
        this.employeeMap = new HashMap<>();
        this.id = 1L;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(this.id);
        employeeMap.put(this.id, employee);
        return employeeMap.get(id++);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeMap.get(id);
    }


    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee updateEmployee(Long id, Department newDepartment, int newSalary) {
        //using the key get the employee
        //modify the current employee object
        Employee existingEmployee = employeeMap.get(id);
        if(existingEmployee!=null){
            //existingEmployee.setDepartment(newDepartment);
            existingEmployee.setSalary(newSalary);
        }
        return existingEmployee;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if(employeeMap.containsKey(id)){
            employeeMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Employee updateEmployeeEmergencyContact(Long id, String newContact) {
        Employee employee = employeeMap.get(id);
        if(employee!=null){
            employee.setEmemergencyContact(newContact);
        }
        return employee;
    }
}
