package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import entities.User;
import repositories.UserDao;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void run(String... args) throws Exception {
//		 var user1 = new User("Morpheus", "morph@example.com");
//		 userDao.save(user1);
//		 userDao.deleteById(2L);
//		 userDao.deleteById(3L);
//		 userDao.deleteById(4L);
//		 userDao.deleteById(5L);
		 
		 userDao.findAll().forEach(u -> System.out.println(u));
		
	}

}
