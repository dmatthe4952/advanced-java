package maven_project.eclpse_maven_DAO;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserDaoImpli {
	private Connection conn;
	List<User> users = new ArrayList<>();
	private static final int NUM_TEST_USERS = 1000;
	
	private List<User> loadUsers() throws IOException {
		
		return Files
				.lines(Paths.get("../../potentialUsersFile.txt"))
				.map(line -> line.split("[^A-Za-z]"))
				.map(Arrays::asList)
				.flatMap(list -> list.stream())
				.filter(word -> word.length() > 3 && word.length() < 20)
				.map(word -> new User(word))
				.limit(NUM_TEST_USERS)
				.collect(Collectors.toList());
	}
	
	public int getMaxIdInUser() throws SQLException {
		var rs = conn.createStatement().executeQuery("select max(id) as id from user");
		rs.next();
		return rs.getInt("id");
	}
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException, IOException {
		users = loadUsers();
		Properties props = Profile.getProperties("db");
		var db = Database.instance();
		db.connect(props);
		conn = db.getConnection();
		conn.setAutoCommit(false);
	}
	
	@After
	public void tearDown() throws SQLException {
		Database.instance().close();
	}
	
	@Test
	public void testSave() throws SQLException {
		var dao = new UserDAOImpl();
		var user = new User("Frank");
		dao.save(user);
		var stmt = conn.createStatement();
		var rs = stmt.executeQuery("select id, name from user order by id desc");
		var result = rs.next();
		assertTrue("Cannot retrieve user", result);
		var name = rs.getString("name");
		assertEquals("User is not the same.", user.getName(), name);
	}
	
	@Test
	public void testGetMultipleUsers() throws SQLException {
		var dao = new UserDAOImpl();
		for (User u : users) {
			dao.save(u);
		}
		int startingId = (getMaxIdInUser() - users.size() + 1);
		for (int i =  0; i < users.size(); i++) {
			users.get(i).setId(startingId + i);
		}
		assertEquals("Last user id does not equal highest id in user table", users.get(users.size() - 1).getId(), getMaxIdInUser());
		assertEquals("Users not in database", dao.getAll(), users);
	}
	
	@Test
	public void testFindById() {
		
	}

}
