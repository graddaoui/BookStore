package dao;

import entities.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoBook {

	private Statement stmt;

    public DaoBook (){}
	public DaoBook(Statement stmt) {
		this.stmt = stmt;
	}


	public void addBook(Book book) throws SQLException {
		String query = "INSERT INTO book (id, title, price, author, releaseDate, cover) VALUES (" + book.getId() + ", '"
				+ book.getTitle() + "', '" + book.getPrice() + "', '" + book.getAuthor() + "', '" + book.getDate()
				+ "', '" + book.getCover() + "')";
		stmt.executeUpdate(query);
	}

	public List<Book> listBook() throws SQLException {
		ResultSet rs = stmt.executeQuery("select * from book");
		List<Book> list = new ArrayList<>();

		while (rs.next()) {
			Book book = new Book();

			book.setId(rs.getInt("id"));
			book.setAuthor(rs.getString("author"));
			book.setDate(rs.getDate("releaseDate"));
			book.setPrice(rs.getDouble("price"));
			book.setTitle(rs.getString("title"));

			list.add(book);
		}

		return list;
	}
	public boolean deleteBook(int id) throws SQLException
	{
		String query = "DELETE FROM book where id = "+id ;
		return stmt.execute(query);
	}
	public boolean updateBook(Book book ) throws SQLException {
        String query = "UPDATE book SET title ='"+book.getTitle()+"', price ='"+book.getPrice()+"',author ='"+book.getAuthor()+"',releaseDate ='"+book.getDate()+"' WHERE id ='"+book.getId()+"'" ;
		return stmt.execute(query);
	}
}
