package maven_project.eclpse_maven_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database db = new Database();
	private static final String dbUrl = "jdbc:mysql://localhost:3306/people?useSSL=false";
	private Connection conn;

	public static Database instance() {
		return db;
	}

	private Database() {

	}
	
	public void connect() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
			
		conn = DriverManager.getConnection(dbUrl, "root", "password");
		conn.setAutoCommit(false);

	}
	
	public void close() throws SQLException {
		conn.close();
	}

}
