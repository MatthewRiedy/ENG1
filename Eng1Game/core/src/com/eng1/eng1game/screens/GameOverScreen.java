package com.eng1.eng1game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;


public class GameOverScreen implements Screen {

    eng1Game game;
    private Music music;
    Texture DeathGameOver;
    Texture ScoreGameOver;

    public GameOverScreen(eng1Game game){
        this.game = game;
        DeathGameOver = new Texture("DeathGameover.jpg");
        ScoreGameOver = new Texture("ScoreGameover.jpg");


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

        if(game.energy <= 0) {
            game.batch.draw(DeathGameOver, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
        }
        else{
            game.batch.draw(ScoreGameOver, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

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
