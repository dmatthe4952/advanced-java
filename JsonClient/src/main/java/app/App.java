package app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

public class App {

	public static void main(String[] args) {

		var url = "http://localhost:8080/users/users";
		
		try {
			var json = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));
			 
			Gson gson = new Gson();
			
			var users = gson.fromJson(json, User[].class);
			for (User user : users) {
				System.out.println(user);
			}
			
		} catch (MalformedURLException e) {
			System.out.println("The given url is incorrectly formatted. "  + e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception Thrown contacting url /users: " + e.getMessage());
		}
	}

}
