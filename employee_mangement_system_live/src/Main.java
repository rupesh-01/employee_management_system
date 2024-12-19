import controllers.EmployeeController;
import repositories.ArrayEmployeeRepositoryImpl;
import repositories.EmployeeRepository;
import services.EmployeeService;
import services.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new ArrayEmployeeRepositoryImpl(10);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
        EmployeeController employeeController = new EmployeeController(employeeService);
        employeeController.run();
    }
}