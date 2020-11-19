package entities;

import java.sql.Date;

public class Book {
	private int id;
	private String title;
	private double price;
	private String author;
	private String cover;
	private Date releaseDate;
	
	public Book() {
		
	}
	
	public Book(int id, String title, double price, String author, Date releaseDate) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + ", date=" + releaseDate +" , cover ="+this.cover + "]";
	}

}
