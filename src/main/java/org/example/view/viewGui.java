package org.example.view;

import org.example.util.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;

public class viewGui extends JFrame {
    private JButton joinGameButton;
    private JPanel bareMetalPanel;
    private JTextField usernameField;
    private JTextField playerNumberField;
    private JLabel imageContainer;
    private JPanel usernamePanel;
    private JPanel playerNumberPanel;
    private JLabel ImageLabel;

    public viewGui() {
        JFrame frame = new JFrame("MyShelfie");

        bareMetalPanel = new JPanel();
        imageContainer = new JLabel();
        joinGameButton = new JButton();

        frame.setContentPane(bareMetalPanel);

        frame.setContentPane(new JPanel());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        imageContainer.setIcon(new ImageIcon("/resources/Publisher%20material/Title%202000x2000px.png"));

        joinGameButton.addActionListener(e -> {
            usernameField.setText("Non hai inserito un username!");
            playerNumberField.setText("Non hai inserito un numero di giocatori!");
        });

        frame.pack();
        frame.setVisible(true);
    }

}
