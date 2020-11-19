package entities;

import java.sql.Date;

public class Order {
	private int id;
	private Date orderDate;
	private int bookId;
	private int clientId;
	
	public Order() {
		
	}
	
	public Order(int id, Date orderDate, int bookId, int clientId) {
		this.id = id;
		this.orderDate = orderDate;
		this.bookId = bookId;
		this.clientId = clientId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	
	
	
}
