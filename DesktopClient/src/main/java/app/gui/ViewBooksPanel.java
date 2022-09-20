package app.gui;


import java.awt.BorderLayout;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import app.model.Book;

public class ViewBooksPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BookTableModel btm;
	private JTable table;
	
	public ViewBooksPanel(List<Book> bookList){		
		btm = new BookTableModel(bookList);
		setLayout(new BorderLayout());
		table = new JTable(btm);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void refresh() {
		btm.fireTableDataChanged();
	}
}
