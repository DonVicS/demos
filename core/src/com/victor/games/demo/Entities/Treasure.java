package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 19/09/16.
 */
public class Treasure {
    public static final String TAG = Treasure.class.getName();

    private final Vector2 position;

    public Treasure(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer renderer) {
        renderer.circle(position.x, position.y, Constants.BAD_GUYS_RADIUS, 20);
    }

}
