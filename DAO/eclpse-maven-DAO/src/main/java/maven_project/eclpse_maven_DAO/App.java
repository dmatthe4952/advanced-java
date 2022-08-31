package maven_project.eclpse_maven_DAO;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		var db = Database.instance();
		try {
			db.connect();			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Cannot connect to database.");			
//			e.printStackTrace();
		}
		
		System.out.println("Connected.");
		
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close database connection.");
//			e.printStackTrace();
		}
	}
}
