package com.victor.games.demo;

import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Created by Bicho Malo on 18/09/16.
 */
public class Level {
    public int id;
    public String name;
    public Vector2 startingPoint;
    public Vector2 endPoint;
    public List<BadGuy> badGuys;
    public List<Tresure> tresures;
    public float playerSpeed;
//    public Player player;
}
