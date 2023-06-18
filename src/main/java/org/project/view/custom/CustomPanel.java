package org.project.view.custom;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {

    private ImageIcon imageIcon;
    Image myImage;

    public CustomPanel(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        this.myImage = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna l'immagine all'interno del pannello
        if (myImage != null) {
            int x = (getWidth() - myImage.getWidth(null)) / 2;
            int y = (getHeight() - myImage.getHeight(null)) / 2;
            g.drawImage(myImage, x, y, null);
        }
    }

    public Image getBoardImage() {
        return myImage;
    }
}

