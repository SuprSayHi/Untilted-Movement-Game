package org.untitled.game.entity;

import org.untitled.game.math.Vector2D;

import java.awt.*;

public abstract class Entity {
    protected Vector2D position;
    protected Vector2D velocity;
    protected double acceleration;

    // Constructors
    public Entity() {
        this.position = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.acceleration = 0;
    }

    public Entity (Vector2D position) {
        this.position = position;
        this.velocity = new Vector2D();
        this.acceleration = 0;
    }

    public Entity (int x, int y) {
        this.position = new Vector2D(x, y);
        this.velocity = new Vector2D();
        this.acceleration = 0;
    }

}
