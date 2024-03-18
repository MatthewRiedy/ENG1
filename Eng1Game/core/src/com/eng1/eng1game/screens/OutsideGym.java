package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.eng1.eng1game.eng1Game;

public class OutsideGym implements Screen {
    Sprite sprite;
    private static float SPRITE_LOCATION_X = 500;
    private static final float SPRITE_LOCATION_Y = -260;
    private static final float SPRITE_WIDTH = 100;
    private static final float SPRITE_HEIGHT = 100;
    public static final float SPEED = 120;
    eng1Game game;

    Texture OutsideGym;
    public OutsideGym(eng1Game game){
        this.game = game;
        OutsideGym = new Texture("gym-building.jpg");
    }
    @Override
    public void show() {
        sprite = new Sprite(new Texture("Sprite1.png"));
    }

    @Override
    public void render(float delta) {

        game.batch.begin();
        game.batch.draw(OutsideGym, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        game.batch.draw(sprite, SPRITE_LOCATION_X, SPRITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-500){
                SPRITE_LOCATION_X=-500;

            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500){
                this.dispose();
                game.setScreen(new StudentAccomodationScreen(game));
                            }

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-500){
                SPRITE_LOCATION_X=-500;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500){

                this.dispose();
                game.setScreen(new StudentAccomodationScreen(game));
            }
        }

        if(SPRITE_LOCATION_X>-100 && SPRITE_LOCATION_X<100){
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                this.dispose();
                game.setScreen(new InsideGym(game));
            }
        }
        game.HUD();
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
