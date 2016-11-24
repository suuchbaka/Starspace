package net.suchbaka.module;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;
import net.suchbaka.module.entities.Brick;
import net.suchbaka.view.StarspaceGame;

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

        defineObjects();
    }

    private void defineObjects() {
        addBricks(10, 5);
    }

    private void addBricks(int brickInARow, int rows) {
        int brickToPlace = brickInARow;
        int brickWidth = atlas.findRegion("element_blue_rectangle").getRegionWidth();
        int brickHeight = atlas.findRegion("element_blue_rectangle").getRegionHeight();

        int x = 0;
        int y = 570;

        if (brickInARow > game.getHEIGHT() / brickHeight)
            brickInARow = game.getHEIGHT() / brickHeight;

        while (rows != 0) {
            brickToPlace = brickInARow;
            while (brickToPlace != 0) {
                gameObjects.put(objectIndex, new Brick(atlas.findRegion("element_blue_rectangle"), x, y, brickWidth, brickHeight));
                x += brickWidth;
                objectIndex++;
                brickToPlace--;
            }

            y -= brickHeight;
            rows--;
        }
    }

    public void draw(SpriteBatch batch) {
        for (Entities e : gameObjects.values()) {
            e.draw(batch);
        }
    }
}
