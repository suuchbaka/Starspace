package net.suchbaka.module.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import net.suchbaka.module.Entities;

public class Star extends Entities {
    public Star(TextureRegion region, int srcX, int srcY, int srcWidth, int srcHeight) {
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
}
