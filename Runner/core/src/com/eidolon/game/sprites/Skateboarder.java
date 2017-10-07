package com.eidolon.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Eidolon on 3/17/17.
 */

public class Skateboarder {
    private static final int GRAVITY = -45;

    private Vector2 position;
    private Vector2 velocity;

    private Texture skateboarder;

    private Rectangle bounds;

    public Skateboarder(float x, float y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        skateboarder = new Texture("skateboarder.png");
        bounds = new Rectangle(x, y, skateboarder.getWidth(), skateboarder.getHeight());
    }

    public void update(float deltaTime) {
        if (position.y > 0) {
            velocity.add(0, GRAVITY);
    }

        velocity.scl(deltaTime);
        position.add(0, velocity.y);

        if (position.y < 0) {
        position.y = 0;
    }

        velocity.scl(1/deltaTime);

        bounds.setPosition(position.x, position.y);
    }

    public Texture getTexture() {
        return skateboarder;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void jump() {
        velocity.y = 900;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
