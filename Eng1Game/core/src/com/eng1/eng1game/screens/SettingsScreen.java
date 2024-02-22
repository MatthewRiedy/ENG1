package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;

public class SettingsScreen implements Screen {

    eng1Game game;

    Texture SettingsBackground;
    Texture SettingsWord;
    Texture ExitWordButton;

    public SettingsScreen (eng1Game game){
        this.game = game;
        ExitWordButton = new Texture("ExitButton2.png");
        SettingsBackground = new Texture("Whiteboard.jpg");
        SettingsWord = new Texture("PixelatedSettingsWord.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();
        game.batch.draw(SettingsBackground, -500, -450, eng1Game.WIDTH, eng1Game.HEIGHT);
        game.batch.draw(SettingsWord, -100, 250, 200, 100);
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
