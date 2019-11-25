package org.mql.biblio.models;

import java.util.List;
import java.util.Vector;

public class Document {
	private String isbn;
	private String title;
	private int yearPublished;
	private Publisher publisher;
	private List<Author> authors;
	
	public Document() {
		authors = new Vector<Author>();
	}

	public Document(String isbn) {
		super();
		this.isbn = isbn;
		authors = new Vector<Author>();
	}
	
	public Document(String isbn, String title, int yearPublished) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		authors = new Vector<>();
	}
	
	public Document(String isbn, String title, int yearPublished, Publisher publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		this.publisher = publisher;
		authors = new Vector<>();
	}

	public Document(String isbn, String title, int yearPublished, Publisher publisher, List<Author> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		this.publisher = publisher;
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(Author author) {
		authors.add(author);
	}
	
	public String toString() {
		return "Title [isbn=" + isbn + ", title=" + title + ", yearPublished=" + yearPublished + ", publisher="
				+ publisher + ", authors=" + authors + "]";
	}
}
