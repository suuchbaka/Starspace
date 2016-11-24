package net.suchbaka.view.screens;

import com.badlogic.gdx.Screen;

interface ScreenInterface extends Screen {
    @Override
    void show();

    @Override
    void render(float delta);

    @Override
    void resize(int width, int height);

    @Override
    void pause();

    @Override
    void resume();

    @Override
    void hide();

    @Override
    void dispose();
}
