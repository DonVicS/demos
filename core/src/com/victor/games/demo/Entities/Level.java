package com.victor.games.demo.Entities;

import com.badlogic.gdx.math.Vector2;

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

    public Level() {

    }

    public Level(int id, String name, Vector2 playerStartingPoint, Vector2 playerEndPoint,
                 float playerSpeed, List<BadGuy> badGuysList, List<Treasure> treasuresList) {
        this.id = id;
        this.name = name;
        this.playerStartingPoint = playerStartingPoint;
        this.playerEndPoint = playerEndPoint;
        this.playerSpeed = playerSpeed;
        this.badGuysList = badGuysList;
        this.treasuresList = treasuresList;
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
                '}';
    }
}
