import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeManagementApp {
	//static ArrayList<Employee> employees = new ArrayList<>();
	//Next update from the Array List console to DataBase connection
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
		try {
			System.out.print("Enter ID: ");
			int id = sc.nextInt();
			System.out.print("Enter Name: " );
			String name = sc.next();
			System.out.print("Enter Salary: " );
			double salary = sc.nextDouble();
			Connection con = DBConnection.getConnection();
			String query = "INSERT INTO employees(id,name,salary) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			ps.executeUpdate();
			System.out.println("Employee added sucessfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void viewEmployees() {
		try {
			Connection con = DBConnection.getConnection();
			String query = "SELECT * FROM employees";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(
						rs.getInt("id") + " "
						+ rs.getString("name") + " "
						+rs.getDouble("salary")
						);
			}
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
	static void deleteEmployee() {
		try {
			System.out.print("Enter ID: ");
			int id = sc.nextInt();
			Connection con = DBConnection.getConnection();
			String query = "DELETE FROM employees WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Employee Deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void searchEmployee() {
		try {
			System.out.print("Enter ID: " );
			int id= sc.nextInt();
			Connection con = DBConnection.getConnection();
			String query = "SELECT * FROM employees WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(
						rs.getInt("id") + " "
						+ rs.getString("name")+ " "
						+ rs.getDouble("salary")
						);
				
			}else {
				System.out.println("Employee not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
