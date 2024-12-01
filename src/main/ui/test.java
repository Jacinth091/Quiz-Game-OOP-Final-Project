/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.ui;

/**
 *
 * @author PCC
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;

public class test extends MouseAdapter {
    private JFrame frame;
    private JPasswordField  passwordField;

    public void mouseEntered(MouseEvent event) {
        passwordField.setEchoChar('\u0000');
    }

    public void mouseExited(MouseEvent event) {
        passwordField.setEchoChar('*');
    }

    private void buildAndDisplayGui() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createEye(), BorderLayout.PAGE_START);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createEye() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        passwordField = new JPasswordField(15);
        passwordField.setBorder(null);
        panel.add(passwordField);
        URL location = getClass().getResource("eye.png");
        Icon ico = new ImageIcon(location);
        JLabel label = new JLabel(ico);
        label.setOpaque(true);
        label.setBackground(passwordField.getBackground());
        label.addMouseListener(this);
        panel.add(label);
        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        container.add(panel);
        return container;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new test().buildAndDisplayGui());
    }
}
