package com.eng1.eng1game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.eng1.eng1game.eng1Game;

public class InsideGym implements Screen {
    Sprite sprite;
    private static float SPRITE_LOCATION_X = 60;
    private static final float SPRITE_LOCATION_Y = -420;
    private static final float SPRITE_WIDTH = 100;
    private static final float SPRITE_HEIGHT = 100;
    public static final float SPEED = 120;
    public static final int SPACEBUTTON_WIDTH = 100;
    public static final int SPACEBUTTON_HEIGHT = 50;
    eng1Game game;
    Texture InsideGym;
    Texture SpaceButton;
    Texture ExerciseButton;
    public InsideGym(eng1Game game){
        this.game = game;
        SpaceButton = new Texture("SpaceButton.png");
        ExerciseButton = new Texture("ExerciseWord.png");
        InsideGym = new Texture("gym-inside2.jpg");
    }
    @Override
    public void show() {
        sprite = new Sprite(new Texture("Sprite1.png"));
    }

    @Override
    public void render(float delta) {

        game.batch.begin();
        game.batch.draw(InsideGym, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        game.batch.draw(sprite, SPRITE_LOCATION_X, SPRITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.dispose();
            game.setScreen(new outside(game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            this.dispose();
            game.setScreen(new outside(game));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-500){
                SPRITE_LOCATION_X=-500;

            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500){
                SPRITE_LOCATION_X=500;
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
            SPRITE_LOCATION_X=500;
            }
        }
        if(SPRITE_LOCATION_X>-100 && SPRITE_LOCATION_X<50) {
            game.batch.draw(SpaceButton, -150, 0, SPACEBUTTON_WIDTH, SPACEBUTTON_HEIGHT);
            game.batch.draw(ExerciseButton, -150, 0 + SPACEBUTTON_HEIGHT, SPACEBUTTON_WIDTH, SPACEBUTTON_HEIGHT);
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                game.energy -= 0.25;
                game.exercise+=4;
                game.worldTimer-=16;
            }
        }
        if(SPRITE_LOCATION_X>-450 && SPRITE_LOCATION_X<-300) {
            game.batch.draw(SpaceButton, -350, 0, SPACEBUTTON_WIDTH, SPACEBUTTON_HEIGHT);
            game.batch.draw(ExerciseButton, -350, 0 + SPACEBUTTON_HEIGHT, SPACEBUTTON_WIDTH, SPACEBUTTON_HEIGHT);
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                game.energy -= 0.5;
                game.exercise+=4;
                game.worldTimer-=16;
            }
        }
        if(SPRITE_LOCATION_X<400 && SPRITE_LOCATION_X>250) {
            game.batch.draw(SpaceButton, 300, 0, SPACEBUTTON_WIDTH, SPACEBUTTON_HEIGHT);
            game.batch.draw(ExerciseButton, 300, 0 + SPACEBUTTON_HEIGHT, SPACEBUTTON_WIDTH, SPACEBUTTON_HEIGHT);
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                game.energy -= 0.5;
                game.exercise+=4;
                game.worldTimer-=16;
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

