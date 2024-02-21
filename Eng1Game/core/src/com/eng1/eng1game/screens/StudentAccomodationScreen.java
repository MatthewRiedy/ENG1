package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;

public class StudentAccomodationScreen implements Screen {

    Sprite sprite;
    private static float SPITE_LOCATION_X = 0;
    private static final float SPITE_LOCATION_Y = -400;
    private static final float SPRITE_WIDTH = 100;
    private static final float SPRITE_HEIGHT = 100;
    public static final float SPEED = 120;

    eng1Game game;

    Texture StudentAccomodationBackground;


    public StudentAccomodationScreen(eng1Game game){
        this.game = game;
        StudentAccomodationBackground = new Texture("StudentAccom2.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();

        game.batch.draw(StudentAccomodationBackground,eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        game.batch.draw(sprite, SPITE_LOCATION_X, SPITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPITE_LOCATION_X = SPITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPITE_LOCATION_X = SPITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
        }


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
