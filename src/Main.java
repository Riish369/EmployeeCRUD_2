import dao.EmployeeDAO;
import model.Employee;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        dao.createTable();

        while (true) {
            System.out.println("\n==== EMPLOYEE MANAGEMENT ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Name");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Employee Address: ");
                    String address = sc.nextLine();
                    dao.insertEmployee(new  Employee(name, address));
                    System.out.println("Employee has been inserted.");
                    break;

                 /*DOUBT DOUBT DOUBT*/
                case 2:
                List<Employee> employees = dao.getAll();
                for (Employee employee : employees) {
                    System.out.println(employee);
                }
                break;

                case 3:
                    System.out.print("Old Name: ");
                    String oldName = sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    dao.updateEmployee(newName, oldName);
                    System.out.println("Updated Successfully");
                    break;

                case 4:
                    System.out.print("Enter Name to Delete: ");
                    String delName = sc.nextLine();
                    dao.deleteEmployee(delName);
                    System.out.println("Deleted Successfully");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}