package org.project.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameGUI extends JFrame {
    private JPanel board;
    private JPanel myShelf;
    private JPanel othersShelves;
    private JPanel commonCards;
    private JPanel personalCard;
    private JPanel controlPanel;

    private JLabel imageLabel1;
    private JLabel imageLabel2;




    public GameGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Crea un oggetto GridBagConstraints per impostare le proprietà di posizionamento dei componenti
        GridBagConstraints constraints = new GridBagConstraints();

        board = new JPanel();
        myShelf = new JPanel();
        othersShelves = new JPanel();
        commonCards = new JPanel();
        personalCard = new JPanel();
        controlPanel = new JPanel();

        board.setVisible(true);
        imageLabel1 = new JLabel(new ImageIcon(getClass().getResource("/boards/livingroom.png")));
        board.add(imageLabel1);
        board.setPreferredSize(new Dimension(400, 400));
        add(board);

        /*
        myShelf.setVisible(true);
        imageLabel2 = new JLabel(new ImageIcon(getClass().getResource("/boards/bookshelf.png")));
        myShelf.add(imageLabel2);
        myShelf.setPreferredSize(new Dimension(400, 400));
        add(myShelf);
       */


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH; // Il pannello si espande sia in larghezza che in altezza
        constraints.weightx = 1.0; // Il pannello occupa tutto lo spazio disponibile in larghezza
        constraints.weighty = 1.0; // Il pannello occupa tutto lo spazio disponibile in altezza
        add(board, constraints);

        // Imposta la posizione e le dimensioni del pannello "controlPanel"
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0; // Il pannello non si espande in altezza
        add(controlPanel, constraints);

        // Imposta la posizione e le dimensioni del pannello "commonCards"
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.0; // Il pannello non si espande in larghezza
        constraints.weighty = 1.0;
        add(commonCards, constraints);

        // Imposta la posizione e le dimensioni del pannello "myShelf"
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        add(myShelf, constraints);

        // Imposta la posizione e le dimensioni del pannello "personalCard"
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        add(personalCard, constraints);

        imageLabel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeBoardImage();
            }
        });



        // Imposta il layout manager del pannello "controlPanel" come FlowLayout
        controlPanel.setLayout(new FlowLayout());

        // Aggiungi i componenti desiderati al pannello "controlPanel"
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        ImageIcon titleImage = new ImageIcon(getClass().getResource("/misc/base_pagina2.jpg"));
        JTextField textField = new JTextField(10);
        controlPanel.add(button1);
        controlPanel.add(button2);
        controlPanel.add(textField);

        // Imposta il layout manager del pannello "controlPanel" come GridLayout con 2 colonne e 3 righe
        controlPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Crea i bottoni con icone e testo desiderati
        button1.setIcon(new ImageIcon("withdraw.png")); // Sostituisci "withdraw.png" con il percorso dell'icona per il prelievo dalla board
        button1.setText("Draw from Board and insert into Shelf");

        button2.setIcon(new ImageIcon("withdraw.png")); // Sostituisci "withdraw.png" con il percorso dell'icona per il prelievo dalla board
        button2.setText("Insert into Shelf");

        JButton button3 = new JButton();
        button3.setIcon(new ImageIcon("personal.png")); // Sostituisci "personal.png" con il percorso dell'icona per la verifica dell'obiettivo personale
        button3.setText("Verify the Personal Card");

        JButton button4 = new JButton();
        button4.setIcon(new ImageIcon("common.png")); // Sostituisci "common.png" con il percorso dell'icona per la verifica degli obiettivi comuni
        button4.setText("Verify the Common Cards");

        JButton button5 = new JButton();
        button5.setIcon(new ImageIcon("others.png")); // Sostituisci "others.png" con il percorso dell'icona per la visualizzazione delle librerie degli altri giocatori
        button5.setText("Show other players's libraries");

        // Aggiungi i bottoni al pannello "controlPanel"
        controlPanel.add(button1);
        controlPanel.add(button2);
        controlPanel.add(button3);
        controlPanel.add(button4);
        controlPanel.add(button5);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void resizeBoardImage() {
        int containerWidth = imageLabel1.getWidth();
        int containerHeight = imageLabel1.getHeight();

        if (containerWidth > 0 && containerHeight > 0) {
            try {
                BufferedImage originalImage = ImageIO.read(getClass().getResource("/boards/livingroom.png"));
                int originalWidth = originalImage.getWidth();
                int originalHeight = originalImage.getHeight();

                double widthRatio = (double) containerWidth / originalWidth;
                double heightRatio = (double) containerHeight / originalHeight;

                double scaleFactor = Math.max(widthRatio, heightRatio);

                int scaledWidth = (int) (originalWidth * scaleFactor);
                int scaledHeight = (int) (originalHeight * scaleFactor);

                Image resizedTitle = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                imageLabel1.setIcon(new ImageIcon(resizedTitle));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}