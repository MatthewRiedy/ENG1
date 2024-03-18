package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;

public class BlankScreen implements Screen {

    //Position vectors of day on  the blank screen
    private static final int Day_Y = 0;
    private static final int Day_X = -100;
    
    eng1Game game;
    
    //Textures
    Texture BlankScreen;
    Texture[] days;

    public BlankScreen(eng1Game game){ 
        this.game = game;
        //Texture instances
        BlankScreen = new Texture("WhiteBackground.jpg");
        days = new Texture[] {new Texture("Day1.png"),new Texture("Day2.png"), new Texture("Day3.png"), new Texture("Day4.png"),
                new Texture("Day5.png"), new Texture("Day6.png"), new Texture("Day7.png")};//Array for the days Textures
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();

        //Draws the blank screen to fill the whole screen
        game.batch.draw(BlankScreen,eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
        //Draws the current day at the centre of the screen.
        game.batch.draw(days[game.i], Day_X, Day_Y);
        
        if(Gdx.input.isTouched()){
            //Sets all the variable back to normal for energy and time at the start of each day and switches screen back to the dorm room when screen is mouse clicked.
            game.energy = 1;
            game.worldTimer = 128;
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
