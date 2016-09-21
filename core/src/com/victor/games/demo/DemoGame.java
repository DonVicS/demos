package com.victor.games.demo;

import com.badlogic.gdx.Game;

public class DemoGame extends Game {
	
	@Override
	public void create () {
		showMainScreen();
	}

    public void showMainScreen() {
        setScreen(new MainScreen(this));
    }

    public void showLevelScreen(int level) {
        setScreen(new LevelScreen(this, level));
    }

    public void showSaveScreen() {
        setScreen(new SaveScreen(this));
    }

    public void showLoadScreen() {
        setScreen(new LoadScreen(this));
    }

}
