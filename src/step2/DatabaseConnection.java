package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{

private static String url = "jdbc:mysql://localhost:3306/BookStore";
private static String user = "root";
private static String passwd = "";
private static Connection connect;
 
public static Connection getInstance(){
  if(connect == null){
    try {
      connect = DriverManager.getConnection(url, user, passwd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }      
  return connect;
}   
}
