package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.Map;
import com.eng1.eng1game.eng1Game;

public class StarterMenuScreen implements Screen {

    //Buttons widths and heights
    private static final int PLAY_BUTTON_WIDTH = 200;
    private static final int PLAY_BUTTON_HEIGHT = 100;

    private static final int MENU_BUTTONS_X = -100;
    private static final int PLAY_BUTTON_Y = 0;

    private static final int EXIT_BUTTON_WIDTH = 200;
    private static final int EXIT_BUTTON_HEIGHT = 100;

    private static final int EXIT_BUTTON_Y = -100;

    eng1Game game;
    Texture PlayButton;
    Texture ExitWordButton;

    Texture MenuBackground;


    public StarterMenuScreen(eng1Game game){
        this.game = game;
        PlayButton = new Texture("PlayButton2.png");
        ExitWordButton = new Texture("ExitButton2.png");
        MenuBackground = new Texture("StarterMenuBackground.png");

    }

    @Override
    public void show () {

    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();
        game.batch.draw(MenuBackground, game.ORIGIN_X, game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);

        int x = 400;
        if(Gdx.input.getX() < x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > x && Gdx.input.getY() < 250 + PLAY_BUTTON_HEIGHT && Gdx.input.getY() > 250) {
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new Map(game, "Dorm.tmx", new int[]{38, 12}));
            }
        }
        if(Gdx.input.getX() < x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > x && Gdx.input.getY() < 350 + EXIT_BUTTON_HEIGHT && Gdx.input.getY() > 350) {
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }

        game.batch.draw(PlayButton, MENU_BUTTONS_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        game.batch.draw(ExitWordButton, MENU_BUTTONS_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        game.batch.end();
    }

    @Override
    public void resize (int width, int height) {

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
