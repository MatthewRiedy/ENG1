package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;

public class BlankScreen implements Screen {

    public static final int DAY_Y = 350;
    public static final int DAY_X = -100;

    public static final int SPACEBUTTON_WIDTH = 100;
    public static final int SPACEBUTTON_HEIGHT = 50;
    eng1Game game;
    //private Music music;
    Texture BlankScreen;
    Texture[] days;

    public BlankScreen(eng1Game game){
        this.game = game;
        BlankScreen = new Texture("WhiteBackground.jpg");
        days = new Texture[] {new Texture("Day1.png"),new Texture("Day2.png"), new Texture("Day3.png"), new Texture("Day4.png"),
                new Texture("Day5.png"), new Texture("Day6.png"), new Texture("Day7.png")};

        //if(game.health <= 0) {
        // music = eng1Game.manager.get("audios/you-suck.mp3", Music.class);
        //music.play();
        //}
        //else{
        //music = eng1Game.manager.get("audios/trumpit-sound.mp3", Music.class);
        //music.play();
        //}
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();
        game.batch.draw(BlankScreen,eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
        game.batch.draw(days[game.i], -100, 0);
        if(Gdx.input.isTouched()){
            game.energy = 1;
            game.worldTimer = 120;
            this.dispose();
            game.setScreen(new DormRoomScreen(game));
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
