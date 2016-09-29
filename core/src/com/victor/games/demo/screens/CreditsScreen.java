package com.victor.games.demo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.victor.games.demo.DemoGame;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 22/09/16.
 */
public class CreditsScreen extends GenericScreen {

    private DemoGame game;

    public CreditsScreen(DemoGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.CREDITS_SCREEN_BACKGROUND_COLOR.r, Constants.CREDITS_SCREEN_BACKGROUND_COLOR.g, Constants.CREDITS_SCREEN_BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.showMainScreen();
        return true;
    }
}
