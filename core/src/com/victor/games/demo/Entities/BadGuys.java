package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 24/09/16.
 */
public class BadGuys {

    public static final String TAG = BadGuys.class.getName();

    private List<BadGuy> badGuys;
    private Viewport viewport;

    public BadGuys(Viewport viewport) {
        this.viewport = viewport;
    }

    public BadGuys(Viewport viewport, List<BadGuy> badGuys) {
        this.viewport = viewport;
        this.badGuys = new ArrayList<BadGuy>(badGuys);
        init(badGuys);
    }

    public void init(List<BadGuy> badGuys) {
        this.badGuys = new ArrayList<BadGuy>(badGuys);
    }

    public void update(float delta) {
        for (BadGuy badGuy : badGuys) {
            badGuy.update(delta);
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BAD_GUY_COLOR);
        for (BadGuy badGuy : badGuys) {
            badGuy.render(renderer);
        }
    }

}
