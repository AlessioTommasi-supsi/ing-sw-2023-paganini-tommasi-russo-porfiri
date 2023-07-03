package org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.SwingUI;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.Choice;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoginGUI extends JFrame {

    public JButton joinGameButton = new JButton();
    public JPanel bareMetalPanel = new JPanel();
    public JTextField usernameField = new JTextField();
    public JTextField playerNumberField = new JTextField();
    public JLabel imageContainer = new JLabel();
    public JLabel titleLabel = new JLabel();
    ViewMyShelfie viewMyShelfie;

    public LoginGUI() {
        setResizable(false);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        joinGameButton.setBackground(new Color(139, 69, 19));
        joinGameButton.setForeground(Color.WHITE); // Testo bianco
        joinGameButton.setFont(new Font("Arial", Font.BOLD, 14));

        //Dimensioni finestra principale (Il JFrame LoginGUI)
        int frameWidth = 1280;
        int frameHeight = 720;

        //Calcolo delle dimensioni dei componenti in base alla proporzione della finestra principale
        int joinGameButtonWidth = (int) (frameWidth * 0.2);  //20% della larghezza del frame
        int joinGameButtonHeight = (int) (frameHeight * 0.1);  //10% dell'altezza del frame

        int textFieldWidth = (int) (frameWidth * 0.2);
        int textFieldHeight = (int) (frameHeight * 0.05);

        int titleLabelWidth = (int) (frameWidth * 0.5);
        int titleLabelHeight = (int) (frameHeight * 0.2);

        //Impostazione delle dimensioni dei componenti
        joinGameButton.setPreferredSize(new Dimension(joinGameButtonWidth, joinGameButtonHeight));
        usernameField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        playerNumberField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        titleLabel.setPreferredSize(new Dimension(titleLabelWidth, titleLabelHeight));

        setTitle("MyShelfie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        imageContainer = new JLabel();
        imageContainer.setLayout(new BorderLayout());
        add(imageContainer, BorderLayout.CENTER);

        imageContainer.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });

        bareMetalPanel = new JPanel();
        bareMetalPanel.setOpaque(false);
        bareMetalPanel.setLayout(new GridBagLayout());
        bareMetalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imageContainer.add(bareMetalPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 10);


        ImageIcon titleImage = new ImageIcon(getClass().getResource("/GraphicResources/publisherMaterial/Title 2000x618px.png"));
        titleLabel = new JLabel(titleImage);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        bareMetalPanel.add(titleLabel, gbc);

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
        JPanel usernameFieldBackground = new JPanel();
        usernameFieldBackground.setOpaque(false);
        usernameFieldBackground.setLayout(new BorderLayout());
        usernameField = new JTextField();
        usernameFieldBackground.add(usernameField, BorderLayout.CENTER);
        usernameFieldBackground.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        usernameField.setPreferredSize(new Dimension(200, 30));
        bareMetalPanel.add(usernameFieldBackground, gbc);
        gbc.gridy = 3;
        JLabel playerNumberLabel = new JLabel("Player Number:");
        bareMetalPanel.add(playerNumberLabel, gbc);
        gbc.gridy = 4;

        JPanel playerNumberFieldBackground = new JPanel();
        playerNumberFieldBackground.setOpaque(false);
        playerNumberFieldBackground.setLayout(new BorderLayout());
        playerNumberField = new JTextField();
        playerNumberFieldBackground.add(playerNumberField, BorderLayout.CENTER);

        playerNumberFieldBackground.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        playerNumberField.setPreferredSize(new Dimension(200, 30));
        bareMetalPanel.add(playerNumberFieldBackground, gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(10, 0, 0, 0);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        joinGameButton = new JButton("Join Game");
        joinGameButton.setBackground(new Color(147, 91, 0));
        joinGameButton.setForeground(Color.WHITE);
        joinGameButton.setFocusPainted(false);
        joinGameButton.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPanel.add(joinGameButton);

        gbc.gridy = 6;
        bareMetalPanel.add(buttonPanel, gbc);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }


    public LoginGUI(ViewMyShelfie viewMyShelfie) {
        this();
        this.viewMyShelfie = viewMyShelfie;


        setResizable(false);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        joinGameButton.setBackground(new Color(139, 69, 19));
        joinGameButton.setForeground(Color.WHITE);
        joinGameButton.setFont(new Font("Arial", Font.BOLD, 14));

        //Impostazione delle dimensioni dei componenti in proporzione alla finestra principale
        int frameWidth = 1280;
        int frameHeight = 720;

        //Calcolo delle dimensioni dei componenti in base alla proporzione della finestra principale
        int joinGameButtonWidth = (int) (frameWidth * 0.2);
        int joinGameButtonHeight = (int) (frameHeight * 0.1);

        int textFieldWidth = (int) (frameWidth * 0.2);
        int textFieldHeight = (int) (frameHeight * 0.05);

        int titleLabelWidth = (int) (frameWidth * 0.5);
        int titleLabelHeight = (int) (frameHeight * 0.2);

        //Impostazione delle dimensioni dei componenti
        joinGameButton.setPreferredSize(new Dimension(joinGameButtonWidth, joinGameButtonHeight));
        usernameField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        playerNumberField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        titleLabel.setPreferredSize(new Dimension(titleLabelWidth, titleLabelHeight));

        joinGameButton.addActionListener(e -> {
            String username = usernameField.getText();
            String playerNumber = playerNumberField.getText();

            if (username.isEmpty() || playerNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
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
                        //viewMyShelfie.texView();

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
                img = ImageIO.read(getClass().getResource("/GraphicResources/misc/sfondo parquet.jpg"));
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
                BufferedImage originalImage = ImageIO.read(getClass().getResource("/GraphicResources/publisherMaterial/Title 2000x618px.png"));
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
            ImageIcon titleImage = new ImageIcon(getClass().getResource("/GraphicResources/publisherMaterial/Title 2000x618px.png"));
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
        SwingUtilities.invokeLater(LoginGUI::new);
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
