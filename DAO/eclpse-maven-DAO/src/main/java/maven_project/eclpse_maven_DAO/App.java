package maven_project.eclpse_maven_DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Properties props = Profile.getProperties("db");
		
		var db = Database.instance();
		try {
			db.connect(props);			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Cannot connect to database.");			
			System.exit(1);
		}
		System.out.println("Connected.");
		
		var user = new User("Frank");
		var dao = new UserDAOImpl();
		dao.save(user);
		
		List<User> users = dao.getAll();
		users.forEach(System.out::println);
		
		
		System.out.println("The first user is " + dao.findById(users.get(0).getId()));
		
		User u = new User("Zimmerman");
		u.setId(users.get(1).getId());
		System.out.println("Setting the name of the second user to Zimmerman.");
		dao.update(u);
		
		System.out.println("Deleting the first user.");
		dao.delete(users.get(0));
		
		List<User> users2 = dao.getAll();
		users2.forEach(System.out::println);		
		
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close database connection.");
//			e.printStackTrace();
		}
	}
}
