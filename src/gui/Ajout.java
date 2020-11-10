/*
 * Created by JFormDesigner on Tue Nov 10 15:23:20 CET 2020
 */

package gui;

import dao.DaoBook;
import entities.Book;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Ajout extends JFrame {
    public Ajout() {
        initComponents();
    }
    Connection conn = null ;
    private void button1ActionPerformed(ActionEvent e) throws SQLException {
       int id = Integer.parseInt(textid.getText());
       String title = texttitle.getText();
       double price = Double.parseDouble(textprice.getText());
       String author = textauthor.getText();
       String date = textdate.getText();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStore", "root", "12345");
       Statement stmt = conn.createStatement();
        DaoBook daobook = new DaoBook(stmt);
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setPrice(price);
        book.setTitle(title);
        book.setDate(Date.valueOf(date));
        daobook.addBook(book);
        JOptionPane.showMessageDialog(null,"ajout avec succé");
    /*;
     String query = "INSERT INTO book (id, title, price, author, releaseDate) VALUES (" + id+ ", '"
             + title+ "', '" + price + "', '" + author + "', '" + Date.valueOf(date)
             + "')";
        PreparedStatement st = conn.prepareStatement(query);
        st.execute();
*/
    }

    private void button2ActionPerformed(ActionEvent e) {
        this.dispose();
        new Acceuil().show();
    }

    private void button3ActionPerformed(ActionEvent e) {
        this.dispose();
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textid = new JTextField();
        texttitle = new JTextField();
        textprice = new JTextField();
        textauthor = new JTextField();
        textdate = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("     Id");

        //---- label2 ----
        label2.setText("Title");

        //---- label3 ----
        label3.setText("Price");

        //---- label4 ----
        label4.setText("Author");

        //---- label5 ----
        label5.setText("Date");

        //---- button1 ----
        button1.setText("Ajouter");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //---- button2 ----
        button2.setText("Retour");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2)
                                .addComponent(label4)
                                .addComponent(label5))))
                    .addGap(44, 44, 44)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(textauthor)
                        .addComponent(textdate)
                        .addComponent(textid, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addComponent(texttitle)
                        .addComponent(textprice))
                    .addGap(58, 58, 58)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                    .addGap(161, 161, 161))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(texttitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(button1)))
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(button2)
                        .addComponent(textprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textauthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(82, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textid;
    private JTextField texttitle;
    private JTextField textprice;
    private JTextField textauthor;
    private JTextField textdate;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
