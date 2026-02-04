import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeManagementApp {
	static ArrayList<Employee> employees = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			System.out.println("\n**Employee Management System**");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Search Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.println("Enter choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1 -> addEmployee();
			case 2 -> viewEmployees();
			case 3 -> searchEmployee();
			case 4 -> deleteEmployee();
			case 5 -> {
				System.out.println("Exiting...");
				return;
			}
			default -> System.out.println("Invalid choice");
			}
		}
	}
	static void addEmployee() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		for (Employee e : employees) {
			if(e.getId() == id) {
				System.out.println("Employee ID already exists!");
				return;
			}
		}
		System.out.print("Enter Name: ");
		String name = sc.next();
		System.out.println("Enter Salary:");
		double salary = sc.nextDouble();
		employees.add(new Employee(id, name, salary));
		System.out.println("Employee added sucessfully");
	}
	static void viewEmployees() {
		if(employees.isEmpty()) {
			System.out.println("No employees found");
			return;
		}
		for (Employee e : employees) {
			System.out.println(e);
		}
	}
	static void searchEmployee() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		for (Employee e : employees) {
			if(e.getId() == id) {
				System.out.println(e);
				return;
			}
		}
		System.out.println("Employee not found");
	}
	static void deleteEmployee() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		for(Employee e : employees) {
			if(e.getId() == id) {
				employees.remove(e);
				System.out.println("Employee deleted");
				return;
			}
		}
		System.out.println("Employee not found");
	}
}
