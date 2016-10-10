package com.victor.games.demo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.victor.games.demo.DemoGame;
import com.victor.games.demo.Entities.Level;
import com.victor.games.demo.levels.LevelManager;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 09/10/16.
 */
public class LevelScoreScreen extends GenericScreen {

    public static final String TAG = LevelScreen.class.getName();

    private DemoGame game;

    private int difficulty;

    private int stars;

//    int deaths,  totalTreasures,  collectedTreasures;

    public LevelScoreScreen(DemoGame game, int difficulty, int deaths, int totalTreasures,
                            int collectedTreasures) {
        this.game = game;
        this.difficulty = difficulty;

//        this.deaths = deaths;
//        this.totalTreasures = totalTreasures;
//        this.collectedTreasures = collectedTreasures;

        calculateScore(deaths, totalTreasures, collectedTreasures);
    }

    private void calculateScore(int deaths, int totalTreasures, int collectedTreasures) {
        this.stars = 1;
        if (deaths == 0) stars++;
        if (totalTreasures == collectedTreasures) stars++;
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(Constants.LEVEL_SCORE_SCREEN_COLOR.r,
                            Constants.LEVEL_SCORE_SCREEN_COLOR.g,
                            Constants.LEVEL_SCORE_SCREEN_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Constants.BUTTON_COLOR);

        renderer.rect(Constants.REPEAT_LEVEL_BUTTON_POSITION.x,
                Constants.REPEAT_LEVEL_BUTTON_POSITION.y,
                Constants.BUTTONS_LENGTH,
                Constants.BUTTONS_HIGH);

        renderer.rect(Constants.NEXT_LEVEL_BUTTON_POSITION.x,
                Constants.NEXT_LEVEL_BUTTON_POSITION.y,
                Constants.BUTTONS_LENGTH,
                Constants.BUTTONS_HIGH);

        renderer.rect(Constants.MAIN_MENU_BUTTON_POSITION.x,
                Constants.MAIN_MENU_BUTTON_POSITION.y,
                Constants.BUTTONS_LENGTH,
                Constants.BUTTONS_HIGH);

        renderer.end();

        /*renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.RED);
        renderer.rectLine(new Vector2(Constants.WORLD_SIZE/2, 0.0f), new Vector2(Constants.WORLD_SIZE/2, Constants.WORLD_SIZE), 1);
        renderer.end();*/

        batch.begin();

//        final GlyphLayout newGameLayout = new GlyphLayout(font, Constants.REPEAT_LEVEL_LABEL);
        font.draw(batch, stars + " Stars", viewport.getWorldWidth() / 2 , viewport.getWorldHeight() * 0.75f, 0, Align.center, false);

        final GlyphLayout newGameLayout = new GlyphLayout(font, Constants.REPEAT_LEVEL_LABEL);
        font.draw(batch, Constants.REPEAT_LEVEL_LABEL, Constants.REPEAT_LEVEL_BUTTON_CENTER.x + newGameLayout.width * 1.5f, Constants.REPEAT_LEVEL_BUTTON_CENTER.y, 0, Align.center, false);

        final GlyphLayout saveLayout = new GlyphLayout(font, Constants.NEXT_LEVEL_LABEL);
        font.draw(batch, Constants.NEXT_LEVEL_LABEL, Constants.NEXT_LEVEL_BUTTON_CENTER.x + saveLayout.width * 1.5f, Constants.NEXT_LEVEL_BUTTON_CENTER.y, 0, Align.center, false);

        final GlyphLayout loadLayout = new GlyphLayout(font, Constants.MAIN_MENU_LABEL);
        font.draw(batch, Constants.MAIN_MENU_LABEL, Constants.MAIN_MENU_BUTTON_CENTER.x + loadLayout.width * 1.5f, Constants.MAIN_MENU_BUTTON_CENTER.y, 0, Align.center, false);

        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));

        float x = Constants.NEW_GAME_BUTTON_POSITION.x;
        float x2 = Constants.NEW_GAME_BUTTON_POSITION.x + Constants.BUTTONS_LENGTH;

        if(worldTouch.x > x && worldTouch.x < x2) {
            if(worldTouch.y > Constants.REPEAT_LEVEL_BUTTON_CENTER.y && worldTouch.y < Constants.REPEAT_LEVEL_BUTTON_CENTER.y + Constants.BUTTONS_HIGH)
                game.showLevelScreen(difficulty);
            if(worldTouch.y > Constants.NEXT_LEVEL_BUTTON_CENTER.y && worldTouch.y < Constants.NEXT_LEVEL_BUTTON_CENTER.y + Constants.BUTTONS_HIGH)
                game.showLevelScreen(difficulty + 1);
            if(worldTouch.y > Constants.MAIN_MENU_BUTTON_CENTER.y && worldTouch.y < Constants.MAIN_MENU_BUTTON_CENTER.y + Constants.BUTTONS_HIGH)
                game.showMainScreen();
        }

        return true;
    }
}
