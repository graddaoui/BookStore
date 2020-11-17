package dao;

import entities.Book;
import entities.Client;
import entities.Order;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoCommande {

    private Statement stmt;

    public DaoCommande(Statement stmt) {
        this.stmt = stmt;
    }

    public void addCommande (List<Book> bookList, Client client) throws SQLException {

        String clientQuery = "INSERT INTO client (name, last_name, email, adress, tel) VALUES ('"+ client.getName()  + "', '" + client.getLastName() + "', '" + client.getEmail() + "', '" + client.getAdress() + "', '" + client.getTel() + "')";
        stmt.executeUpdate(clientQuery);

        for(Book book : bookList) {
            String query = "INSERT INTO orders (order_date, book_id, client_id) VALUES ('"+ new Date(System.currentTimeMillis())  + "', '" + book.getId() + "', '" + client.getId() + "')";
            stmt.executeUpdate(query);
        }

    }

    public List<Order> listCommande() throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from orders");
        List<Order> list = new ArrayList<>();

        while (rs.next()) {
            Order order = new Order();

            order.setId(rs.getInt("id"));
            order.setBookId(rs.getInt("book_id"));
            order.setClientId(rs.getInt("client_id"));
            order.setOrderDate(rs.getDate("order_date"));

            list.add(order);
        }

        return list;
    }
}
