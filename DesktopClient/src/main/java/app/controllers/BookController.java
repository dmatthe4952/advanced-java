package app.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import app.gui.CreateBookPanel;
import app.gui.MainFrame;
import app.gui.ViewBooksPanel;
import app.model.Book;
import app.services.BookService;

public class BookController {
	private CreateBookPanel createPanel;
	private ViewBooksPanel viewPanel;
	private BookService bookService;
	private MainFrame mainFrame;
	private final List<Book> bookList = new ArrayList<>();
	
	public BookController() {
		bookService = new BookService();
		loadBooklist();
		System.out.println("Book list just loaded.");
		createPanel = new CreateBookPanel();
		viewPanel = new ViewBooksPanel(bookList);
		createPanel.setFormListener((title, author) -> {
			try {
				bookService.sendBook(new Book(title,author));
				refresh();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mainFrame, "2.Error getting data", "Could not retrieve data.", JOptionPane.ERROR_MESSAGE);
			}
		});
		mainFrame = new MainFrame(createPanel, viewPanel);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				loadBooklist();
			}
		});
	}
	
	protected void loadBooklist() {
		bookList.clear();
		try {
			bookList.addAll(bookService.getAll());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(mainFrame, "1.Error getting data", "Could not retrieve data.", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	protected void refresh() {
		loadBooklist();
		viewPanel.refresh();
	}	
}
