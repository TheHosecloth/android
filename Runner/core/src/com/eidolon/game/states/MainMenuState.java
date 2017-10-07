package com.eidolon.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.eidolon.game.Runner;

/**
 * Created by Eidolon on 3/16/17.
 */

public class MainMenuState extends State {
    private Texture background;
    private Texture runner;
    private Texture play;

    public MainMenuState(GameStateManager gameStateManager) {
        super(gameStateManager);

        background = new Texture("background.png");
        runner = new Texture("runner.png");
        play = new Texture("play.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gameStateManager.set(new PlayState(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background, 0, 0, Runner.WIDTH, Runner.HEIGHT);
        batch.draw(runner, (Runner.WIDTH / 2) - (runner.getWidth() / 2), (Runner.HEIGHT / 2) + runner.getHeight());
        batch.draw(play, (Runner.WIDTH / 2) - (play.getWidth() / 2), (Runner.HEIGHT / 2) - play.getHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        runner.dispose();
        play.dispose();
    }
}
