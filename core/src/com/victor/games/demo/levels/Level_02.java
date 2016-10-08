package com.victor.games.demo.levels;

import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.Entities.BadGuy;
import com.victor.games.demo.Entities.Level;
import com.victor.games.demo.Entities.Treasure;
import com.victor.games.demo.Entities.Wall;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 29/09/16.
 */
public class Level_02 {
    private Level level;

    private int id;
    private String name;

    private Vector2 playerStartingPoint;
    private Vector2 playerEndPoint;
    private float playerSpeed;

    private List<BadGuy> badGuysList;
    private List<Treasure> treasures;
    private List<Wall> wallList;
    private int[][] worldMap = new int[Constants.LEVEL_SCREEN_HEIGHT][Constants.LEVEL_SCREEN_WIDTH];

    public Level_02() {
//        level = new Level();
        id = 1;
        name = "Stage 1";
        playerStartingPoint = new Vector2(0.5f, Constants.LEVEL_SCREEN_HEIGHT - 0.5f);
        playerEndPoint = new Vector2(Constants.LEVEL_SCREEN_WIDTH, Constants.LEVEL_SCREEN_HEIGHT);
        playerSpeed = 5;
        setBadGuys();
        setTreasures();
        setWalls();

        level = new Level(id, name, playerStartingPoint, playerEndPoint, playerSpeed,
                badGuysList, treasures, wallList, worldMap);
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
//                                    new Vector2(0.05f, 0));
                new Vector2(5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                9 + Constants.BAD_GUYS_RADIUS),
                new Vector2(15 + Constants.BAD_GUYS_RADIUS,
                        9 + Constants.BAD_GUYS_RADIUS),
//                            new Vector2(0.1f, 0));
                new Vector2(10, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(20 + Constants.BAD_GUYS_RADIUS,
                12 + Constants.BAD_GUYS_RADIUS),
                new Vector2(10 + Constants.BAD_GUYS_RADIUS,
                        12 + Constants.BAD_GUYS_RADIUS),
//                            new Vector2(-0.01f, 0));
                new Vector2(-5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(18 + Constants.BAD_GUYS_RADIUS,
                5 + Constants.BAD_GUYS_RADIUS),
                new Vector2(18 + Constants.BAD_GUYS_RADIUS,
                        10 + Constants.BAD_GUYS_RADIUS),
//                            new Vector2(0, 0.05f));
                new Vector2(0, 5));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                10 + Constants.BAD_GUYS_RADIUS),
                new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                        2 + Constants.BAD_GUYS_RADIUS),
//                            new Vector2(0, -0.5f));
                new Vector2(0, -12));
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

    private void setWalls() {
        wallList = new ArrayList<Wall>();

        Wall wall;

        wall = new Wall(new Vector2(2, 17));
        wallList.add(wall);

//        wall = new Wall(new Vector2(10.5f, 5.5f));
//        wallList.add(wall);
//
//        wall = new Wall(new Vector2(15.5f, 13.5f));
//        wallList.add(wall);
//
//        wall = new Wall(new Vector2(3.5f, 8.5f));
//        wallList.add(wall);

        for(int i = 0; i < Constants.LEVEL_SCREEN_HEIGHT; i++) {
            for(int j = 0; j < Constants.LEVEL_SCREEN_WIDTH; j++) {
                worldMap[i][j] = 0;
            }
        }

        worldMap[2][17] = 1;

    }

}
