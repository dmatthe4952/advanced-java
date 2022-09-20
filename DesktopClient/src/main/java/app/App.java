package app;

import java.io.IOException;

import javax.swing.SwingUtilities;

import app.controllers.BookController;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new BookController();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
