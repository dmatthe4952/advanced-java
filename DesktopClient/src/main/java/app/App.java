package app;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.controllers.BookController;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
		new BookController();
		});
	}
}
