package maven_project.eclpse_maven_DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	void save(T t);
	Optional<T> findById(int id);
	void update(T t);
	void delete(T t);
	List<T> getAll();

}
