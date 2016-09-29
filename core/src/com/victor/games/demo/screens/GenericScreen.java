package com.victor.games.demo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 22/09/16.
 */
public abstract class GenericScreen extends InputAdapter implements Screen {

    protected float worldWidth;
    protected float worldHeight;

    protected ShapeRenderer renderer;
    protected SpriteBatch batch;
    protected FitViewport viewport;

    protected BitmapFont font;

    public GenericScreen() {
        this.worldWidth = Constants.WORLD_SIZE;
        this.worldHeight = Constants.WORLD_SIZE;
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();

        viewport = new FitViewport(worldWidth, worldHeight);
        Gdx.input.setInputProcessor(this);

        font = new BitmapFont();
        font.getData().setScale(Constants.BUTTONS_LABEL_SCALE);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public abstract void render(float delta);

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        batch.dispose();
        font.dispose();
        renderer.dispose();
    }

    @Override
    public void dispose() {

    }

    @Override
    public abstract boolean touchDown(int screenX, int screenY, int pointer, int button);

}
