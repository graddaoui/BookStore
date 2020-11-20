package step2.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import step2.entities.Book;
import step2.entities.Client;
import step2.entities.Order;

public class DaoOrder {

    private Statement stmt;

    public DaoOrder(Statement stmt) {
        this.stmt = stmt;
    }

    public void addOrder (List<Book> bookList, Client client) throws SQLException {

        String clientQuery = "INSERT INTO client (name, last_name, email, adress, tel) VALUES ('"+ client.getName()  + "', '" + client.getLastName() + "', '" + client.getEmail() + "', '" + client.getAdress() + "', '" + client.getTel() + "')";
        stmt.executeUpdate(clientQuery);

        for(Book book : bookList) {
            String query = "INSERT INTO orders (order_date, book_id, client_id) VALUES ('"+ new Date(System.currentTimeMillis())  + "', '" + book.getId() + "', '" + client.getId() + "')";
            stmt.executeUpdate(query);
        }

    }

    public List<Order> listOfOrders() throws SQLException {
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
