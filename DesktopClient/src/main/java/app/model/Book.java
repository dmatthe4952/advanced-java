package app.model;

import java.util.Objects;

public class Book {
	private Long id;
	
	private String title;
	
	private String author;
	
	public Book() {		
	}

	public Book(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}
	
	public int getColumnCount() {
		return 3;
	}
	
	
}
