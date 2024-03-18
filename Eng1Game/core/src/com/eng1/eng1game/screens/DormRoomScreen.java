package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;

public class DormRoomScreen implements Screen {

    Sprite sprite;
    private static float SPRITE_LOCATION_X = 0;
    private static final float SPRITE_LOCATION_Y = -300;

    private static final float SPRITE_WIDTH = 100;
    private static final float SPRITE_HEIGHT = 100;
    public static final float SPEED = 200;

    //Space Button
    public static final int SPACEBUTTON_WIDTH = 100;
    public static final int SPACEBUTTON_HEIGHT = 50;
    //Study Word
    public static final int STUDYWORD_WIDTH = 100;
    public static final int STUDYWORD_HEIGHT = 50;

    //Sleep Word
    public static final int SLEEPWORD_WIDTH = 100;
    public static final int SLEEPWORD_HEIGHT = 50;

    private Music music;


    eng1Game game;

    Texture DormRoomBackground;

    Texture SpaceButton;
    Texture StudyWord;
    Texture SleepWord;


    public DormRoomScreen(eng1Game game){
        this.game = game;
        DormRoomBackground = new Texture("Dorm Room 2.png");
        SpaceButton = new Texture("SpaceButton.png");
        StudyWord = new Texture("StudyWord.png");
        SleepWord = new Texture("SleepWord.png");

        if(game.Ticked) {
            music = eng1Game.manager.get("audios/TimTaj - Aspire Background.mp3", Music.class);
            music.setLooping(true);
            music.play();
        }
        else{
            music.stop();
        }
    }

    @Override
    public void show () {
        sprite = new Sprite(new Texture("Sprite1.png"));

    }

    @Override
    public void render (float delta) {

        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.dispose();
            game.setScreen(new outside(game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-300){
                SPRITE_LOCATION_X=-300;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500-SPRITE_WIDTH){
                SPRITE_LOCATION_X=500-SPRITE_WIDTH;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X - SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X<-300){
                SPRITE_LOCATION_X=-300;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            SPRITE_LOCATION_X = SPRITE_LOCATION_X + SPEED * Gdx.graphics.getDeltaTime();
            if(SPRITE_LOCATION_X>500-SPRITE_WIDTH){
                SPRITE_LOCATION_X=500-SPRITE_WIDTH;
            }
        }
        game.batch.draw(DormRoomBackground,eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        game.batch.draw(sprite, SPRITE_LOCATION_X, SPRITE_LOCATION_Y, SPRITE_WIDTH, SPRITE_HEIGHT);

        //SLEEP
        if(SPRITE_LOCATION_X>-300 - SPRITE_WIDTH && SPRITE_LOCATION_X <-100){
            game.batch.draw(SpaceButton, -200, SPRITE_HEIGHT, SPACEBUTTON_WIDTH,SPACEBUTTON_HEIGHT);
            game.batch.draw(SleepWord, -200, SPRITE_HEIGHT + SPACEBUTTON_HEIGHT, SLEEPWORD_WIDTH,SLEEPWORD_HEIGHT);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                game.i += 1;
                if(game.i <=6) {
                    this.dispose();
                    game.setScreen(new BlankScreen(game));
                }
                else{
                    this.dispose();
                    game.setScreen(new GameOverScreen(game));
                }
            }
        }
        //STUDY
        if(SPRITE_LOCATION_X>200 && SPRITE_LOCATION_X <300){
            game.batch.draw(SpaceButton, 250, SPRITE_HEIGHT, SPACEBUTTON_WIDTH,SPACEBUTTON_HEIGHT);
            game.batch.draw(StudyWord, 250, SPRITE_HEIGHT + SPACEBUTTON_HEIGHT, STUDYWORD_WIDTH,STUDYWORD_HEIGHT);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                game.study += 4;
                game.energy -= 0.25;
                game.worldTimer-=32;
            }
        }
        if(game.energy <= 0){
            this.dispose();
            game.setScreen(new GameOverScreen(game));
        }
        game.HUD();

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
