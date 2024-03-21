package com.eng1.eng1game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.eng1.eng1game.screens.GameOverScreen;
import com.eng1.eng1game.screens.StarterMenuScreen;

public class eng1Game extends Game {

	//Writes Study Score to screen
	private String StudyScoreDisplay;
	BitmapFont BitmapFontStudy;
	//Writes Exercise Score to screen
	private String ExerciseScoreDisplay;
	BitmapFont BitmapFontExercise;
	//Writes Eating Score to screen
	private String EatingScoreDisplay;
	BitmapFont BitmapFontEating;

	private String TimeLeftDisplay;

	BitmapFont BitMapFontTime;

	private String DayDisplay;

	BitmapFont BitMapFontDay;

	private String EnergyLeft;

	BitmapFont BitMapFontEnergy;

	Music music;

	//Height and Width of the screen
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 720;

	//Bottom origin for screens filling entire page
	public static final int ORIGIN_X = -512;
	public static final int ORIGIN_Y = -360;

	//Game related variables for scoring
	public int energy = 10;
	public int enjoy =0;
	public int study = 0;
	public int eating = 0;
	//time related variables
	public int day = 1;
	public int time = 0;
	// rendering related variables
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public static AssetManager manager;

	//Textures
	Texture Blank;




	public void HUD(){
		Blank = new Texture("blank.png"); //Health Bar Texture

		//TimeToSleep = new Texture("TimeToSleep.png"); //loading texture to warn player about the time
		batch.begin();
		if (day > 7) {//checks if day is within timeframe
			setScreen(new GameOverScreen(this));//ends the game
		}
		batch.end();

	}

	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		this.setScreen(new StarterMenuScreen(this)); //Ensure the first screen is the starter menu screen
		//plays music
		manager = new AssetManager();
		manager.load("audios/TimTaj - Aspire Background.mp3", Music.class);
		manager.finishLoading();
		BitmapFontEating = new BitmapFont();
		BitmapFontExercise = new BitmapFont();
		BitmapFontStudy = new BitmapFont();
		BitMapFontDay = new BitmapFont();
		BitMapFontTime = new BitmapFont();
		BitMapFontEnergy = new BitmapFont();
	}
	public void update(){// function to update the score displays
		StudyScoreDisplay = "Study: " + study;
		ExerciseScoreDisplay = "Exercise: " + enjoy;
		EatingScoreDisplay = "Eating: " + eating;
		TimeLeftDisplay = "Time Left: " + (16 - time);
		DayDisplay = "Day: " + day;
		EnergyLeft = "Energy: " + energy;
	}
	@Override
	public void render () {
		super.render();
		update();
		batch.begin();
		//Plays Music
		music = eng1Game.manager.get("audios/TimTaj - Aspire Background.mp3", Music.class);
		music.setLooping(true);
		music.play();
		//Displays On screen score screen for Study, Exercise and Eating
		BitmapFontStudy.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		BitmapFontStudy.draw(batch, StudyScoreDisplay, 400, 100);
		BitmapFontExercise.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		BitmapFontExercise.draw(batch, ExerciseScoreDisplay, 400, 50);
		BitmapFontEating.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		BitmapFontEating.draw(batch, EatingScoreDisplay, 400, 0);
		BitMapFontTime.setColor(1.0f,1.0f,1.0f,1.0f);
		BitMapFontTime.draw(batch, TimeLeftDisplay, 400, 150);
		BitMapFontDay.setColor(1.0f,1.0f,1.0f,1.0f);
		BitMapFontDay.draw(batch, DayDisplay, 400, 200);
		BitMapFontEnergy.setColor(1.0f,1.0f,1.0f,1.0f);
		BitMapFontEnergy.draw(batch, EnergyLeft, 400, 250);

		batch.end();
	}

	@Override
	public void dispose () {

	}
	//functions to perform actions
	public void eat(){
		eating += 1;
		time += 2;
		energy -= 1;
	}
	public void enjoy() {
		enjoy += 1;
		time += 2;
		energy -= 1;

	}
	public void study() {
		study += 1;
		time += 3;
		energy -= 4;
	}
	public void sleep(){
		day +=1;
		time = 0;
		energy =10;
	}
}