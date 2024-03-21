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

	Music music;

	//Height and Width of the screen
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 720;

	//Bottom origin for screens filling entire page
	public static final int ORIGIN_X = -512;
	public static final int ORIGIN_Y = -360;

	//Positioning of the day variable
	public static final int DAY_Y = 260;
	public static final int DAY_X = -100;

	//Time related values
	private float timeCount;
	public int worldTimer = 128;

	//Game related variables for scoring
	public float energy = 1;
	public int enjoy =0;
	public int study = 0;
	public int eating = 0;
	//time related variables
	public int day = 0;
	public int time = 0;
	// rendering related variables
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public static AssetManager manager;

	//Textures
	Texture Blank;
	Texture TimeToSleep;
	


	public void HUD(){

		update();

		Texture[] days = new Texture[] {new Texture("Day1.png"),new Texture("Day2.png"), new Texture("Day3.png"), new Texture("Day4.png"),
				new Texture("Day5.png"), new Texture("Day6.png"), new Texture("Day7.png")};//array for the day counter
		
        	Texture[] hours = new Texture[] {new Texture("16-hours-left.png"),new Texture("15-hours-left.png"), new Texture("14-hours-left.png"), new Texture("13-hours-left.png"),
                new Texture("12-hours-left.png"), new Texture("11-hours-left.png"), new Texture("10-hours-left.png"), new Texture("9-hours-left.png"),
                new Texture("8-hours-left.png"),new Texture("7-hours-left.png"),new Texture("6-hours-left.png"),new Texture("5-hours-left.png"),new Texture("4-hours-left.png"),
                new Texture("3-hours-left.png"),new Texture("2-hours-left.png"), new Texture("1-hour-left.png")};//array for the hour counter
		
        	Blank = new Texture("blank.png"); //Health Bar Texture
		
		TimeToSleep = new Texture("TimeToSleep.png"); //loading texture to warn player about the time
		batch.begin();
		batch.draw(Blank, ORIGIN_X, ORIGIN_Y, Gdx.graphics.getWidth() * energy, 10); // draws health bar
		if (day < 7) {//checks if day is within timeframe
			batch.draw(days[day], DAY_X, DAY_Y);//draws the day counter
		}
		else{
			setScreen(new GameOverScreen(this));//ends the game
		}
		time = 16 - worldTimer/8; //Time Counter for hours

        if(time >= 16){
            batch.draw(TimeToSleep, DAY_X-200, DAY_Y-100); //If worldTimer variable is less than 0 draws time to sleep image.
        }
        else{
            batch.draw(hours[time], DAY_X - 200, DAY_Y - 100); //Only draws hours timer if worldTimer is greater than 0.
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
	}
	public void updateScore(){// function to update the score displays
		StudyScoreDisplay = "Study: " + study;
		ExerciseScoreDisplay = "Exercise: " + enjoy;
		EatingScoreDisplay = "Eating: " + eating;

	}
	@Override
	public void render () {
		super.render();
		updateScore();
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
		batch.end();
			      }
	
	public void update(){
		timeCount += Gdx.graphics.getDeltaTime(); //Increments timeCount until deltaTime is equal to 1 then sets value back to 0.
		if(timeCount >= 1){
			worldTimer--; //If value is greater than 1 decrements worldTimer, this acts as the seconds counter for the game.
			if(worldTimer <0) { //Player starts losing energy once worldTimer is less than 0 forcing the player to sleep starting the next day.
				energy -= 0.1F;
				if(energy <=0){//If player dies (health goes below 0) switches screen to teh Game Over Screen.
					setScreen(new GameOverScreen(this));
				}
			}
			timeCount = 0;
		}
	}
	@Override
	public void dispose () {

	}
	//functions to perform actions
	public void eat(){
		eating += 1;
		worldTimer -= 16;
		energy -= 0.0125F;
	}
	public void enjoy(){
		enjoy += 1;
		worldTimer -= 16;
		energy -= 0.0125F;
	}
	public void study(){
		study += 1;
		worldTimer -= 16;
		energy -= 0.0125F;
	}
	public void sleep(){
		day +=1;
		worldTimer = 127;
		energy =1;
	}
}
