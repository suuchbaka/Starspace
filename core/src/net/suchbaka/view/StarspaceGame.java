package net.suchbaka.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.suchbaka.view.screens.PlayScreen;

public class StarspaceGame extends Game {

    private SpriteBatch batch;
    private PlayScreen playScreen;

    private int WIDTH;
    private int HEIGHT;

    @Override
    public void create() {
        batch = new SpriteBatch();
        playScreen = new PlayScreen(this);
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        setScreen(playScreen);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
