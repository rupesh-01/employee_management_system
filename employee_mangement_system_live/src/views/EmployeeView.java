package views;

public class EmployeeView {

    public static void displayMainMenu(){
        System.out.println("\n--- Employee Management System ---");
        System.out.println("1. Admin Login");
        System.out.println("2. Employee  Login");
        System.out.println("3. EXIT ");
        System.out.println("Enter your choice");
    }

    public static void displayAdminMenu(){
        System.out.println("\n--- Welcome Admin ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        //System.out.println("3. View Employee by Id");
        System.out.println("3. Delete Employee ");
        System.out.println("4. Update Employee");
        System.out.println("5. Assign Department");
        System.out.println("5. Logout");
        System.out.println("Enter your choice");
    }

    public static void displayEmployeeMenu(){
        System.out.println("\n--- Employee Menu ---");
        System.out.println("1. View Own Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
    }
}
