package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewGui extends JFrame {
    private JButton joinGameButton; // Pulsante "Join Game"
    private JPanel bareMetalPanel; // Pannello principale
    private JTextField usernameField; // Campo di testo per l'username
    private JTextField playerNumberField; // Campo di testo per il numero di giocatori
    private JLabel imageContainer; // Contenitore per l'immagine

    public viewGui() {
        setTitle("MyShelfie"); // Imposta il titolo della finestra
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Imposta il comportamento di chiusura
        setLayout(new BorderLayout()); // Imposta il layout principale della finestra

        bareMetalPanel = new JPanel();
        bareMetalPanel.setLayout(new GridBagLayout()); // Imposta il layout del pannello come GridBagLayout
        bareMetalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 0, 5, 10);

        imageContainer = new JLabel();
        ImageIcon imageIcon = new ImageIcon("/Publisher%20material/Title%202000x2000px.png");
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageContainer.setIcon(new ImageIcon(image));
        bareMetalPanel.add(imageContainer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 0, 5, 0);

        JLabel usernameLabel = new JLabel("Username:");
        bareMetalPanel.add(usernameLabel, gbc);

        gbc.gridy = 1;

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 30)); // Imposta le dimensioni del campo di input
        bareMetalPanel.add(usernameField, gbc);

        gbc.gridy = 2;

        JLabel playerNumberLabel = new JLabel("Player Number:");
        bareMetalPanel.add(playerNumberLabel, gbc);

        gbc.gridy = 3;

        playerNumberField = new JTextField();
        playerNumberField.setPreferredSize(new Dimension(200, 30)); // Imposta le dimensioni del campo di input
        bareMetalPanel.add(playerNumberField, gbc);

        joinGameButton = new JButton("Join Game");
        joinGameButton.addActionListener(e -> {
            usernameField.setText("Non hai inserito un username!");
            playerNumberField.setText("Non hai inserito un numero di giocatori!");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(joinGameButton);

        add(bareMetalPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Rende la finestra a schermo intero
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            viewGui window = new viewGui();
        });
    }
}
