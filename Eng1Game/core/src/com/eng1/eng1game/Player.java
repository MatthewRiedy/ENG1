package com.eng1.eng1game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {
    private Vector2 velocity = new Vector2();
    private float speed = 60 * 2;
    private TiledMapTileLayer collisionLayer;
    private String blockedKey = "blocked";
    private int targetX;
    private int targetY;
    float stateTime = 0f;
    SpriteBatch batch;
    Animation animation;
    TextureRegion[][] frames;
    int frame;
    private Sprite currentFrame;
    public Player (TiledMapTileLayer collisionLayer){
        Texture spriteSheet = new Texture(Gdx.files.internal("Main Character.png"));
        frames = TextureRegion.split(spriteSheet,16,32);
        this.collisionLayer = collisionLayer;
        setSize(getWidth(),getHeight());
        batch = new SpriteBatch();
        frame = 0;
        currentFrame = new Sprite(frames[0][4]);
    }
    public void draw() {
        update(Gdx.graphics.getDeltaTime());
        batch.begin();
        batch.draw(currentFrame, getX(), getY());
        batch.end();
    }
    public void update(float delta) {
        //animation
        stateTime += delta;
        //currentFrame = animation.getKeyFrame(stateTime, true);

        //Collision.
        // This keeps track of the previous position.
        float oldX = getX();
        float oldY = getY();
        float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();

        boolean collideX = false, collideY = false;

        // move on X
        setX(getX() + velocity.x * delta);
        if (velocity.x < 0) { // left
            collideX = collidesLeft();
        } else if (velocity.x > 0) { //right
            collideX = collidesRight();
        }

        if (collideX) {
            setX(oldX);
            velocity.x = 0;
        }

        // move on Y
        setY(getY() + velocity.y * delta);

        if (velocity.y < 0) { // going down
            collideY = collidesBottom();

        } else if (velocity.y > 0) { // going up
            collideY = collidesTop();
        }

        if (collideY) {
            setY(oldY);
            velocity.y = 0;
        }


    }

    private boolean isCellBlocked(float x, float y) {
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
    }

    public boolean collidesRight() {
        for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
            if(isCellBlocked(getX() + getWidth(), getY() + step))
                return true;
        return false;
    }

    public boolean collidesLeft() {
        for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
            if(isCellBlocked(getX(), getY() + step))
                return true;
        return false;
    }

    public boolean collidesTop() {
        for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
            if(isCellBlocked(getX() + step, getY() + getHeight()))
                return true;
        return false;
    }

    public boolean collidesBottom() {
        for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
            if(isCellBlocked(getX() + step, getY()))
                return true;
        return false;
    }


    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
    }
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                currentFrame = new Sprite(walk(6));
                velocity.y += speed;
                break;
            case Input.Keys.A:
                currentFrame = new Sprite(walk(12));
                velocity.x -= speed;
                break;
            case Input.Keys.D:
                currentFrame = new Sprite(walk(0));
                velocity.x += speed;
                break;
            case Input.Keys.S:
                currentFrame = new Sprite(walk(18));
                velocity.y -= speed;
                break;
        }
        return true;
    }
    private TextureRegion walk(int offset){
        TextureRegion currentFrame = frames[2][frame+offset];
        frame += 1;
        frame = frame % 6;
        return currentFrame;
    }
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
            case Input.Keys.S:
                frame = 0;
                velocity.y = 0;
                break;
            case Input.Keys.A:
            case Input.Keys.D:
                frame = 0;
                velocity.x = 0;
                break;
            }
            return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            // Some stuff
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {

            return true;
        }
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
