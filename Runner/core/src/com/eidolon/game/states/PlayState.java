package com.eidolon.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.eidolon.game.Runner;
import com.eidolon.game.sprites.Hurdle;
import com.eidolon.game.sprites.Skateboarder;

/**
 * Created by Eidolon on 3/16/17.
 */

public class PlayState extends State {
    private Texture background;
    private Skateboarder skateboarder;
    private Hurdle hurdle;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("background.png");
        skateboarder = new Skateboarder(50, 0);
        hurdle = new Hurdle();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            skateboarder.jump();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        skateboarder.update(deltaTime);
        hurdle.update();

        if (hurdle.collides(skateboarder.getBounds())) {
            gameStateManager.set(new GameOverState(gameStateManager));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background, 0, 0, Runner.WIDTH, Runner.HEIGHT);
        batch.draw(skateboarder.getTexture(), skateboarder.getPosition().x, skateboarder.getPosition().y);
        batch.draw(hurdle.getTexture(), hurdle.getPosition().x, hurdle.getPosition().y);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
