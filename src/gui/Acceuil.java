/*
 * Created by JFormDesigner on Tue Nov 10 16:15:14 CET 2020
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Acceuil extends JFrame {
    public Acceuil() {
        initComponents();

    }

    private void button1ActionPerformed(ActionEvent e) {
        this.dispose();
        new Ajout().show();
    }

    private void button3ActionPerformed(ActionEvent e) {
        this.dispose();
        System.exit(0);
    }

    private void button2ActionPerformed(ActionEvent e) throws SQLException {
        this.dispose();
        new GridList().show();
    }

    private void button4ActionPerformed(ActionEvent e) throws SQLException {
       this.dispose();
       new command().show();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button4 = new JButton();
        label4 = new JLabel();

        //======== this ========
        setBackground(UIManager.getColor("Component.errorFocusColor"));
        setForeground(UIManager.getColor("Component.errorFocusColor"));
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Ajouter Book");
        button1.setForeground(SystemColor.desktop);
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Modifier ou Supprimer");
        button2.setForeground(SystemColor.desktop);
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("Exit");
        button3.setForeground(UIManager.getColor("Component.errorFocusColor"));
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- label1 ----
        label1.setIcon(new ImageIcon("/home/ghost/Desktop/workshop/BookStore/assets/n.png"));

        //---- label2 ----
        label2.setText("text");
        label2.setIcon(new ImageIcon("/home/ghost/Desktop/workshop/BookStore/assets/ad.jpg"));

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("/home/ghost/Desktop/workshop/BookStore/assets/upd.jpg"));

        //---- button4 ----
        button4.setText("Command");
        button4.setForeground(SystemColor.desktop);
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- label4 ----
        label4.setIcon(new ImageIcon("/home/ghost/Desktop/workshop/BookStore/assets/or.png"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {button1, button2});
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(button4))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                    .addGap(81, 81, 81)
                    .addComponent(button3)
                    .addGap(44, 44, 44))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button4;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
