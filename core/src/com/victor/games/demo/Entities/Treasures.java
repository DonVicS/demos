package com.victor.games.demo.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 29/09/16.
 */
public class Treasures {
    public static final String TAG = Treasures.class.getName();

    private List<Treasure> treasures;
    private Viewport viewport;

    public int treasuresCollected = 0;

    public Treasures(Viewport viewport, List<Treasure> treasures) {
        this.viewport = viewport;
        init(treasures);
    }

    public void init(List<Treasure> treasures) {
        this.treasures = new ArrayList<Treasure>(treasures);
    }

    public void update(float delta, Vector2 playerPosition) {
        for (int i = 0; i < treasures.size(); i++) {
            if (treasures.get(i).position.dst(playerPosition) < Constants.ENTITIES_SIZE) {
                treasuresCollected += 1;
                treasures.remove(i);
            }
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.TREASURE_COLOR);
        for (Treasure treasure : treasures) {
            treasure.render(renderer);
        }
    }


}
