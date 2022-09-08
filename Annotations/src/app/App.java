package app;

public class App {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		var user = new User(0L, "Thor");
		
		var rep = new Repository();
		rep.save(user);
	}

}
