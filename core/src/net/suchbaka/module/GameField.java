package net.suchbaka.module;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;
import net.suchbaka.controller.HandleInput;
import net.suchbaka.module.entities.Ball;
import net.suchbaka.module.entities.Brick;
import net.suchbaka.module.entities.Paddle;
import net.suchbaka.module.entities.Star;
import net.suchbaka.view.StarspaceGame;

import java.util.Random;

public class GameField {
    private StarspaceGame game;
    private ObjectMap<Integer, Entities> gameObjects;
    private TextureAtlas atlas;


    private String levelString;
    private int objectIndex = 0;

    public GameField(StarspaceGame game) {
        this.game = game;
        gameObjects = new ObjectMap<Integer, Entities>();
        atlas = new TextureAtlas("arkanoid.pack");

        Gdx.input.setInputProcessor(new HandleInput(this));

        defineObjects();
    }

    private void defineObjects() {
        addStars(20);
        addBricks(10, 5);
        addBall(50, 50);
        addPaddle(game.getHEIGHT() / 2, 0);
    }

    private void addBricks(int brickInARow, int rows) {
        int brickToPlace = brickInARow;
        int brickWidth = atlas.findRegion("element_blue_rectangle").getRegionWidth();
        int brickHeight = atlas.findRegion("element_blue_rectangle").getRegionHeight();

        int x = 0;
        int y = game.getHEIGHT() - brickHeight;

        if (brickInARow > game.getHEIGHT() / brickHeight)
            brickInARow = game.getHEIGHT() / brickHeight;

        while (rows != 0) {
            brickToPlace = brickInARow;
            while (brickToPlace != 0) {
                gameObjects.put(objectIndex, new Brick(atlas.findRegion("element_blue_rectangle"), 0, 0, brickWidth, brickHeight));
                gameObjects.get(objectIndex).setPosition(x, y);
                objectIndex++;
                x += brickWidth;
                brickToPlace--;
            }
            x = 0;
            y -= brickHeight;
            rows--;
        }
    }

    private void addBall(int x, int y) {
        int ballWidth = atlas.findRegion("ballBlue").getRegionWidth();
        int ballHeight = atlas.findRegion("ballBlue").getRegionHeight();

        gameObjects.put(objectIndex, new Ball(atlas.findRegion("ballBlue"), 0, 0, ballWidth, ballHeight));
        gameObjects.get(objectIndex).setPosition(x, y);
        objectIndex++;
    }

    private void addPaddle(int x, int y) {
        int paddleWidth = atlas.findRegion("paddleBlu").getRegionWidth();
        int paddleHeight = atlas.findRegion("paddleBlu").getRegionHeight();

        gameObjects.put(objectIndex, new Paddle(atlas.findRegion("paddleBlu"), 0, 0, paddleWidth, paddleHeight));
        gameObjects.get(objectIndex).setPosition(x, y);
        objectIndex++;
    }

    private void addStars(int bounds) {
        int starWidth = atlas.findRegion("particleCartoonStar").getRegionWidth();
        int starHeight = atlas.findRegion("particleCartoonStar").getRegionHeight();

        int starsCount = new Random().nextInt(bounds);

        while (starsCount != 0) {
            int x = new Random().nextInt(game.getWIDTH());
            int y = new Random().nextInt(game.getHEIGHT());

            gameObjects.put(objectIndex, new Star(atlas.findRegion("particleCartoonStar"), 0, 0, starWidth, starHeight));
            gameObjects.get(objectIndex).setPosition(x, y);
            objectIndex++;
            starsCount--;
        }
    }

    public void draw(SpriteBatch batch) {
        update(Gdx.graphics.getDeltaTime());

        for (Entities e : gameObjects.values()) {
            e.draw(batch);
        }
    }

    public void update(float delta) {
        for (Entities e : gameObjects.values()) {
            if (!(e instanceof Star)) {
                e.update(delta);
            }
        }
    }

    public ObjectMap<Integer, Entities> getGameObjects() {
        return gameObjects;
    }
}
