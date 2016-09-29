package com.victor.games.demo.levels;

import com.victor.games.demo.Entities.Level;

/**
 * Created by Victor Santamaria on 30/09/16.
 */
public class LevelManager {

    public static Level get(int levelId) {
        Level level = new Level();
        switch (levelId) {
            case 1: level = new Level_01().get();
                break;
            case 2: level = new Level_02().get();
                break;
        }
        return level;
    }

}
