package com.victor.games.demo.Entities;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Victor Santamaria on 19/09/16.
 */
public class Tresure {
    int id;
    String name;
    int value;
    Vector2 pos;

    public Tresure() {
    }

    public Tresure(int id, String name, int value, Vector2 pos) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.pos = pos;
    }
}
