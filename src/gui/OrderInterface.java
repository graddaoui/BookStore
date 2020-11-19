/*
 * Created by JFormDesigner on Mon Nov 16 14:09:58 CET 2020
 */

package gui;

import dao.DaoBook;
import dao.DaoOrder;
import entities.Book;
import entities.Client;
import main.DatabaseConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class OrderInterface extends JFrame {
	Statement stmt = DatabaseConnection.getInstance().createStatement();
    List<Integer> ids = new ArrayList<>();

    public List<Book> l ;
    DefaultListModel jlist1Model;

    public OrderInterface() throws SQLException {
        initComponents();

        DaoBook daoBook = new DaoBook(stmt);
        List<Book> listbook = daoBook.listBook();
        l=listbook ;
        jlist1Model = new DefaultListModel();


        for (Book b: listbook)
        {
            jlist1Model.addElement(b.getTitle());

        }
        list1.setModel(jlist1Model);
    }

    private void button4ActionPerformed(ActionEvent e) {
       this.dispose();
       new HomeInterace().show();
    }

    private void button5ActionPerformed(ActionEvent e) {
        for (Book book : l)
        {
            if (list1.getSelectedValue().equals(book.getTitle()))
            {
                ids.add(book.getId());
                JOptionPane.showMessageDialog(null,"Book selected");
            }
        }
    }

    private void button3ActionPerformed(ActionEvent e) throws SQLException {
   
        int id = 0 ;
       PreparedStatement st = DatabaseConnection.getInstance().prepareStatement("SELECT * FROM client");
       ResultSet res = st.executeQuery();
       while (res.next())
       {
           id = res.getInt("id");
       }

   


        Client c = new Client();
       c.setId(id+1);
   c.setName(textField1.getText());
   c.setLastName(textField2.getText());
   c.setEmail(textField3.getText());
   c.setAdress(textField4.getText());
   c.setTel(textField5.getText());
   int aux ;
   for (Book h : l )
   {
       aux = h.getId();
   }
   List<Book> booklist = new ArrayList<>();

   for ( Book bo : l)
   {
       for ( int i : ids) {
           if (i==bo.getId())
               booklist.add(bo);
       }
   }
        DaoOrder daoOrder = new DaoOrder(stmt);
        daoOrder.addOrder(booklist,c);
       JOptionPane.showMessageDialog(null,"Order Saved , Thank you !");

    }

    private void button6ActionPerformed(ActionEvent e) {
        double total = 0 ; 
        for (Book g : l) 
        {
            for (int j : ids) 
            {
                if (j==g.getId())
                    total+=g.getPrice();
            }
        }
        textField6.setText(total+"");
    }

    private void initComponents() throws SQLException {
        

        this.getContentPane().setBackground(Color.lightGray);
        
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        label6 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        textField6 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    " "
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("Name");

        //---- label2 ----
        label2.setText("Last Name");

        //---- label3 ----
        label3.setText("E_mail");

        //---- label4 ----
        label4.setText("Adress");

        //---- label5 ----
        label5.setText("Phone N\u00b0");

        //---- button3 ----
        button3.setText("Make an order");
        button3.addActionListener(e -> {
            try {
                button3ActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //---- button4 ----
        button4.setText("Back");
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- label6 ----
        label6.setIcon(new ImageIcon("assets/oie_16164739H6QWIK7m.png"));

        //---- button5 ----
        button5.setText("Select");
        button5.addActionListener(e -> button5ActionPerformed(e));

        //---- button6 ----
        button6.setText("Check Total Price");
        button6.addActionListener(e -> button6ActionPerformed(e));

        //---- textField6 ----
        textField6.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField6, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(button6, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(button5, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label1))
                            .addGap(47, 47, 47)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField1)
                                .addComponent(textField2)
                                .addComponent(textField3)
                                .addComponent(textField4)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 655, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button5))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(button6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button4))
                            .addGap(35, 35, 35))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                    .addGap(20, 20, 20))
        );
        pack();
        setLocationRelativeTo(getOwner());
       
    }

   
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button3;
    private JButton button4;
    private JLabel label6;
    private JButton button5;
    private JButton button6;
    private JTextField textField6;
    
}
