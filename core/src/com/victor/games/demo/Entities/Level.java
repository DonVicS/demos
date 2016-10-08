package com.victor.games.demo.Entities;

import com.badlogic.gdx.math.Vector2;
import com.victor.games.demo.utils.Constants;

import java.util.List;

/**
 * Created by Victor Santamaria on 18/09/16.
 */
public class Level {
    public int id;
    public String name;

    public Vector2 playerStartingPoint;
    public Vector2 playerEndPoint;
    public float playerSpeed;

    public List<BadGuy> badGuysList;
    public List<Treasure> treasuresList;
    public List<Wall> wallList;
    public int[][] worldMap = new int[Constants.LEVEL_SCREEN_WIDTH][Constants.LEVEL_SCREEN_HEIGHT];

    public Level() {

    }

    public Level(int id, String name, Vector2 playerStartingPoint, Vector2 playerEndPoint,
                 float playerSpeed, List<BadGuy> badGuysList, List<Treasure> treasuresList,
                 List<Wall> wallList, int[][] worldMap) {
        this.id = id;
        this.name = name;
        this.playerStartingPoint = playerStartingPoint;
        this.playerEndPoint = playerEndPoint;
        this.playerSpeed = playerSpeed;
        this.badGuysList = badGuysList;
        this.treasuresList = treasuresList;
        this.wallList = wallList;
        this.worldMap = worldMap;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerStartingPoint=" + playerStartingPoint +
                ", playerEndPoint=" + playerEndPoint +
                ", playerSpeed=" + playerSpeed +
                ", badGuysList=" + badGuysList +
                ", treasuresList=" + treasuresList +
                ", wallList=" + wallList +
                ", worldMap=" + worldMap +
                '}';
    }
}
