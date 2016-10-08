package com.victor.games.demo.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.victor.games.demo.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Santamaria on 18/09/16.
 */
public class Player {
    
    public static final String TAG = Player.class.getName();

    public Vector2 position;

    private Vector2 playerStartingPoint;
    private Vector2 playerEndPoint;
    private float playerSpeed;
    private List<Wall> wallList;
    private int[][] worldMap;

    private Viewport viewport;

    private int deaths;

//    private int id;
//    private String name;

    public Player(Viewport viewport, Vector2 playerStartingPoint, Vector2 playerEndPoint,
                  float playerSpeed, List<Wall> wallList, int[][] worldMap) {
        this.viewport = viewport;
        this.playerStartingPoint = new Vector2(playerStartingPoint);
        this.playerEndPoint = new Vector2(playerEndPoint);
        this.playerSpeed = playerSpeed;
        this.wallList = new ArrayList<Wall>(wallList);
        this.worldMap = worldMap;
        deaths = 0;
        init();
    }

    public void init() {
        position = new Vector2(playerStartingPoint);
    }

    public void update(float delta) {
        keyboardInput(delta);
        accelerometer(delta);
//        touchInput(delta);

//        ensureInBounds();
//        checkWallCollisions();
    }

    private void touchInput(float delta) {
        if (Gdx.input.isTouched()) {
            float screenX = Gdx.input.getX();
            float screenY = Gdx.input.getY();
            Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));

            if (worldTouch.x > position.x + 1) {
                position.x += delta * playerSpeed;
            } else if (worldTouch.x < position.x - 1) {
                position.x -= delta * playerSpeed;
            }

            if (worldTouch.y > position.y + 1) {
                position.y += delta * playerSpeed;
            } else if (worldTouch.y < position.y - 1) {
                position.y -= delta * playerSpeed;
            }
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PLAYER_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.ENTITIES_RADIUS, 20);
    }

    private void accelerometer(float delta) {
        float accelerometerInputY = -Gdx.input.getAccelerometerY() /
                (Constants.GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);

        float accelerometerInputX = -Gdx.input.getAccelerometerX() /
                (Constants.GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);

        if (accelerometerInputY < -1) accelerometerInputY = -1;
        if (accelerometerInputY > 1) accelerometerInputY = 1;

        if (accelerometerInputX < -1) accelerometerInputX = -1;
        if (accelerometerInputX > 1) accelerometerInputX = 1;

        Vector2 move = new Vector2(-delta * accelerometerInputY * playerSpeed,
                                    delta * accelerometerInputX * playerSpeed);
        int playerCellX = (int) position.x;
        int playerCellY = (int) position.y;
//        position.x += -delta * accelerometerInputY * playerSpeed;
//        position.y += delta * accelerometerInputX * playerSpeed;
        position.x += move.x;
        position.y += move.y;

        ensureInBounds();

        checkY(move, playerCellX, playerCellY);
        if (playerCellX > 0 && ((int) position.x) == playerCellX - 1)
            checkY(move, playerCellX - 1, playerCellY);
        if (playerCellX < Constants.LEVEL_SCREEN_WIDTH - 1 && ((int) position.x) == playerCellX + 1)
            checkY(move, playerCellX + 1, playerCellY);

        checkX(move, playerCellX, playerCellY);
        if (playerCellY > 0 && ((int) position.y) == playerCellY - 1)
            checkX(move, playerCellX, playerCellY - 1);
        if (playerCellY < Constants.LEVEL_SCREEN_HEIGHT - 1 && ((int) position.y) == playerCellY + 1)
            checkX(move, playerCellX, playerCellY + 1);

    }

    private void checkX(Vector2 move, int playerCellX, int playerCellY) {
        if (playerCellX < Constants.LEVEL_SCREEN_WIDTH - 1
                && position.x + move.x + Constants.ENTITIES_RADIUS - playerCellX >= Constants.ENTITIES_SIZE
//                && position.x + move.x + Constants.ENTITIES_RADIUS > playerCellX
                && worldMap[playerCellX + 1][playerCellY] == 1) {
            position.x = playerCellX + Constants.ENTITIES_RADIUS;
        } else if (playerCellX > 0
                && position.x + move.x - Constants.ENTITIES_RADIUS < playerCellX
                && worldMap[playerCellX - 1][playerCellY] == 1) {
            position.x = playerCellX + Constants.ENTITIES_RADIUS;
        }
    }

    private void checkY(Vector2 move, int playerCellX, int playerCellY) {
        if (playerCellY < Constants.LEVEL_SCREEN_HEIGHT - 1
                && position.y + move.y + Constants.ENTITIES_RADIUS - playerCellY >= Constants.ENTITIES_SIZE
//                && position.y + move.y + Constants.ENTITIES_RADIUS > playerCellY
                && worldMap[playerCellX][playerCellY + 1] == 1) {
            position.y = playerCellY + Constants.ENTITIES_RADIUS;
        } else if (playerCellY > 0
                && position.y + move.y - Constants.ENTITIES_RADIUS < playerCellY
                && worldMap[playerCellX][playerCellY - 1] == 1) {
            position.y = playerCellY + Constants.ENTITIES_RADIUS;
        }
    }

    private void keyboardInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta * playerSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta * playerSpeed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += delta * playerSpeed;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= delta * playerSpeed;
        }
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

    private boolean checkWallCollisions() {
        for (Wall wall : wallList) {
            if (wall.position.dst(position) < Constants.ENTITIES_SIZE) {
                return true;
            }
        }
        return false;
    }
    /*
    private void checkWallCollisions() {
        float playerTop = position.y + Constants.ENTITIES_RADIUS;
        float playerBottom = position.y - Constants.ENTITIES_RADIUS;
        float playerRight = position.x + Constants.ENTITIES_RADIUS;
        float playerLeft = position.x - Constants.ENTITIES_RADIUS;

        for (Wall wall : wallList) {
            if (wall.position.dst(position) < Constants.ENTITIES_SIZE) {
                if (playerTop > wall.position.y) {
                    position.y = wall.position.y - Constants.ENTITIES_RADIUS;
                }
                if (playerBottom < wall.position.y + Constants.ENTITIES_SIZE) {
                    position.y = wall.position.y + Constants.ENTITIES_SIZE + Constants.ENTITIES_RADIUS;
                }
                if (playerRight > wall.position.x) {
                    position.x = wall.position.x - Constants.ENTITIES_RADIUS;
                }
                if (playerLeft < wall.position.x + Constants.ENTITIES_SIZE) {
                    position.x = wall.position.x + Constants.ENTITIES_SIZE + Constants.ENTITIES_RADIUS;
                }
            }
        }

    }
*/
    public boolean isHitByBadGuy(BadGuys badGuys) {
        boolean isHit = false;
        for (BadGuy badGuy : badGuys.getBadGuysList()) {
            if (badGuy.position.dst(position) < Constants.ENTITIES_SIZE) {
                isHit = true;
            }
        }
        if (isHit) {
            deaths += 1;
        }

        return isHit;
    }

}
