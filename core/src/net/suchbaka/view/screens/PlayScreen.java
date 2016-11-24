package net.suchbaka.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.suchbaka.module.GameField;
import net.suchbaka.view.StarspaceGame;

public class PlayScreen implements ScreenInterface {

    private StarspaceGame game;
    private SpriteBatch batch;
    private OrthographicCamera playCamera;

    //test
    private GameField gameField;

    public PlayScreen(StarspaceGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = game.getBatch();
        playCamera = new OrthographicCamera(game.getWIDTH(), game.getHEIGHT());
        playCamera.setToOrtho(false);

        gameField = new GameField(game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(playCamera.combined);

        batch.begin();
        gameField.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
