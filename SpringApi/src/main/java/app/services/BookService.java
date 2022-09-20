package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Book;
import app.repositories.BookDao;

@Service
public class BookService{
	@Autowired
	private BookDao bookDao;
	
	public List<Book> getAll(){
		return (List<Book>) bookDao.findAll();
	}
	
	public Book createBook(Book book) {
		return bookDao.save(book);
	}
	
	public Book getBook(Long id) {
		var bookOpt = bookDao.findById(id);
		if (bookOpt.isPresent()) {
			return bookOpt.get();
		}
		return null;
	}
	
	public String deleteBook(Long id) {
		bookDao.deleteById(id);
		if (bookDao.existsById(id)){
			return "A problem occured deleting the book.";
		}
		return "Book " + id + " has been deleted.";
	}

}
