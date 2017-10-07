package com.eidolon.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Eidolon on 3/16/17.
 */

public abstract class State {
    protected GameStateManager gameStateManager;

    public State(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public abstract void handleInput();
    public abstract void update(float deltaTime);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
