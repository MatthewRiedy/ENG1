package com.eng1.eng1game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.eng1.eng1game.eng1Game;


public class GameOverScreen implements Screen {

    eng1Game game;
    Texture ScoreGameOver;
    //Image of Grades
    Texture AGrade;
    Texture BGrade;
    Texture CGrade;
    Texture FGrade;
    //Text for grades
    Texture AGradeText;
    Texture BGradeText;
    Texture FGradeText;


    public GameOverScreen(eng1Game game){
        this.game = game;
        ScoreGameOver = new Texture("ScoreGameOver.jpg");
        AGrade = new Texture("grade-a.png");
        BGrade= new Texture("grade-b.png");
        CGrade = new Texture("grade-c.png");
        FGrade = new Texture("grade-f.png");
        AGradeText = new Texture("Grade A Text.png");
        BGradeText = new Texture("Grade B Text.png");
        FGradeText = new Texture("Grade F Text.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();


        if (game.study == 10 && game.enjoy >= 11 && game.eating >= 11) {
            game.batch.draw(ScoreGameOver, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
            game.batch.draw(AGrade, 0, 0, 200,200);
            game.batch.draw(AGradeText, -200, -100,450,50);
        } else if (game.study >=7 && game.enjoy >= 13 && game.eating >= 13) {
            game.batch.draw(ScoreGameOver, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
            game.batch.draw(BGrade, 0, 0,200,200);
            game.batch.draw(BGradeText, -200, -100,450,50);
        }
        else if (game.study >=5) {
            game.batch.draw(ScoreGameOver, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
            game.batch.draw(CGrade, 0, 0, 200,200);
            game.batch.draw(FGradeText, -200, -100,450,50);
        } else {
            game.batch.draw(ScoreGameOver, eng1Game.ORIGIN_X, eng1Game.ORIGIN_Y, eng1Game.WIDTH, eng1Game.HEIGHT);
            game.batch.draw(FGrade, 0, 0,200,200);
            game.batch.draw(FGradeText, -200, -100,450,50);
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
