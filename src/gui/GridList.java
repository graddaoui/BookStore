/*
 * Created by JFormDesigner on Tue Nov 10 16:35:09 CET 2020
 */

package gui;

import java.awt.event.*;
import dao.DaoBook;
import entities.Book;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class GridList extends JFrame {
    public Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","12345") ;
    public GridList() throws SQLException, IOException {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        this.dispose();
        new Acceuil().show();
    }

    private void button3ActionPerformed(ActionEvent e) {
        DefaultTableModel table = (DefaultTableModel) table1.getModel();
        int row = table1.getSelectedRow();
        System.out.println(row);
        String id = (table.getValueAt(row,0).toString());
        String title = table.getValueAt(row,1).toString();
        String price = (table.getValueAt(row,2).toString());
        String author = table.getValueAt(row,3).toString();
        String auxDate = table.getValueAt(row,4).toString();
        idf.setText(id);

    }

    private void button2ActionPerformed(ActionEvent e) throws SQLException {
        DefaultTableModel table = (DefaultTableModel) table1.getModel();
        int col = 0 ;
        int row = table1.getSelectedRow();
        System.out.println(row);
        int id = Integer.parseInt(table.getValueAt(row,col).toString());
        System.out.println(id);

        Statement stmt = conn.createStatement();
       DaoBook daoBook = new DaoBook(stmt);
       if (!(daoBook.deleteBook(id))) {
           JOptionPane.showMessageDialog(null, "deleted");
           table.getDataVector().removeAllElements();
           table.fireTableDataChanged();
       }
       ////////////////////////////////////////////////////
        ///// mise a jour du grid
        ////////////////////////////////////////////////////
        List<Book> liste = daoBook.listBook();
       for (Book b : liste){
           Object [] o = new Object[6] ;
           o[0]=b.getId();
           o[1]=b.getTitle();
           o[2]=b.getPrice();
           o[3]=b.getAuthor();
           o[4]=b.getDate();
           o[5]=b.getCover();
           table.addRow(o);
       }

    }

    private void button4ActionPerformed(ActionEvent e) throws SQLException, ParseException {
        DefaultTableModel table = (DefaultTableModel) table1.getModel();
        int row = table1.getSelectedRow();
        int id = Integer.parseInt(table.getValueAt(row,0).toString());
        Statement stmt = conn.createStatement();
        DaoBook daoBook = new DaoBook(stmt);
        Book book= new Book();
        book.setId(id);
        book.setTitle(titlef.getText());
        book.setPrice(Double.parseDouble(pricef.getText()));
        book.setAuthor(authorf.getText());
        book.setDate(Date.valueOf(datef.getText()));
        if (!(daoBook.updateBook(book)));
        System.out.println("succé");

      /* String query = "UPDATE book SET title = ? , price = ? , author = ? , releaseDate = ? WHERE id = ?" ;
        PreparedStatement stm = conn.prepareStatement(query) ;
        stm.setString(1,titlef.getText());
        stm.setDouble(2,Double.parseDouble(pricef.getText()));
        stm.setString(3,authorf.getText());
        stm.setDate(4,Date.valueOf(datef.getText()));
        stm.setInt(5, Integer.parseInt(idf.getText()));
        DaoBook daoBook = new DaoBook();
        if (!(daoBook.updateBook(stm)))
            System.out.println("succé");
*/
    }

    private void initComponents() throws SQLException, IOException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        idf = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        titlef = new JTextField();
        pricef = new JTextField();
        authorf = new JTextField();
        datef = new JTextField();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setColumnSelectionAllowed(true);
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Id", "Title", "Price", "Author", "Date", "image path"
                }
            ));
            table1.setBackground(Color.gray);
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("Retour");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Supprimer");
        button2.addActionListener(e -> {
            try {
                button2ActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //---- button3 ----
        button3.setText("Selectionner");
        button3.addActionListener(e -> {
			button3ActionPerformed(e);
			button3ActionPerformed(e);
		});

        //---- idf ----
        idf.setEditable(false);

        //---- label1 ----
        label1.setText("Id");

        //---- label2 ----
        label2.setText("Title");

        //---- label3 ----
        label3.setText("Price");

        //---- label4 ----
        label4.setText("Author");

        //---- label5 ----
        label5.setText("Date");

        //---- button4 ----
        button4.setText("Update");
        button4.addActionListener(e -> {
            try {
                button4ActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(191, Short.MAX_VALUE)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label2)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(authorf, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(pricef, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(titlef, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(datef, GroupLayout.Alignment.LEADING)
                                .addComponent(idf, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addGap(127, 127, 127)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button3)
                            .addGap(63, 63, 63)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(idf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(titlef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(pricef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(authorf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(datef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1)
                        .addComponent(button3)
                        .addComponent(button4))
                    .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        /////////////////////////////////////////////////////////////////////////////////////////////
        //////// Fetching Data
        //////////////////////////////////////////////////////////////////////////////////////////////
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStore", "root", "12345");
        Statement stmt = conn.createStatement();
        DaoBook daoBook = new DaoBook(stmt);
        List<Book> listbook = daoBook.listBook();
        DefaultTableModel dt = (DefaultTableModel) table1.getModel();

        for (Book b : listbook)
        {
        Object[] ob = new Object[6];
        ob[0]=b.getId();
        ob[1]=b.getTitle();
        ob[2]=b.getPrice();
        ob[3]=b.getAuthor();
        ob[4]=b.getDate();
        ImageIcon ic = new ImageIcon(b.getCover());
        Image img = ic.getImage().getScaledInstance(10,10,Image.SCALE_SMOOTH);
        ob[5]= new ImageIcon(img);
        dt.addRow(ob);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField idf;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField titlef;
    private JTextField pricef;
    private JTextField authorf;
    private JTextField datef;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
