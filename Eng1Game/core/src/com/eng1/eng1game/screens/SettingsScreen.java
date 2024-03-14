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
    Texture MusicWord;
    Texture BlankBox;
    Texture TickBox;

    public SettingsScreen (eng1Game game){
        this.game = game;
        ExitWordButton = new Texture("ExitButton2.png");
        SettingsBackground = new Texture("Whiteboard.jpg");
        SettingsWord = new Texture("PixelatedSettingsWord.png");
        MusicWord = new Texture("MusicWord.png");
        BlankBox = new Texture("BlankTickBox.png");
        TickBox = new Texture("TickedCheckBox.png");

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
        game.batch.draw(MusicWord, -160, 120, 75, 50);
        game.batch.draw(TickBox, -250, 100, 75, 75);
        if(Gdx.input.isTouched()){
            game.batch.draw(BlankBox, -250, 100, 75, 75);
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
