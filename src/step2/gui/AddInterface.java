/*
 * Created by JFormDesigner on Tue Nov 10 15:23:20 CET 2020
 */

package step2.gui;
import step2.DatabaseConnection;
import step2.dao.DaoBook;
import step2.entities.Book;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class AddInterface extends JFrame {

	public AddInterface() {
		initComponents();
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	private void button1ActionPerformed(ActionEvent e) throws SQLException {
		String title = texttitle.getText();
		double price = Double.parseDouble(textprice.getText());
		String author = textauthor.getText();
		String date = textdate.getText();
		Statement stmt = DatabaseConnection.getInstance().createStatement();

		DaoBook daobook = new DaoBook(stmt);
		Book book = new Book();

		book.setAuthor(author);
		book.setPrice(price);
		book.setTitle(title);
		book.setReleaseDate(Date.valueOf(date));

		outputFile = new File(inputFile.getName());

		try {

			FileInputStream instream = new FileInputStream(inputFile);
			FileOutputStream outstream = new FileOutputStream(outputFile);

			byte[] buffer = new byte[1024];

			int length;

			while ((length = instream.read(buffer)) > 0) {
				outstream.write(buffer, 0, length);
			}

			instream.close();
			outstream.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		book.setCover(textField1.getText());

		daobook.addBook(book);

		JOptionPane.showMessageDialog(null, "Book Added");

	}

	private void button2ActionPerformed(ActionEvent e) {
		this.dispose();
		new HomeInterace().show();
	}

	private void button3ActionPerformed(ActionEvent e) {
		int returnVal = fc.showOpenDialog(AddInterface.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			inputFile = fc.getSelectedFile();

			String filename = inputFile.getAbsolutePath();
			textField1.setText(filename);

			ImageIcon icon = new ImageIcon(filename);
			System.out.println(filename);
			Image image = icon.getImage().getScaledInstance(label7.getWidth(), label7.getHeight(), Image.SCALE_SMOOTH);
			label7.setIcon(new ImageIcon(image));

		}
	}

	private void initComponents() {

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
		label8 = new JLabel();

		// ======== this ========
		setBackground(UIManager.getColor("Button.default.endBackground"));
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ---- label1 ----
		label1.setText("     Id");
		contentPane.add(label1);
		label1.setBounds(380, 55, 37, label1.getPreferredSize().height);

		// ---- label2 ----
		label2.setText("Title");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(380, 115), label2.getPreferredSize()));

		// ---- label3 ----
		label3.setText("Price");
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(380, 175), label3.getPreferredSize()));

		// ---- label4 ----
		label4.setText("Author");
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(380, 235), label4.getPreferredSize()));

		// ---- label5 ----
		label5.setText("Date");
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(380, 295), label5.getPreferredSize()));

		// ---- text_id ----
		textid.setEditable(false);
		contentPane.add(textid);
		textid.setBounds(450, 40, 150, 41);
		contentPane.add(texttitle);
		texttitle.setBounds(450, 100, 150, 41);
		contentPane.add(textprice);
		textprice.setBounds(450, 160, 150, 41);
		contentPane.add(textauthor);
		textauthor.setBounds(450, 220, 150, 41);
		contentPane.add(textdate);
		textdate.setBounds(450, 280, 150, 41);

		// ---- button1 ----
		button1.setText("Add");
		button1.addActionListener(e -> {
			try {
				button1ActionPerformed(e);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		});
		contentPane.add(button1);
		button1.setBounds(new Rectangle(new Point(504, 382), button1.getPreferredSize()));

		// ---- button2 ----
		button2.setText("Retour");
		button2.addActionListener(e -> button2ActionPerformed(e));
		contentPane.add(button2);
		button2.setBounds(693, 382, 100, button2.getPreferredSize().height);

		// ---- label6 ----
		label6.setText("Cover");
		contentPane.add(label6);
		label6.setBounds(new Rectangle(new Point(380, 340), label6.getPreferredSize()));

		// ---- button3 ----
		button3.setText("Choose cover");
		button3.addActionListener(e -> button3ActionPerformed(e));
		contentPane.add(button3);
		button3.setBounds(new Rectangle(new Point(680, 335), button3.getPreferredSize()));
		contentPane.add(label7);
		label7.setBounds(635, 105, 180, 155);

		// ---- textField1 ----
		textField1.setEditable(false);
		contentPane.add(textField1);
		textField1.setBounds(450, 335, 223, textField1.getPreferredSize().height);

		// ---- label8 ----
		label8.setBackground(new Color(102, 102, 102));
		label8.setIcon(new ImageIcon("assets/lar.jpg"));
		contentPane.add(label8);
		label8.setBounds(0, 0, 345, 430);

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());

	}

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
	private JLabel label8;

	private JFileChooser fc;

	private File inputFile;
	private File outputFile;

}
