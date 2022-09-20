package app.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public BookController() throws IOException {
		bookService = new BookService();
		loadBooklist();
		createPanel = new CreateBookPanel();
		viewPanel = new ViewBooksPanel(bookList);
		createPanel.setFormListener((title, author) -> {
			try {
				bookService.sendBook(new Book(title,author));
				refresh();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		mainFrame = new MainFrame(createPanel, viewPanel);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				refresh();
			}
		});
	}
	
	protected void loadBooklist() {
		bookList.clear();
		try {
			bookList.addAll(bookService.getAll());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void refresh() {
		loadBooklist();
		viewPanel.refresh();
	}	
}
