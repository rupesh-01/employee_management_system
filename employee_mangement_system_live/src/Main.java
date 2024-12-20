import controllers.EmployeeController;
import models.Department;
import repositories.ArrayDepartmentRepositoryImpl;
import repositories.ArrayEmployeeRepositoryImpl;
import repositories.DepartmentRepository;
import repositories.EmployeeRepository;
import services.EmployeeService;
import services.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new ArrayDepartmentRepositoryImpl();
        EmployeeRepository employeeRepository = new ArrayEmployeeRepositoryImpl(10);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, departmentRepository);
        EmployeeController employeeController = new EmployeeController(employeeService);
        employeeController.run();
    }
}