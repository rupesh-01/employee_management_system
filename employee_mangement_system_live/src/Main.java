import controllers.EmployeeController;
import models.Department;
import repositories.*;
import services.EmployeeService;
import services.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new MapDepartmentRepositoryImpl();
        EmployeeRepository employeeRepository = new MapEmployeeRepositoryImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, departmentRepository);
        EmployeeController employeeController = new EmployeeController(employeeService);
        employeeController.run();
    }
}