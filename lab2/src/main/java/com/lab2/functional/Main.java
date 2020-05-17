package com.lab2.functional;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    public static void main(String[] args) {
        DrawableElement drawableElement = new FractalElement();
        drawableElement.draw();
    }
}

