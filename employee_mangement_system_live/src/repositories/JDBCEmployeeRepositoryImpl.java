package repositories;

import models.Department;
import models.Employee;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmployeeRepositoryImpl implements EmployeeRepository {
    private static Connection connection = DatabaseUtils.getConnection();

    @Override
    public Employee addEmployee(Employee employee) {
        String query = "INSERT INTO employees(name, department, salary, dob, emergency_contact) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getDepartment());
            preparedStatement.setInt(3,employee.getSalary());
            preparedStatement.setString(4,employee.getDob());
            preparedStatement.setString(5,employee.getEmemergencyContact());
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected > 0){
                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
                if(generatedKey.next()){
                    Long id = generatedKey.getLong(1);
                    employee.setId(id);
                }
            }
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setDob(resultSet.getString("dob"));
                employee.setEmemergencyContact(resultSet.getString("emergency_contact"));
                return employee;
            } else return null;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching employee with id " + id, e);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setDob(resultSet.getString("dob"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setEmemergencyContact(resultSet.getString("emergency_contact"));
                employees.add(employee);
            }
            return employees;
        } catch (Exception ex){
            throw new RuntimeException("Error while fetching all the employees from the db", ex);
        }
    }

    @Override
    public Employee updateEmployee(Long id, Department newDepartment, int newSalary) {
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting employee with id " + id, e);
        }
    }

    @Override
    public Employee updateEmployeeEmergencyContact(Long id, String newContact) {
        String query = "UPDATE employees SET emergency_contact = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newContact);
            preparedStatement.setLong(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                return getEmployeeById(id);
            } else return null;
        } catch (Exception e) {
            throw new RuntimeException("Error while updating employee's emergency contact", e);
        }
    }
}
