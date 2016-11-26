package net.suchbaka.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import net.suchbaka.controller.GameWorld;
import net.suchbaka.module.GameField;
import net.suchbaka.view.StarspaceGame;

public class PlayScreen implements ScreenInterface {

    private StarspaceGame game;
    private SpriteBatch batch;
    private OrthographicCamera playCamera;
    private GameField gameField;
    private GameWorld gameWorld;
    private Matrix4 debugMatrix;
    private Box2DDebugRenderer b2dRenderer;

    public PlayScreen(StarspaceGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = game.getBatch();
        playCamera = new OrthographicCamera(game.getWIDTH(), game.getHEIGHT());
        playCamera.setToOrtho(false);
        gameField = new GameField(game);
        gameWorld = new GameWorld(gameField);
        debugMatrix = new Matrix4();
        b2dRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(playCamera.combined);

        batch.begin();
        gameField.draw(batch);
        batch.end();

        debugMatrix = batch.getProjectionMatrix().cpy().scale(100, 100, 0);
        b2dRenderer.render(gameWorld.getWorld(), debugMatrix);
    }

    public void update(float delta) {
        playCamera.update();
        gameWorld.update(delta);
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
