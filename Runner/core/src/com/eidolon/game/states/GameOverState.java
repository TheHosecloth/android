package com.eidolon.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.eidolon.game.Runner;

/**
 * Created by Eidolon on 3/17/17.
 */

public class GameOverState extends State {

    private Texture background;
    private Texture gameOver;
    private Texture newGame;

    public GameOverState(GameStateManager gameStateManager) {
        super(gameStateManager);

        background = new Texture("background.png");
        gameOver = new Texture("gameover.png");
        newGame= new Texture("newgame.png");
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
        batch.draw(gameOver, (Runner.WIDTH / 2) - (gameOver.getWidth() / 2), (Runner.HEIGHT / 2) + (gameOver.getHeight()));
        batch.draw(newGame, (Runner.WIDTH / 2) - (newGame.getWidth() / 2), (Runner.HEIGHT / 2) - (newGame.getHeight()));
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
        newGame.dispose();
    }
}
