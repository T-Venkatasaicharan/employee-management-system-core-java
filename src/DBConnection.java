import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/employee_db";
			String username = System.getenv("DB_USER");
			String password = System.getenv("DB_PASS");
			return DriverManager.getConnection(url, username, password);
			
		}catch(Exception e) {
			throw new RuntimeException("Database connection failed", e);
		}
	}
}
