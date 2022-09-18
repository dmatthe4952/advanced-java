package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {

	}

	@Override
	public void save(User u) {
		var conn = Database.instance().getConnection();
		var sql = "insert into user (name, password) values(?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.executeUpdate();
			stmt.close();
			conn.commit();
		}catch (SQLException e){
			throw new DAOException(e);
		}
	}

	@Override
	public Optional<User> findById(int id) {
		var conn = Database.instance().getConnection();
		var sql = "select * from user where id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("id");
				String userName = rs.getString("name");
				String password = rs.getString("password");
				User user = new User(userId , userName, password);
				return Optional.of(user);
			}
		}catch (SQLException e){
			throw new DAOException(e);
		}
		return null;
	}

	@Override
	public void update(User t) {
		var conn = Database.instance().getConnection();
		var sql = "update user set name=?, password=? where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, t.getName());
			stmt.setString(2, t.getPassword());
			stmt.setInt(3, t.getId());
			stmt.executeUpdate();
			conn.commit();
		}catch (SQLException e){
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(User t) {
		var conn = Database.instance().getConnection();
		var sql = "delete from user where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, t.getId());
			stmt.executeUpdate();
			conn.commit();
		}catch (SQLException e){
			throw new DAOException(e);
		}

	}

	@Override
	public List<User> getAll() {
		var conn = Database.instance().getConnection();
		var sql = "select id, name, password from user order by id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			List<User> users = new ArrayList<>();
			var rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				User user = new User(id,name, password);
				users.add(user);
			}
			return users;
		}catch (SQLException e){
			throw new DAOException(e);
		}

	}
}
