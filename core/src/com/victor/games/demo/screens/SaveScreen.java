package com.victor.games.demo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.victor.games.demo.utils.Constants;
import com.victor.games.demo.DemoGame;

/**
 * Created by Victor Santamaria on 17/09/16.
 */
public class SaveScreen extends GenericScreen {

    public static final String TAG = SaveScreen.class.getName();

    private DemoGame game;

    public SaveScreen(DemoGame game){
        this.game = game;
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.SAVE_SCREEN_BACKGROUND_COLOR.r, Constants.SAVE_SCREEN_BACKGROUND_COLOR.g, Constants.SAVE_SCREEN_BACKGROUND_COLOR.b, 1);
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
