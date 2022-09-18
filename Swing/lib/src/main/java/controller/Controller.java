package controller;

import java.sql.SQLException;
import java.util.Properties;

import gui.MainFrame;
import gui.MainPanel;
import model.Database;
import model.Profile;
import model.User;
import model.UserDAOImpl;

public class Controller {
	private MainFrame mainFrame;
	private MainPanel mainPanel;

	public Controller( ) throws ClassNotFoundException, SQLException {
		Properties props = Profile.getProperties("db");
		
		var db = Database.instance();
		db.connect(props);
		System.out.println("Connected");
		
		mainPanel = new MainPanel();
		mainPanel.setFormListener((username, password) -> {
			var user = new User(username, password);
			var dbo = new UserDAOImpl();
			dbo.save(user);
		});
		mainFrame = new MainFrame();
		mainFrame.setContentPane(mainPanel);
		
	}
}
