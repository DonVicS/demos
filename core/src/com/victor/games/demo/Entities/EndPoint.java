package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 08/10/16.
 */
public class EndPoint {
    public static final String TAG = EndPoint.class.getName();

    public Vector2 position;

    public EndPoint(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.END_POINT_COLOR);
        renderer.circle(position.x, position.y, Constants.ENTITIES_RADIUS, 20);
    }
}
