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
public class Map_01 {
    private Level level;

    private int id;
    private String name;

    private Vector2 playerStartingPoint;
    private Vector2 playerEndPoint;
    private float playerSpeed;

    private List<BadGuy> badGuysList;
    private List<Treasure> treasures;
    private List<Wall> wallList;
    private int[][] worldMap = new int[Constants.LEVEL_SCREEN_WIDTH][Constants.LEVEL_SCREEN_HEIGHT];

    public Map_01() {
        id = 3;
        name = "Map 1";
        playerStartingPoint = new Vector2(0 + Constants.ENTITIES_RADIUS,
                                        Constants.LEVEL_SCREEN_HEIGHT - Constants.ENTITIES_RADIUS);
        playerEndPoint = new Vector2(Constants.LEVEL_SCREEN_WIDTH - Constants.ENTITIES_RADIUS,
                                    Constants.LEVEL_SCREEN_HEIGHT - Constants.ENTITIES_RADIUS);
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

        BadGuy badGuy;

        badGuy = new BadGuy(new Vector2(0 + Constants.BAD_GUYS_RADIUS,
                                        14 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(11 + Constants.BAD_GUYS_RADIUS,
                                        14 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(11 + Constants.BAD_GUYS_RADIUS,
                                        8 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0 + Constants.BAD_GUYS_RADIUS,
                                        8 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(-5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(0 + Constants.BAD_GUYS_RADIUS,
                                        4 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(11 + Constants.BAD_GUYS_RADIUS,
                                        4 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(3 + Constants.BAD_GUYS_RADIUS,
                                        0 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(3 + Constants.BAD_GUYS_RADIUS,
                                        6 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, -5));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                                        0 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(5 + Constants.BAD_GUYS_RADIUS,
                                        8 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, -5));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                                        0 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(13 + Constants.BAD_GUYS_RADIUS,
                                        18 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, -5));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(15 + Constants.BAD_GUYS_RADIUS,
                                        17 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(15 + Constants.BAD_GUYS_RADIUS,
                                        0 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, 5));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(19 + Constants.BAD_GUYS_RADIUS,
                                        4 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(19 + Constants.BAD_GUYS_RADIUS,
                                        0 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, 2));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(25 + Constants.BAD_GUYS_RADIUS,
                                        0 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(25 + Constants.BAD_GUYS_RADIUS,
                                        16 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(0, -5));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(16 + Constants.BAD_GUYS_RADIUS,
                                        15 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(25 + Constants.BAD_GUYS_RADIUS,
                                        15 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(25 + Constants.BAD_GUYS_RADIUS,
                                        6 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(16 + Constants.BAD_GUYS_RADIUS,
                                        6 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(-5, 0));
        badGuysList.add(badGuy);

        badGuy = new BadGuy(new Vector2(17 + Constants.BAD_GUYS_RADIUS,
                                        10 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(23 + Constants.BAD_GUYS_RADIUS,
                                        10 + Constants.BAD_GUYS_RADIUS),
                            new Vector2(5, 0));
        badGuysList.add(badGuy);

    }

    private void setTreasures() {
        treasures = new ArrayList<Treasure>();

        Treasure treasure;

        treasure = new Treasure(new Vector2(0.5f, 16.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(1.5f, 16.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(2.5f, 16.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(8.5f, 18.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(0.5f, 12.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(0.5f, 10.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(0.5f, 6.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(1.5f, 6.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(2.5f, 6.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(0.5f, 1.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(1.5f, 1.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(2.5f, 1.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(0.5f, 0.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(1.5f, 0.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(2.5f, 0.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(8.5f, 6.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(9.5f, 6.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(8.5f, 0.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(17.5f, 18.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(18.5f, 18.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(19.5f, 18.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(20.5f, 18.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(17.5f, 8.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(18.5f, 8.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(19.5f, 8.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(20.5f, 8.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(21.5f, 8.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(22.5f, 8.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(23.5f, 8.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(17.5f, 2.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(17.5f, 1.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(17.5f, 0.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(23.5f, 3.5f));
        treasures.add(treasure);

        treasure = new Treasure(new Vector2(23.5f, 1.5f));
        treasures.add(treasure);
        treasure = new Treasure(new Vector2(23.5f, 0.5f));
        treasures.add(treasure);
    }

    private void setWalls() {
        wallList = new ArrayList<Wall>();

        Wall wall;

        wall = new Wall(new Vector2(2, 17));
        wallList.add(wall);

        for(int i = 0; i < Constants.LEVEL_SCREEN_WIDTH; i++) {
            for(int j = 0; j < Constants.LEVEL_SCREEN_HEIGHT; j++) {
                worldMap[i][j] = 0;
            }
        }

        worldMap[0][17] = 1;
        worldMap[1][17] = 1;
        worldMap[2][17] = 1;
        worldMap[3][17] = 1;
        worldMap[3][16] = 1;
        worldMap[4][16] = 1;
        worldMap[4][15] = 1;
        worldMap[5][15] = 1;

        worldMap[6][18] = 1;
        worldMap[7][18] = 1;
        worldMap[7][17] = 1;
        worldMap[8][17] = 1;
        worldMap[8][16] = 1;
        worldMap[8][15] = 1;

        worldMap[0][11] = 1;
        worldMap[1][11] = 1;

        worldMap[4][13] = 1;
        worldMap[4][12] = 1;
        worldMap[4][11] = 1;
        worldMap[4][10] = 1;
        worldMap[4][9] = 1;
        worldMap[5][9] = 1;
        worldMap[6][9] = 1;

        worldMap[7][13] = 1;
        worldMap[8][13] = 1;
        worldMap[9][13] = 1;
        worldMap[10][13] = 1;
        worldMap[11][13] = 1;
        worldMap[12][13] = 1;
        worldMap[12][14] = 1;
        worldMap[12][15] = 1;
        worldMap[12][16] = 1;
        worldMap[12][17] = 1;

        worldMap[0][7] = 1;
        worldMap[1][7] = 1;
        worldMap[2][7] = 1;
        worldMap[3][7] = 1;
        worldMap[4][7] = 1;
        worldMap[4][6] = 1;
        worldMap[4][5] = 1;

        worldMap[4][2] = 1;
        worldMap[4][1] = 1;
        worldMap[4][0] = 1;

        worldMap[7][5] = 1;
        worldMap[7][6] = 1;
        worldMap[7][7] = 1;
        worldMap[8][7] = 1;
        worldMap[9][7] = 1;
        worldMap[10][7] = 1;
        worldMap[10][6] = 1;
        worldMap[10][5] = 1;

        worldMap[7][1] = 1;
        worldMap[8][1] = 1;
        worldMap[9][1] = 1;

        worldMap[12][10] = 1;
        worldMap[12][9] = 1;
        worldMap[12][8] = 1;
        worldMap[12][7] = 1;
        worldMap[12][6] = 1;
        worldMap[12][5] = 1;
        worldMap[12][4] = 1;
        worldMap[12][3] = 1;

        worldMap[12][0] = 1;

        worldMap[16][18] = 1;
        worldMap[15][18] = 1;
        worldMap[14][18] = 1;
        worldMap[14][17] = 1;
        worldMap[14][16] = 1;
        worldMap[14][15] = 1;
        worldMap[14][14] = 1;
        worldMap[14][13] = 1;
        worldMap[14][12] = 1;
        worldMap[14][11] = 1;
        worldMap[14][10] = 1;
        worldMap[14][9] = 1;
        worldMap[14][8] = 1;
        worldMap[14][7] = 1;
        worldMap[14][6] = 1;
        worldMap[14][5] = 1;
        worldMap[14][4] = 1;
        worldMap[14][3] = 1;
        worldMap[14][2] = 1;

        worldMap[16][16] = 1;
        worldMap[17][16] = 1;
        worldMap[18][16] = 1;
        worldMap[19][16] = 1;
        worldMap[20][16] = 1;
        worldMap[21][16] = 1;
        worldMap[21][17] = 1;
        worldMap[21][18] = 1;

        worldMap[25][17] = 1;
        worldMap[24][17] = 1;
        worldMap[24][16] = 1;

        
        worldMap[17][14] = 1;
        worldMap[18][14] = 1;
        worldMap[19][14] = 1;

        worldMap[22][14] = 1;
        worldMap[23][14] = 1;
        worldMap[24][14] = 1;

        worldMap[16][13] = 1;
        worldMap[16][12] = 1;
        worldMap[16][11] = 1;
        worldMap[16][10] = 1;
        worldMap[16][9] = 1;
        worldMap[16][8] = 1;
        worldMap[16][7] = 1;

        worldMap[24][13] = 1;
        worldMap[24][12] = 1;
        worldMap[24][11] = 1;
        worldMap[24][10] = 1;
        worldMap[24][9] = 1;
        worldMap[24][8] = 1;
        worldMap[24][7] = 1;

        worldMap[17][7] = 1;
        worldMap[18][7] = 1;
        worldMap[19][7] = 1;
        worldMap[20][7] = 1;
        worldMap[21][7] = 1;
        worldMap[22][7] = 1;
        worldMap[23][7] = 1;

        worldMap[18][11] = 1;
        worldMap[19][11] = 1;
        worldMap[20][11] = 1;
        worldMap[21][11] = 1;
        worldMap[22][11] = 1;

        worldMap[16][0] = 1;
        worldMap[16][1] = 1;
        worldMap[16][2] = 1;
        worldMap[16][3] = 1;
        worldMap[17][3] = 1;
        worldMap[17][4] = 1;
        worldMap[17][5] = 1;
        worldMap[18][5] = 1;
        worldMap[19][5] = 1;

        worldMap[22][5] = 1;
        worldMap[23][5] = 1;
        worldMap[23][4] = 1;
        worldMap[24][4] = 1;
        worldMap[24][3] = 1;
        worldMap[24][2] = 1;
        worldMap[23][2] = 1;
        worldMap[22][2] = 1;
        worldMap[22][1] = 1;
        worldMap[22][0] = 1;

    }

}
