package org.project.view;

import org.project.model.Choice;
import org.project.model.ChoiceMyShelfie;
import org.project.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoginGui extends JFrame {
    private JButton joinGameButton; // Pulsante "Join Game"
    private JPanel bareMetalPanel; // Pannello principale
    private JTextField usernameField; // Campo di testo per l'username
    private JTextField playerNumberField; // Campo di testo per il numero di giocatori
    private JLabel imageContainer; // Contenitore per l'immagine
    private JLabel titleLabel; // Etichetta del titolo

    ViewMyShelfie viewMyShelfie; // Riferimento alla classe textuale
    public LoginGui() {
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
        ImageIcon titleImage = new ImageIcon(getClass().getResource("/publisherMaterial/Title 2000x618px.png"));
        titleLabel = new JLabel(titleImage);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centra il titolo orizzontalmente
        titleLabel.setVerticalAlignment(SwingConstants.CENTER); // Centra il titolo verticalmente
        bareMetalPanel.add(titleLabel, gbc);

        // Aggiungi un ComponentListener a titleLabel
        titleLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeTitle();
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

    public LoginGui(ViewMyShelfie viewMyShelfie) {
        this();//richiamo costruttore
        this.viewMyShelfie = viewMyShelfie;
        joinGameButton.addActionListener(e -> {
            String username = usernameField.getText();
            String playerNumber = playerNumberField.getText();

            if (username.isEmpty() || playerNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int playerNumberInt = Integer.parseInt(playerNumber);
                    if (playerNumberInt < 2 || playerNumberInt > 4) {
                        JOptionPane.showMessageDialog(this, "The number of players must be between 2 and 4", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //viewMyShelfie.joinGame(username, playerNumberInt);
                        Player player = new Player(this.usernameField.getText());
                        viewMyShelfie.setPlayer(player);
                        Choice c = new Choice(ChoiceMyShelfie.JOIN_GAME, player,Integer.parseInt(playerNumberField.getText()));

                        viewMyShelfie.deliverGuiRequest(c);
                        //aggiorno la view testuale!
                        viewMyShelfie.texView();

                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "The number of players must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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


    private void resizeTitle() {
        int containerWidth = titleLabel.getWidth();
        int containerHeight = titleLabel.getHeight();

        if (containerWidth > 0 && containerHeight > 0) {
            try {
                BufferedImage originalImage = ImageIO.read(getClass().getResource("/publisherMaterial/Title 2000x618px.png"));
                int originalWidth = originalImage.getWidth();
                int originalHeight = originalImage.getHeight();

                double widthRatio = (double) containerWidth / originalWidth;
                double heightRatio = (double) containerHeight / originalHeight;

                double scaleFactor = Math.max(widthRatio, heightRatio);

                int scaledWidth = (int) (originalWidth * scaleFactor);
                int scaledHeight = (int) (originalHeight * scaleFactor);

                Image resizedTitle = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                titleLabel.setIcon(new ImageIcon(resizedTitle));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }

    public void startBoard() {
        JOptionPane.showMessageDialog(null, "ORA TOCCA A TE!");
    }
    public void refreshMessage(String message) {
        JOptionPane.showMessageDialog(null, "message");
    }

    private void resizeTitleImage() {
        int width = titleLabel.getWidth();
        int height = titleLabel.getHeight();

        if (width > 0 && height > 0) {
            ImageIcon titleImage = new ImageIcon(getClass().getResource("/publisherMaterial/Title 2000x618px.png"));
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
        SwingUtilities.invokeLater(LoginGui::new);
    }

    public JButton getJoinGameButton() {
        return joinGameButton;
    }

    public void setJoinGameButton(JButton joinGameButton) {
        this.joinGameButton = joinGameButton;
    }

    public JPanel getBareMetalPanel() {
        return bareMetalPanel;
    }

    public void setBareMetalPanel(JPanel bareMetalPanel) {
        this.bareMetalPanel = bareMetalPanel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getPlayerNumberField() {
        return playerNumberField;
    }

    public void setPlayerNumberField(JTextField playerNumberField) {
        this.playerNumberField = playerNumberField;
    }

    public JLabel getImageContainer() {
        return imageContainer;
    }

    public void setImageContainer(JLabel imageContainer) {
        this.imageContainer = imageContainer;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }
}
