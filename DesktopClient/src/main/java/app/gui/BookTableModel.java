package app.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import app.model.Book;

public class BookTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private List<Book> bookList;


	public BookTableModel(List<Book> bookList){
		this.bookList = bookList;
	}

	@Override
	public int getRowCount() {
		return bookList.size();
	}

	@Override
	public int getColumnCount() {
		Book book = bookList.get(0);
		return book.getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "Id";
			case 1:
				return "Title";
			case 2:
				return "Author";
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book book = bookList.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return book.getId();
			case 1: 
				return book.getTitle();
			case 2:
				return book.getAuthor();
		}
		return null;
	}
	
}
