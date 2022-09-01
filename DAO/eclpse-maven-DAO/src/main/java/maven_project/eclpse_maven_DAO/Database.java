package maven_project.eclpse_maven_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	private static Database db = new Database();
	private Connection conn;

	public static Database instance() {
		return db;
	}

	private Database() {
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void connect(Properties props) throws ClassNotFoundException, SQLException {	
		String server = props.getProperty("server");
		String port = props.getProperty("port");
		String database = props.getProperty("database");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String url = "jdbc:mysql://"+ server + ":" + port + "/" + database + "?useSSL=false";
		
		System.out.println("Server: "+ server + " port: " + port + " database: " + database);
		try {
			conn = DriverManager.getConnection(url, user, password);
			if (conn == null) {
				throw new SQLException("Timeout");
			}
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database.");
			System.exit(1);
		}
		
		conn.setAutoCommit(false);
	}
	
	public void close() throws SQLException {
		conn.close();
	}

}
