package com.lab2.functional;

import javax.swing.*;
import java.awt.*;

public class FractalElement implements DrawableElement {
    public void draw() {
        final Image image = new Plasma().createPlasma(10);
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left
                        + frame.getInsets().right + image.getWidth(null),
                frame.getInsets().top
                        + frame.getInsets().bottom + image.getHeight(null));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JPanel()
        {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D G = (Graphics2D) g;
                if (image != null) {
                    G.drawImage(image, 0, 0, null);
                }
            }
        });
        frame.setVisible(true);
    }
}
