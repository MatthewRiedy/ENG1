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
import com.badlogic.gdx.maps.tiled.TiledMap;

public class eng1Game extends Game {

	public static final int WIDTH = 1024;
	public static final int HEIGHT = 720;
	public int i = 0;

	public static final int ORIGIN_X = -500;
	public static final int ORIGIN_Y = -450;

	public static final int DAY_Y = 350;
	public static final int DAY_X = -100;

	private float timeCount;
	public int worldTimer = 128;

	public float energy = 1;

	public int exercise =0;
	public int study = 0;

	public int eating = 0;



	public OrthographicCamera camera;
	public SpriteBatch batch;
    Texture Blank;

	Texture TimeToSleep;
	Map outside;
	public static AssetManager manager;

	public void HUD(){

		update();

		Texture[] days = new Texture[] {new Texture("Day1.png"),new Texture("Day2.png"), new Texture("Day3.png"), new Texture("Day4.png"),
				new Texture("Day5.png"), new Texture("Day6.png"), new Texture("Day7.png")};//array for the day counter
        Blank = new Texture("blank.png");
		TimeToSleep = new Texture("TimeToSleep.png");

		batch.draw(Blank, -500, -450, Gdx.graphics.getWidth() * energy, 10); // draws health bar

		batch.draw(days[i], DAY_X, DAY_Y);//draws the day counter



	}

	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		this.setScreen(new StarterMenuScreen(this));
		manager = new AssetManager();
		manager.load("audios/TimTaj - Aspire Background.mp3", Music.class);
		manager.finishLoading();
		}

	@Override
	public void render () {super.render();}
	
	public void update(){
		timeCount += Gdx.graphics.getDeltaTime();
		if(timeCount >= 1){
			worldTimer--;
			if(worldTimer <=10) {
				batch.draw(TimeToSleep, 50, 300);
				energy -= 0.1;
				if(energy <=0){
					setScreen(new GameOverScreen(this));
				}
			}
			timeCount = 0;
		}
	}
	
	@Override
	public void dispose () {

	}
}
