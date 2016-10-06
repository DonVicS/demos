package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 06/10/16.
 */
public class Walls {
    public static final String TAG = Walls.class.getName();

    private List<Wall> wallList;
    private Viewport viewport;

    public Walls(Viewport viewport, List<Wall> wallList) {
        this.viewport = viewport;
        init(wallList);
    }

    public void init(List<Wall> wallList) {
        this.wallList = new ArrayList<Wall>(wallList);
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.WALL_COLOR);
        for (Wall wall : wallList) {
            wall.render(renderer);
        }
    }

}
