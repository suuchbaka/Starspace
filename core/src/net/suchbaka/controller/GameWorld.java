package net.suchbaka.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import net.suchbaka.module.Entities;
import net.suchbaka.module.GameField;
import net.suchbaka.module.entities.Ball;
import net.suchbaka.module.entities.Brick;
import net.suchbaka.module.entities.Paddle;

public class GameWorld {

    private GameField gameField;
    private World world;

    public GameWorld(GameField gameField) {
        this.gameField = gameField;
        world = new World(new Vector2(1, 1), true);

        createWorldBodies();
    }

    private void createWorldBodies() {
        for (Entities e : gameField.getGameObjects().values()) {
            if (e instanceof Brick) {
                BodyDef bodyDef = new BodyDef();
                bodyDef.type = BodyDef.BodyType.StaticBody;

                bodyDef.position.set(pixelsToMeters(e.getX() + e.getWidth() / 2),
                        pixelsToMeters(e.getY() + e.getHeight() / 2));
                e.setBody(world.createBody(bodyDef));

                PolygonShape shape = new PolygonShape();
                shape.setAsBox(pixelsToMeters(e.getWidth() / 2),
                        pixelsToMeters(e.getHeight() / 2));

                FixtureDef fixtureDef = new FixtureDef();
                fixtureDef.shape = shape;

                Fixture fixture = e.getBody().createFixture(fixtureDef);
            } else if (e instanceof Ball) {
                BodyDef bodyDef = new BodyDef();
                bodyDef.type = BodyDef.BodyType.DynamicBody;

                bodyDef.position.set(pixelsToMeters(e.getX() + e.getWidth() / 2),
                        pixelsToMeters(e.getY() + e.getHeight() / 2));
                e.setBody(world.createBody(bodyDef));

                CircleShape shape = new CircleShape();
                shape.setRadius(pixelsToMeters(10.0f));

                FixtureDef fixtureDef = new FixtureDef();
                fixtureDef.shape = shape;
                fixtureDef.density = 0.1f;

                Fixture fixture = e.getBody().createFixture(fixtureDef);
            } else if (e instanceof Paddle) {
                BodyDef bodyDef = new BodyDef();
                bodyDef.type = BodyDef.BodyType.KinematicBody;

                bodyDef.position.set(pixelsToMeters(e.getX() + e.getWidth() / 2),
                        pixelsToMeters(e.getY() + e.getHeight() / 2));
                e.setBody(world.createBody(bodyDef));

                PolygonShape shape = new PolygonShape();
                shape.setAsBox(pixelsToMeters(e.getWidth() / 2),
                        pixelsToMeters(e.getHeight() / 2));

                FixtureDef fixtureDef = new FixtureDef();
                fixtureDef.shape = shape;

                Fixture fixture = e.getBody().createFixture(fixtureDef);
            }
        }
    }

    public void update(float delta) {
        world.step(delta, 8, 2);
    }

    private float pixelsToMeters(float number) {
        return number / 100;
    }

    public World getWorld() {
        return world;
    }
}
