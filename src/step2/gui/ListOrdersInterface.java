/*
 * Created by JFormDesigner on Tue Nov 17 12:41:11 CET 2020
 */

package step2.gui;

import step2.dao.DaoOrder;
import step2.entities.Book;
import step2.entities.Order;
import step2.DatabaseConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class ListOrdersInterface extends JFrame {

	public ListOrdersInterface() throws SQLException {
		initComponents();
	}

	private void button1ActionPerformed(ActionEvent e) {
		this.dispose();
		new HomeInterace().show();
	}

	private void initComponents() throws SQLException {
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		label1 = new JLabel();

		// ======== this ========
		Container contentPane = getContentPane();

		// ======== scrollPane1 ========
		{

			// ---- table1 ----
			table1.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Order_Date", "Book_Id", "Client_Id" }));
			scrollPane1.setViewportView(table1);
		}

		// ---- button1 ----
		button1.setText("Back");
		button1.addActionListener(e -> button1ActionPerformed(e));

		// ---- label1 ----
		label1.setIcon(new ImageIcon("assets/coverliste.jpg"));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup()
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
				.addGroup(contentPaneLayout.createSequentialGroup().addGap(286, 286, 286)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						contentPaneLayout.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE)
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE).addGap(12, 12, 12)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28).addComponent(button1)));
		pack();
		setLocationRelativeTo(getOwner());
		
		Statement stmt = DatabaseConnection.getInstance().createStatement();
		DaoOrder dao = new DaoOrder(stmt);
		List<Order> listOfOrders = dao.listOfOrders();
		DefaultTableModel dt = (DefaultTableModel) table1.getModel();
		for (Order o : listOfOrders) {
			Object[] ob = new Object[3];
			ob[0] = o.getOrderDate();
			ob[1] = o.getBookId();
			ob[2] = o.getClientId();
			dt.addRow(ob);
		}
	}

	
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JLabel label1;
}
