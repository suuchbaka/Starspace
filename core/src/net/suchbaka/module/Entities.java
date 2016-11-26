package net.suchbaka.module;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class Entities extends Sprite {

    private Body body;

    public Entities(TextureRegion region, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(region, srcX, srcY, srcWidth, srcHeight);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public float getWidth() {
        return super.getWidth();
    }

    @Override
    public float getHeight() {
        return super.getHeight();
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }

    public void update(float delta) {
        setPosition((body.getPosition().x * 100) - getWidth() / 2,
                (body.getPosition().y * 100) - getHeight() / 2);
    }

    public Entities setBody(Body body) {
        this.body = body;
        return this;
    }

    public Body getBody() {
        return body;
    }
}
