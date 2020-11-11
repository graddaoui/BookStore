/*
 * Created by JFormDesigner on Tue Nov 10 15:23:20 CET 2020
 */

package gui;

import dao.DaoBook;
import entities.Book;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Ajout extends JFrame {

    public Ajout() {
        initComponents();
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    Connection conn = null ;
    private void button1ActionPerformed(ActionEvent e) throws SQLException {
       int id = Integer.parseInt(textid.getText());
       String title = texttitle.getText();
       double price = Double.parseDouble(textprice.getText());
       String author = textauthor.getText();
       String date = textdate.getText();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStore", "root", "");
       Statement stmt = conn.createStatement();
        DaoBook daobook = new DaoBook(stmt);
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setPrice(price);
        book.setTitle(title);
        book.setDate(Date.valueOf(date));


        // Image
        outputFile =new File("image\\" + inputFile.getName());

        try{

            FileInputStream instream = new FileInputStream(inputFile);
            FileOutputStream outstream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];

            int length;
            /*copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = instream.read(buffer)) > 0){
                outstream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            instream.close();
            outstream.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        book.setCover(outputFile.getPath().replace("\\", "\\\\"));

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
        int returnVal = fc.showOpenDialog(Ajout.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            inputFile = fc.getSelectedFile();

            String filename = inputFile.getAbsolutePath();
            textField1.setText(filename);
            // Image getAbsolutePath = null ;
            ImageIcon icon = new ImageIcon(filename);

            Image image = icon.getImage().getScaledInstance(label7.getWidth(),label7.getHeight(),Image.SCALE_SMOOTH);
            label7.setIcon(icon);


        }
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
        label6 = new JLabel();
        button3 = new JButton();
        label7 = new JLabel();
        textField1 = new JTextField();

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

        //---- label6 ----
        label6.setText("Cover");

        //---- button3 ----
        button3.setText("Open File");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- textField1 ----
        textField1.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
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
                                .addComponent(label5)
                                .addComponent(label6))))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textauthor)
                                .addComponent(textdate)
                                .addComponent(texttitle)
                                .addComponent(textprice)
                                .addComponent(textid)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(button3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addGap(58, 58, 58)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textauthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(61, 61, 61)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(textdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(33, 33, 33))
                        .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(button3)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26))
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
    private JLabel label6;
    private JButton button3;
    private JLabel label7;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JFileChooser fc;

    private File inputFile;
    private File outputFile;

}
