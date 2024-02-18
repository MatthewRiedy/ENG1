package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;

public class DormRoomScreen implements Screen {

    Sprite sprite;
    private static float SPITE_LOCATION_X = -150;
    private static final float SPITE_LOCATION_Y = -300;

    private static final float SPRITE_WIDTH = 100;
    private static final float SPRITE_HEIGHT = 100;
    public static final float SPEED = 120;

    eng1Game game;

    Texture DormRoomBackground;


    public DormRoomScreen(eng1Game game){
        this.game = game;
        DormRoomBackground = new Texture("Dorm Room 2.png");
    }

    @Override
    public void show () {
        sprite = new Sprite(new Texture("Sprite1.png"));

    }

    @Override
    public void render (float delta) {


        //if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            //y = y + SPEED * Gdx.graphics.getDeltaTime();
        //}


        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.dispose();
            game.setScreen(new StudentAccomodationScreen(game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPITE_LOCATION_X = SPITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPITE_LOCATION_X = SPITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
        }
        game.batch.draw(DormRoomBackground,eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        game.batch.draw(sprite, SPITE_LOCATION_X, SPITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);
        game.batch.end();
    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {

    }
}
