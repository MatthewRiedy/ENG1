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
    private static float SPRITE_LOCATION_X = -100;
    private static final float SPRITE_LOCATION_Y = -400;
    private static final float SPRITE_WIDTH = 100;
    private static final float SPRITE_HEIGHT = 100;

    //Space Button
    public static final int SPACEBUTTON_WIDTH = 100;
    public static final int SPACEBUTTON_HEIGHT = 50;
    public static final float SPEED = 120;

    eng1Game game;

    Texture StudentAccomodationBackground;

    Texture SpaceButton;


    public StudentAccomodationScreen(eng1Game game){
        this.game = game;
        StudentAccomodationBackground = new Texture("StudentAccom2.png");
        SpaceButton = new Texture("SpaceButton.png");
    }
    @Override
    public void show() {
        sprite = new Sprite(new Texture("Sprite1.png"));
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();

        game.batch.draw(StudentAccomodationBackground,eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        game.batch.draw(sprite, SPRITE_LOCATION_X, SPRITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-500){
                this.dispose();
                game.setScreen(new OutsideGym(game));
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500){
                this.dispose();
                game.setScreen(new PiazzaBuildingScreen(game));            }

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-500){
                this.dispose();
                game.setScreen(new OutsideGym(game));
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500){
                this.dispose();
                game.setScreen(new PiazzaBuildingScreen(game));
            }
        }
        if(SPRITE_LOCATION_X>-100 && SPRITE_LOCATION_X<-50){
            game.batch.draw(SpaceButton, 0, SPRITE_HEIGHT, SPACEBUTTON_WIDTH,SPACEBUTTON_HEIGHT);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                game.setScreen(new DormRoomScreen(game));

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
