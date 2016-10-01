package com.victor.games.demo.levels;

import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.Entities.BadGuy;
import com.victor.games.demo.Entities.Level;
import com.victor.games.demo.Entities.Treasure;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 29/09/16.
 */
public class Level_01 {
    private Level level;

    private int id;
    private String name;

    private Vector2 playerStartingPoint;
    private Vector2 playerEndPoint;
    private float playerSpeed;

    private List<BadGuy> badGuysList;
    private List<Treasure> treasures;

    public Level_01() {
//        level = new Level();
        id = 1;
        name = "Stage 1";
        playerStartingPoint = new Vector2(0.5f, Constants.LEVEL_SCREEN_HEIGHT - 0.5f);
        playerEndPoint = new Vector2(Constants.LEVEL_SCREEN_WIDTH, Constants.LEVEL_SCREEN_HEIGHT);
        playerSpeed = 1.1f;
        setBadGuys();
        setTreasures();

        level = new Level(id, name, playerStartingPoint, playerEndPoint, playerSpeed, badGuysList, treasures);
    }

    public Level get() {
        return level;
    }

    private void setBadGuys() {
        badGuysList = new ArrayList<BadGuy>();

        BadGuy badGuy = new BadGuy(new Vector2(2 + Constants.BAD_GUYS_RADIUS,
                                            10 + Constants.BAD_GUYS_RADIUS),
                                    new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                                            10 + Constants.BAD_GUYS_RADIUS),
                                    new Vector2(0.05f, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                                    9 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(15 + Constants.BAD_GUYS_RADIUS,
                                    9 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0.1f, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(20 + Constants.BAD_GUYS_RADIUS,
                                    12 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(10 + Constants.BAD_GUYS_RADIUS,
                                    12 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(-0.01f, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(18 + Constants.BAD_GUYS_RADIUS,
                                    5 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(18 + Constants.BAD_GUYS_RADIUS,
                                    10 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, 0.05f));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                                    10 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                                    2 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, -0.5f));
        badGuysList.add(badGuy);
    }

    private void setTreasures() {
        treasures = new ArrayList<Treasure>();

        Treasure treasure;

        treasure = new Treasure(new Vector2(20.5f, 0.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(10.5f, 5.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(15.5f, 13.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(3.5f, 8.5f));
        treasures.add(treasure);
    }

}
