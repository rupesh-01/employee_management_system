package controllers;

import models.Department;
import models.Employee;
import repositories.DepartmentRepository;
import services.EmployeeService;
import views.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            EmployeeView.displayMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    employeeMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting System . GoodBye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("invalid choice, please try again !");

            }
        }
    }

    private void adminMenu(Scanner scanner) {
        while (true) {
            EmployeeView.displayAdminMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
//                    System.out.print("Enter Department Name: ");
//                    String department = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    int salary = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Emergency Contact Number: ");
                    String emergencyContact = scanner.nextLine();
                    Employee addedEmployee = employeeService.addEmployee(new Employee(id, name, salary, emergencyContact));
                    System.out.println("Employee added successfully! " + addedEmployee);
                    break;
                case 2:
                    List<Employee> employees = employeeService.getEmployees();
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    break;
                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();
                    boolean isDeleted = employeeService.deleteEmployee(employeeId);
                    if (isDeleted) System.out.println("Employee Deleted Successfully");
                    break;
                case 4:
                    System.out.print("Enter Employee's ID to be updated: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee's New Department: ");
                    String newDepartment = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    int newSalary = scanner.nextInt();
                    scanner.nextLine();
                    Employee updateEmployee = employeeService.updateEmployee(empId, newDepartment, newSalary);
                    System.out.println(updateEmployee);
                    break;
                case 5:
                    System.out.println("Enter Department id : ");
                    int departmentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter empoyee id");
                    int employeeeId = scanner.nextInt();
                    scanner.nextLine();
                    Employee employee = employeeService.assignDepartment(employeeeId, departmentId);
                    System.out.println("Assigned the dept successfully" + employee);
                    break;
                case 6:
                    System.out.println("Logging out from Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void employeeMenu(Scanner scanner) {
        while(true) {
            EmployeeView.displayEmployeeMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your Employee Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(employeeService.getEmployeeById(id));
                    break;
                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Emergency Contact: ");
                    String newContact = scanner.nextLine();
                    System.out.println(employeeService.updateEmployeeEmergencyContact(empId, newContact));
                    break;
                case 3:
                    System.out.println("Logging out from User Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
