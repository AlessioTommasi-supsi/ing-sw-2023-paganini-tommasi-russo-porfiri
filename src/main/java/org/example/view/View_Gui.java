package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

public class View_Gui {
    private JButton joinGameButton;
    private JPanel bare_metal_panel;
    private JTextField username_field;
    private JTextField numero_giocatori_field;
    private JPanel image_container;
    private JPanel username_panel;
    private JPanel num_giocatori_panel;
    private JLabel ImageLable;

    public View_Gui() {
        JFrame frame = new JFrame("Shelfie");
        frame.setContentPane(bare_metal_panel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        ImageLable.setIcon(new ImageIcon("Title.png"));
        joinGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username_field.setText("non hai inserito un username");
                numero_giocatori_field.setText("non hai inserito un numero di giocatori");
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

}
