package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 06/10/16.
 */
public class Wall {
    public static final String TAG = Walls.class.getName();

    public Vector2 position;

    public Wall(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer renderer) {
        renderer.rect(position.x, position.y, Constants.ENTITIES_SIZE, Constants.ENTITIES_SIZE);
    }

}
