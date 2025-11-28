package org.untitled.game.entity;

import org.untitled.game.GamePanel;
import org.untitled.game.input.KeyHandler;
import org.untitled.game.math.Vector2D;

import java.awt.*;

public class Player extends Entity {

    // World settings
    private final double frictionConstant = 0.9;

    // Player Settings
    protected final double maxVel = 5;
    protected final int jumpForce = 10;
    public boolean isStanding     = true;

    // Attributes
    private GamePanel gpl;
    private final KeyHandler keyH;


    // Constructor
    public Player(int x, int y, KeyHandler keyH, GamePanel gpl) {
        this.position = new Vector2D(x, y);
        this.velocity = new Vector2D(0, 0);
        this.acceleration = 1;
        this.keyH = keyH;
        this.gpl = gpl;
    }

    // Updates the player class
    public void update() {
        // Call update functions
        handleInput();
        friction();
        gravity();

        // Finally move the player
        this.position.x += (int) this.velocity.x;
        this.position.y += (int) this.velocity.y;
    }

    public void handleInput() {
        if (keyH.leftPressed) {
            velocity.x = Math.max(velocity.x - acceleration, maxVel * -1);
        }
        if (keyH.rightPressed) {
            velocity.x = Math.min(velocity.x + acceleration, maxVel);
        }
        if (keyH.upPressed) {
            velocity.y = -jumpForce;
        }
    }

    // World interactions
    public void gravity() {

    }

    public void friction() {
        velocity.x *= frictionConstant ; // reduce friction by a set amount
        velocity.y *= frictionConstant ; // reduce friction by a set amount
    }

    // Draw function
    public void draw(Graphics g) {
        g.fillRect((int) position.x, (int) position.y, 10, 16);
    }
}
