package org.isbn.bk;

import java.util.Date;

public class Book {
	private int id;
	private String name;
	private String publisher;
	private String author;
	private double price;
	private Date published;
	private String isbnNumber;
	public Book(String name, String publisher, String author, double price, Date published, String isbnNumber) {
		super();
		this.name=name;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.published = published;
		this.isbnNumber = isbnNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	public String getIsbnNumber() {
		return isbnNumber;
	}
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
}
