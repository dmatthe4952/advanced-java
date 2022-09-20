package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Book;
import app.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService books;

	@GetMapping("/books")
	public List<Book> books() {
		List<Book> returnedBooks = books.getAll();
		return returnedBooks;
	}
	
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		books.createBook(book);
		return book;
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		return books.getBook(id);
	}
	
	@DeleteMapping("books/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		books.deleteBook(id);
		return "Deleted Book with the id " + id;
	}
}
