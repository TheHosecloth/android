package com.eidolon.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.eidolon.game.Runner;

/**
 * Created by Eidolon on 3/17/17.
 */

public class Hurdle {
    private static final int LEFT_PULL = -8;

    private Vector2 position;
    private Vector2 velocity;

    private Texture hurdle;

    private Rectangle bounds;

    public Hurdle() {
        hurdle = new Texture("hurdle.png");
        position = new Vector2(Runner.WIDTH, 0);
        bounds = new Rectangle(position.x, position.y, hurdle.getWidth(), hurdle.getHeight());
    }

    public void update() {
        if (position.x <= 0 - hurdle.getWidth()) {
            position.set(Runner.WIDTH, 0);
        } else {
            position.add(LEFT_PULL, 0);
        }
        bounds.setPosition(position.x, position.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(bounds);
    }

    public Texture getTexture() {
        return hurdle;
    }


    public Vector2 getPosition() {
        return position;
    }
}
