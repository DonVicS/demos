package com.victor.games.demo;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Bicho Malo on 18/09/16.
 */
public class BadGuy {
    public int id;
    public String name;
    public Vector2 startingPoint;
    public Vector2 endPoint;
    public Vector2 speed;

    public BadGuy() {
    }

    public BadGuy(BadGuy badGuy) {
        this.id = badGuy.id;
        this.name = badGuy.name;
        this.startingPoint = badGuy.startingPoint;
        this.endPoint = badGuy.endPoint;
        this.speed = badGuy.speed;
    }

    public BadGuy(int id, String name, Vector2 startingPoint, Vector2 endPoint, Vector2 speed) {
        this.id = id;
        this.name = name;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector2 getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Vector2 startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Vector2 getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Vector2 endPoint) {
        this.endPoint = endPoint;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "BadGuy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startingPoint=" + startingPoint +
                ", endPoint=" + endPoint +
                ", speed=" + speed +
                '}';
    }
}
