package app;

@Entity(value = "user")
public class User {
	@Field(columnName="id", isKey=true)
	private Long id;
	
	@Field(columnName="name")
	private String name;
	
	@Field(columnName="password")
	private String password;
	

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
}
