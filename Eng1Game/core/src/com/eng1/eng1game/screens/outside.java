package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.eng1.eng1game.Map;
import com.eng1.eng1game.eng1Game;

public class outside implements Screen {
    Map gameMap;
    OrthographicCamera camera;
    eng1Game game;
    Sprite sprite;
    private static float SPRITE_LOCATION_X = 320;
    private static float SPRITE_LOCATION_Y = 320;

    private static final float SPRITE_WIDTH = 40;
    private static final float SPRITE_HEIGHT = 40;
    private static final float SPEED = 200;

    Texture SpaceButton;
    public outside (eng1Game game){

        this.game = game;

        gameMap = new Map();

        SpaceButton = new Texture("SpaceButton.png");

        camera = new OrthographicCamera();

        camera.setToOrtho(false, 1024, 720);

        camera.update();

    }
    @Override
    public void show() {
        sprite = new Sprite(new Texture("Sprite1.png"));
    }

    @Override
    public void render(float delta) {

        gameMap.render(camera);
        game.batch.begin();
        game.batch.draw(sprite, SPRITE_LOCATION_X, SPRITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);
        //gameMap.setContactListener(new WorldContactListener());
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();

        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();

        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            SPRITE_LOCATION_Y = SPRITE_LOCATION_Y + SPEED * Gdx.graphics.getDeltaTime();

        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            SPRITE_LOCATION_Y = SPRITE_LOCATION_Y - SPEED * Gdx.graphics.getDeltaTime();

        }
        if(SPRITE_LOCATION_X >270 && SPRITE_LOCATION_X <300 && SPRITE_LOCATION_Y <300 && SPRITE_LOCATION_Y >270){
            game.batch.draw(SpaceButton, 330, 330, game.BUTTON_WIDTH, game.BUTTON_HEIGHT);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                    this.dispose();
                    game.setScreen(new DormRoomScreen(game));
            }
        }
        if(SPRITE_LOCATION_X >0 && SPRITE_LOCATION_X <50 && SPRITE_LOCATION_Y >40 && SPRITE_LOCATION_Y <90){
            game.batch.draw(SpaceButton, 0, 100, game.BUTTON_WIDTH, game.BUTTON_HEIGHT);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                this.dispose();
                game.setScreen(new InsideGym(game));
            }
        }
        if(SPRITE_LOCATION_X >-270 && SPRITE_LOCATION_X <-180 && SPRITE_LOCATION_Y >-250 && SPRITE_LOCATION_Y <-200){
            game.batch.draw(SpaceButton, -300, -270, game.BUTTON_WIDTH, game.BUTTON_HEIGHT);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                this.dispose();
                game.setScreen(new CanteenScreen(game));
            }
        }
        if(SPRITE_LOCATION_X >-320 && SPRITE_LOCATION_X <-270 && SPRITE_LOCATION_Y <200 && SPRITE_LOCATION_Y >150){
            game.batch.draw(SpaceButton, -300, 200, game.BUTTON_WIDTH, game.BUTTON_HEIGHT);
        }
        if(SPRITE_LOCATION_X <350 && SPRITE_LOCATION_X >270 && SPRITE_LOCATION_Y >-200 && SPRITE_LOCATION_Y <-150){
            game.batch.draw(SpaceButton, 300, -100, game.BUTTON_WIDTH, game.BUTTON_HEIGHT);
        }
        game.HUD();
        //world.setContactListener(new WorldContactListener());
        game.batch.end();
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
