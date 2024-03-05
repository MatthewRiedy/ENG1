package com.eng1.eng1game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.eng1.eng1game.screens.DormRoomScreen;
import com.eng1.eng1game.screens.GameOverScreen;
import com.eng1.eng1game.screens.StarterMenuScreen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class eng1Game extends Game {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 900;

	public static final int ORIGIN_X = -500;
	public static final int ORIGIN_Y = -450;

	public static final int DAY_Y = 350;
	public static final int DAY_X = -100;

	private float timeCount;
	private int worldTimer = 840;

	public float health = 1;
	public int study = 0;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	Texture Day1;
	Texture Day2;
	Texture Day3;
	Texture Day4;
	Texture Day5;
	Texture Day6;
	Texture Day7;

    Texture Blank;

	public static AssetManager manager;

	public void HUD(){

		update();
		Day1 = new Texture("Day1.png");
		Day2 = new Texture("Day2.png");
		Day3 = new Texture("Day3.png");
		Day4 = new Texture("Day4.png");
		Day5 = new Texture("Day5.png");
		Day6 = new Texture("Day6.png");
		Day7 = new Texture("Day7.png");

        Blank = new Texture("blank.png");

        batch.draw(Blank, -500, -450, Gdx.graphics.getWidth() * health, 10);

		if(worldTimer<=840 && worldTimer >720){
			batch.draw(Day1, DAY_X,DAY_Y);
		}
		if(worldTimer<=720 && worldTimer >600){
			batch.draw(Day2, DAY_X,DAY_Y);
		}
		if(worldTimer<=600 && worldTimer >480){
			batch.draw(Day3, DAY_X,DAY_Y);
		}
		if(worldTimer<=480 && worldTimer >360){
			batch.draw(Day4, DAY_X,DAY_Y);
		}
		if(worldTimer<=360 && worldTimer >240){
			batch.draw(Day5, DAY_X,DAY_Y);
		}
		if(worldTimer<=240 && worldTimer >120){
			batch.draw(Day6, DAY_X,DAY_Y);
		}
		if(worldTimer<=120 && worldTimer >0){
			batch.draw(Day7, DAY_X,DAY_Y);
		}


	}

	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		this.setScreen(new StarterMenuScreen(this));
		manager = new AssetManager();
		manager.load("audios/thresholdGameMusic.mp3", Music.class);
		manager.finishLoading();
		}

	@Override
	public void render () {
        super.render();
	}
	
	public void update(){
		timeCount += Gdx.graphics.getDeltaTime();
		if(timeCount >= 1){
			worldTimer--;
            health-=0.01;
			timeCount = 0;
		}
	}
	
	@Override
	public void dispose () {

	}

}
