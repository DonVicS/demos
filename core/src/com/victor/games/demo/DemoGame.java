package com.victor.games.demo;

import com.badlogic.gdx.Game;
import com.victor.games.demo.screens.CreditsScreen;
import com.victor.games.demo.screens.LoadScreen;
import com.victor.games.demo.screens.MainScreen;
import com.victor.games.demo.screens.SaveScreen;

public class DemoGame extends Game {
	
	@Override
	public void create () {
		showMainScreen();
	}

    public void showMainScreen() {
        setScreen(new MainScreen(this));
    }

    public void showLevelScreen(int level) {
        setScreen(new com.victor.games.demo.screens.LevelScreen(this, level));
    }

    public void showSaveScreen() {
        setScreen(new SaveScreen(this));
    }

    public void showLoadScreen() {
        setScreen(new LoadScreen(this));
    }

    public void showCreditsScreen() {
        setScreen(new CreditsScreen(this));
    }

}
