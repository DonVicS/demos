package com.victor.games.demo.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.victor.games.demo.utils.Constants;

/**
 * Created by Victor Santamaria on 18/09/16.
 */
public class Player {
    
    public static final String TAG = Player.class.getName();

    private Vector2 position;

    private Vector2 playerStartingPoint;
    private Vector2 playerEndPoint;
    private float playerSpeed;

    private Viewport viewport;

    private int deaths;

//    private int id;
//    private String name;

    public Player(Viewport viewport,Vector2 playerStartingPoint,
                  Vector2 playerEndPoint, float playerSpeed) {
        this.viewport = viewport;
        this.playerStartingPoint = new Vector2(playerStartingPoint);
        this.playerEndPoint = new Vector2(playerEndPoint);
        this.playerSpeed = playerSpeed;
        deaths = 0;
        init();
    }

    public void init() {
        position = new Vector2(playerStartingPoint);
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta * playerSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta * playerSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += delta * playerSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= delta * playerSpeed;
        }

        float accelerometerInputY = -Gdx.input.getAccelerometerY() /
                (Constants.GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);

        float accelerometerInputX = -Gdx.input.getAccelerometerX() /
                (Constants.GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);

        position.x += -delta * accelerometerInputY * playerSpeed;
        position.y += delta * accelerometerInputX * playerSpeed;

        ensureInBounds();
    }

    private void ensureInBounds() {
        if (position.x - Constants.ENTITIES_RADIUS < 0) {
            position.x = Constants.ENTITIES_RADIUS;
        }
        if (position.x + Constants.ENTITIES_RADIUS > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - Constants.ENTITIES_RADIUS;
        }
        if (position.y - Constants.ENTITIES_RADIUS < 0) {
            position.y = Constants.ENTITIES_RADIUS;
        }
        if (position.y + Constants.ENTITIES_RADIUS > viewport.getWorldHeight()) {
            position.y = viewport.getWorldHeight() - Constants.ENTITIES_RADIUS;
        }
    }

    public boolean isHitByBadGuy(BadGuys badGuys) {
        boolean isHit = false;
        for (BadGuy badGuy : badGuys.getBadGuysList()) {
            if (badGuy.position.dst(position) < Constants.ENTITIES_RADIUS) {
                isHit = true;
            }
        }
        if (isHit) {
            deaths += 1;
        }

        return isHit;
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PLAYER_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.ENTITIES_RADIUS, 20);
    }

}
