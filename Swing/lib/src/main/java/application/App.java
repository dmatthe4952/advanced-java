package application;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import controller.Controller;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new Controller();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
