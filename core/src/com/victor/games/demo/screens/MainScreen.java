package com.victor.games.demo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.victor.games.demo.DemoGame;
import com.victor.games.demo.utils.Constants;


/**
 * Created by Victor Santamaria on 17/09/16.
 */
public class MainScreen extends GenericScreen {

    public static final String TAG = MainScreen.class.getName();

    private DemoGame game;

    public MainScreen(DemoGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.MAIN_SCREEN_BACKGROUND.r, Constants.MAIN_SCREEN_BACKGROUND.g, Constants.MAIN_SCREEN_BACKGROUND.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Constants.BUTTON_COLOR);
        renderer.rect(Constants.NEW_GAME_BUTTON_POSITION.x, Constants.NEW_GAME_BUTTON_POSITION.y, Constants.BUTTONS_LENGTH, Constants.BUTTONS_HIGH);
        renderer.rect(Constants.SAVE_BUTTON_POSITION.x, Constants.SAVE_BUTTON_POSITION.y, Constants.BUTTONS_LENGTH, Constants.BUTTONS_HIGH);
        renderer.rect(Constants.LOAD_BUTTON_POSITION.x, Constants.LOAD_BUTTON_POSITION.y, Constants.BUTTONS_LENGTH, Constants.BUTTONS_HIGH);

        renderer.end();

        /*renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.RED);
        renderer.rectLine(new Vector2(Constants.WORLD_SIZE/2, 0.0f), new Vector2(Constants.WORLD_SIZE/2, Constants.WORLD_SIZE), 1);
        renderer.end();*/

        batch.begin();

        final GlyphLayout newGameLayout = new GlyphLayout(font, Constants.NEW_GAME_LABEL);
        font.draw(batch, Constants.NEW_GAME_LABEL, Constants.NEW_GAME_BUTTON_CENTER.x + newGameLayout.width * 1.5f, Constants.NEW_GAME_BUTTON_CENTER.y, 0, Align.center, false);

        final GlyphLayout saveLayout = new GlyphLayout(font, Constants.SAVE_LABEL);
        font.draw(batch, Constants.SAVE_LABEL, Constants.SAVE_BUTTON_CENTER.x + saveLayout.width * 1.5f, Constants.SAVE_BUTTON_CENTER.y, 0, Align.center, false);

        final GlyphLayout loadLayout = new GlyphLayout(font, Constants.LOAD_LABEL);
        font.draw(batch, Constants.LOAD_LABEL, Constants.LOAD_BUTTON_CENTER.x + loadLayout.width * 1.5f, Constants.LOAD_BUTTON_CENTER.y, 0, Align.center, false);

        batch.end();

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));

        float x = Constants.NEW_GAME_BUTTON_POSITION.x;
        float x2 = Constants.NEW_GAME_BUTTON_POSITION.x + Constants.BUTTONS_LENGTH;

        if(worldTouch.x > x && worldTouch.x < x2) {
            if(worldTouch.y > Constants.NEW_GAME_BUTTON_POSITION.y && worldTouch.y < Constants.NEW_GAME_BUTTON_POSITION.y + Constants.BUTTONS_HIGH)
                game.showLevelScreen(1);
            if(worldTouch.y > Constants.SAVE_BUTTON_POSITION.y && worldTouch.y < Constants.SAVE_BUTTON_POSITION.y + Constants.BUTTONS_HIGH)
                game.showSaveScreen();
            if(worldTouch.y > Constants.LOAD_BUTTON_POSITION.y && worldTouch.y < Constants.LOAD_BUTTON_POSITION.y + Constants.BUTTONS_HIGH)
                game.showLoadScreen();
        }

        return true;
    }

}
