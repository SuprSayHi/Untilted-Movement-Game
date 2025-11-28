package org.untitled.game;


import org.untitled.game.entity.Player;
import org.untitled.game.input.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Tile settings
    final int originalTileSize = 16; // 16x16 pixel tile size
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    final int screenWidth = 800;
    final int screenHeight = 600;

    // Game settings/attributes
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    // Player
    Player player = new Player(100, 100, keyHandler, this);


    // Game starters
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        int FPS = 60;

        double drawInterval = 1_000_000_000D / FPS;
        double deltaT = 0; // Time elapsed

        // Last and current time
        long lastTime = System.nanoTime();
        long currentTime;


        // Main loop
        while (gameThread != null) {

            // Ensuring fps is around 60
            currentTime = System.nanoTime();
            deltaT += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (deltaT >= 1) {

                // Update
                update();
                repaint();

                // Update delta and draw count
                deltaT--;

            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);

        g2d.dispose();
    }
}
