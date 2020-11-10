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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Ajouter Book");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Modifier ou Supprimer");
        button2.addActionListener(e -> {
            try {
                button2ActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //---- button3 ----
        button3.setText("Exit");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(222, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(73, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addGap(91, 91, 91)
                    .addComponent(button3)
                    .addGap(127, 127, 127))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
