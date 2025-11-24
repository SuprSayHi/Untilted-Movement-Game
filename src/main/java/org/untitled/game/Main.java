package org.untitled.game;

import javax.swing.*;

public class Main {
    static void main() {
        // Sets up the main application window
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Vitas");

        // Adding game panel to the application
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);



    }
}
