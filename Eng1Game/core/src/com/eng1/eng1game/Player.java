package com.eng1.eng1game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;


public class Player extends Sprite implements InputProcessor {
    //movement variables
    private final Vector2 velocity = new Vector2();
    private final TiledMapTileLayer collisionLayer;
    //animation variables
    float stateTime = 0f;
    SpriteBatch batch;
    TextureRegion[][] frames;
    int frame;
    private Sprite currentFrame;
    // interaction variables
    eng1Game game;
    Map map;
    private int offset;
    private boolean moving = false;

    public Player (TiledMapTileLayer collisionLayer, eng1Game game, Map map){
        // saving other instances of classes to this instance of class
        this.game = game;
        this.map = map;

        Texture spriteSheet = new Texture(Gdx.files.internal("Main Character.png"));//loads the textures for the player
        frames = TextureRegion.split(spriteSheet,16,32);//splits the textures into an array
        this.collisionLayer = collisionLayer;//setting the collision layer for the player
        setSize(getWidth(),getHeight());
        batch = new SpriteBatch();
        frame = 0;//start of the animation frame loop
        currentFrame = new Sprite(frames[0][3]);
        this.draw();//draws the character after it has been set up
    }
    //funciton to render the player
    public void draw() {
        update(Gdx.graphics.getDeltaTime());
        batch.begin();
        if (moving){
            currentFrame = new Sprite(walk(offset));
        }
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
    //function to easily see if tiles that would be moved into have the custom property "blocked"
    private boolean isCellBlocked(float x, float y) {
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
        String blockedKey = "blocked";
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
    }
//collision for different directions
    public boolean collidesRight() {
        for(float step = 0; step < 16; step += 8)
            if(isCellBlocked(getX() + 2 * getWidth(), getY() + step))
                return true;
        return false;
    }

    public boolean collidesLeft() {
        for(float step = 0; step < 16; step += 8)
            if(isCellBlocked(getX(), getY() + step))
                return true;
        return false;
    }

    public boolean collidesTop() {
        for(float step = 0; step < 16; step += 8)
            if(isCellBlocked(getX() + step, getY() + getHeight()))
                return true;
        return false;
    }
    public boolean collidesBottom() {
        for(float step = 0; step < 16; step += 8)
            if(isCellBlocked(getX() + step, getY()))
                return true;
        return false;
    }
    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    @Override// takes user input and updates variables accordingly
    public boolean keyDown(int keycode) {
        float speed = 25 * 2;
        moving = true;
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
            case Input.Keys.SPACE:
                String[] action= map.interacting();
                if (action != null){
                    interact(action);
                }
                else {
                    break;
                }
                break;
        }
        return true;
    }
    // function to get the current sprite texture for the animation
    private TextureRegion walk(int offset){
        this.offset = offset;
        TextureRegion currentFrame = frames[2][frame+offset];
        frame += 1;
        frame = frame % 6;
        return currentFrame;
    }
    @Override//resets variables when a key is no longer being pressed
    public boolean keyUp(int keycode) {
        moving = false;
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
        // Some stuff
        return button == Input.Buttons.LEFT;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return button == Input.Buttons.LEFT;
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
    //interaction with the object layer
    public void interact(String[] action){
        for(Location location : Location.values())//for loop of all possible scenes
            if (action[0].equals(location.getName())){//checks the if its going to a scene
                //reformatting object data
                String spawn = action[1];
                String[] pos = spawn.split(" ");
                //create new spawn position
                int[] position = new int[]{Integer.parseInt(pos[0]),Integer.parseInt(pos[1])};
                //end the previous map and render the next
                map.dispose();
                game.setScreen(new Map(game,action[0]+".tmx", position));
            }
        //if the action isnt a location, checks which interaction it is, and performs that fucntion via the eng1Game instance
        switch (action[0]) {
            case "eat":
                if (game.time < 16 && game.energy >= 1) {
                    game.eat();
                }
                break;
            case "sleep":
                game.sleep();
                break;
            case "enjoy":
                if (game.time < 16 && game.energy >= 1) {
                    game.enjoy();
                }
                break;
            case "study":
                if (game.time < 16 && game.energy >= 4) {
                    game.study();
                }
                break;
        }
    }

}