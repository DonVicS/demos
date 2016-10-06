package com.victor.games.demo.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Victor Santamaria on 17/09/16.
 */
public class Constants {

    public static final float WORLD_SIZE = 480.0f;
    public static final Color MAIN_SCREEN_BACKGROUND = Color.NAVY;
    public static final Color LEVEL_SCREEN_BACKGROUND = Color.CORAL;
    public static final Color SAVE_SCREEN_BACKGROUND_COLOR = Color.FIREBRICK;
    public static final Color LOAD_SCREEN_BACKGROUND_COLOR = Color.CYAN;
    public static final Color CREDITS_SCREEN_BACKGROUND_COLOR = Color.RED;

    public static final float GRAVITATIONAL_ACCELERATION = 0.8f;
    public static final float ACCELEROMETER_SENSITIVITY = 0.5f;

    public static final float LEVEL_SCREEN_WIDTH = 26;
    public static final float LEVEL_SCREEN_HEIGHT = 19;

    public static final float BUTTONS_LENGTH = WORLD_SIZE * 0.75f;
    public static final float BUTTONS_HIGH = WORLD_SIZE * 0.1f;
    public static final float BUTTONS_SEPARATION = BUTTONS_HIGH / 5;
    public static final Color BUTTON_COLOR = Color.GRAY;
    public static final float BUTTONS_LABEL_SCALE = 1.5f;
    public static final float BUTTON_X = (WORLD_SIZE - BUTTONS_LENGTH) / 2;

    public static final Vector2 NEW_GAME_BUTTON_POSITION = new Vector2(BUTTON_X, WORLD_SIZE * 0.3f);
    public static final Vector2 NEW_GAME_BUTTON_CENTER = new Vector2(BUTTON_X + BUTTONS_LENGTH / 2, NEW_GAME_BUTTON_POSITION.y + BUTTONS_HIGH / 2);
    public static final String NEW_GAME_LABEL = "New Game";

    public static final Vector2 SAVE_BUTTON_POSITION = new Vector2(BUTTON_X, NEW_GAME_BUTTON_POSITION.y - BUTTONS_SEPARATION - BUTTONS_HIGH);
    public static final Vector2 SAVE_BUTTON_CENTER = new Vector2(BUTTON_X + BUTTONS_LENGTH / 2, SAVE_BUTTON_POSITION.y + BUTTONS_HIGH / 2);
    public static final String SAVE_LABEL = "Save Game";

    public static final Vector2 LOAD_BUTTON_POSITION = new Vector2(BUTTON_X, SAVE_BUTTON_POSITION.y - BUTTONS_SEPARATION - BUTTONS_HIGH);
    public static final Vector2 LOAD_BUTTON_CENTER = new Vector2(BUTTON_X + BUTTONS_LENGTH / 2, LOAD_BUTTON_POSITION.y + BUTTONS_HIGH / 2);
    public static final String LOAD_LABEL = "Load Game";

    public static final float ENTITIES_SIZE = 1;
    public static final float ENTITIES_RADIUS = ENTITIES_SIZE / 2;

    public static final float BAD_GUYS_SIZE = 1;
    public static final float BAD_GUYS_RADIUS = BAD_GUYS_SIZE / 2;
    public static final Color BAD_GUY_COLOR = Color.GREEN;

    public static final Color PLAYER_COLOR = Color.RED;

    public static final Color TREASURE_COLOR = Color.GOLD;
    public static final Color WALL_COLOR = Color.BLUE;

}
