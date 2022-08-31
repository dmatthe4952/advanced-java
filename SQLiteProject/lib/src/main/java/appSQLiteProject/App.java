package appSQLiteProject;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args){
		try {
			int[] ids = {1,2,3,4};
			String[] names = {"Bob", "Ted", "Carol", "Alice"};
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/people?useSSL=false";	
			
			var conn = DriverManager.getConnection(dbUrl, "root", "password");
			conn.setAutoCommit(false);
			
			var stmt = conn.createStatement();
			
			
			var sql = "insert into user (id, name) values(?, ?)";
			var insertStatement = conn.prepareStatement(sql);
			
			for(int i = 0; i < ids.length; i++) {
				insertStatement.setInt(1, ids[i]);
				insertStatement.setString(2, names[i]);
				
//				insertStatement.executeUpdate();
			}
			insertStatement.close();
			conn.commit();
			
			sql = "select id, name from user";
			var rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name =  rs.getString("name");
				
				System.out.println(id + " | " + name);
			}
			
			stmt.close();
			conn.close();
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
