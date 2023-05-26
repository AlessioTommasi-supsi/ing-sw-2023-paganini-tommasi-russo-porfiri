package org.example.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ViewGui extends JFrame {
    private JButton joinGameButton; // Pulsante "Join Game"
    private JPanel bareMetalPanel; // Pannello principale
    private JTextField usernameField; // Campo di testo per l'username
    private JTextField playerNumberField; // Campo di testo per il numero di giocatori
    private JLabel imageContainer; // Contenitore per l'immagine
    private JLabel titleLabel; // Etichetta del titolo

    public ViewGui() {
        setTitle("MyShelfie"); // Imposta il titolo della finestra
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Imposta il comportamento di chiusura
        setLayout(new BorderLayout()); // Imposta il layout principale della finestra

        // Crea imageContainer come pannello di sfondo
        imageContainer = new JLabel();
        imageContainer.setLayout(new BorderLayout());
        add(imageContainer, BorderLayout.CENTER);

        // Aggiungi un ComponentListener a imageContainer
        imageContainer.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });

        bareMetalPanel = new JPanel();
        bareMetalPanel.setOpaque(false); // Rendi il pannello trasparente
        bareMetalPanel.setLayout(new GridBagLayout()); // Imposta il layout del pannello come GridBagLayout
        bareMetalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imageContainer.add(bareMetalPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Centra il contenuto orizzontalmente
        gbc.insets = new Insets(5, 0, 5, 10);

        // Aggiungi un JLabel per l'immagine di titolo sopra al primo JTextField
        ImageIcon titleImage = new ImageIcon(getClass().getResource("/Publisher material/Title 2000x618px.png"));
        titleLabel = new JLabel(titleImage);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra il titolo orizzontalmente
        titleLabel.setVerticalAlignment(SwingConstants.CENTER); // Centra il titolo verticalmente
        bareMetalPanel.add(titleLabel, gbc);

        // Aggiungi un ComponentListener a titleLabel
        titleLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeTitleImage();
            }
        });

        gbc.gridy = 1;

        JLabel usernameLabel = new JLabel("Username:");
        bareMetalPanel.add(usernameLabel, gbc);

        gbc.gridy = 2;

        // Crea un JPanel come sfondo per il JTextField dell'username
        JPanel usernameFieldBackground = new JPanel();
        usernameFieldBackground.setOpaque(false); // Rendi il pannello trasparente
        usernameFieldBackground.setLayout(new BorderLayout());
        usernameField = new JTextField();
        usernameFieldBackground.add(usernameField, BorderLayout.CENTER);

        // Aggiungi un rettangolo con bordi smussati come sfondo
        usernameFieldBackground.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        usernameField.setPreferredSize(new Dimension(200, 30)); // Imposta le dimensioni del campo di input
        bareMetalPanel.add(usernameFieldBackground, gbc);

        gbc.gridy = 3;

        JLabel playerNumberLabel = new JLabel("Player Number:");
        bareMetalPanel.add(playerNumberLabel, gbc);

        gbc.gridy = 4;

        // Crea un JPanel come sfondo per il JTextField del numero di giocatori
        JPanel playerNumberFieldBackground = new JPanel();
        playerNumberFieldBackground.setOpaque(false); // Rendi il pannello trasparente
        playerNumberFieldBackground.setLayout(new BorderLayout());
        playerNumberField = new JTextField();
        playerNumberFieldBackground.add(playerNumberField, BorderLayout.CENTER);

        // Aggiungi un rettangolo con bordi smussati come sfondo
        playerNumberFieldBackground.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        playerNumberField.setPreferredSize(new Dimension(200, 30)); // Imposta le dimensioni del campo di input
        bareMetalPanel.add(playerNumberFieldBackground, gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(10, 0, 0, 0);

        // Crea il pannello del pulsante
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Rendi il pannello trasparente
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        joinGameButton = new JButton("Join Game");
        joinGameButton.setBackground(new Color(147, 91, 0));
        joinGameButton.setForeground(Color.WHITE);
        joinGameButton.setFocusPainted(false);
        joinGameButton.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPanel.add(joinGameButton);

        gbc.gridy = 6; // Posizione nel grid modificata per il pulsante
        bareMetalPanel.add(buttonPanel, gbc);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Rendi la finestra a schermo intero
        setVisible(true);
    }

    private void resizeImage() {
        int width = imageContainer.getWidth();
        int height = imageContainer.getHeight();

        if (width > 0 && height > 0) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(getClass().getResource("/misc/sfondo parquet.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (img != null) {
                Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                imageContainer.setIcon(new ImageIcon(resizedImage));
            }
        }
    }

    private void resizeTitleImage() {
        int width = titleLabel.getWidth();
        int height = titleLabel.getHeight();

        if (width > 0 && height > 0) {
            ImageIcon titleImage = new ImageIcon(getClass().getResource("/Publisher material/Title 2000x618px.png"));
            Image img = titleImage.getImage();

            if (img != null) {
                double aspectRatio = (double) img.getWidth(null) / img.getHeight(null);

                int scaledWidth = width;
                int scaledHeight = (int) (width / aspectRatio);

                if (scaledHeight > height) {
                    scaledHeight = height;
                    scaledWidth = (int) (height * aspectRatio);
                }

                Image resizedImage = img.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                titleLabel.setIcon(new ImageIcon(resizedImage));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewGui::new);
    }
}
