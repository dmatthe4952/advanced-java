package maven_project.eclpse_maven_DAO;

import java.sql.SQLException;

public class DAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DAOException(SQLException e) {
		super(e);
	}
}
