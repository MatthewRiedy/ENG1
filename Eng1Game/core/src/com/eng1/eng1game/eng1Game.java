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

	//Height and Width of the screen
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 900;

	//Bottom origin for screens filling entire page
	public static final int ORIGIN_X = -500;
	public static final int ORIGIN_Y = -450;

	//Positioning of the day variable
	public static final int DAY_Y = 350;
	public static final int DAY_X = -100;

	//Time related values
	private float timeCount;
	public int worldTimer = 128;

	//Game related variables for scoring
	public float energy = 1;
	public int exercise =0;
	public int study = 0;
	public int eating = 0;

	public int i = 0;
    	public int n = 0;

	//Boolean for Music which can be adjusted in the settings screen
	public boolean Ticked = true;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	//Textures
    	Texture Blank;
	Texture TimeToSleep;
	
	Map outside;
	
	public static AssetManager manager;

	public void HUD(){

		update();

		Texture[] days = new Texture[] {new Texture("Day1.png"),new Texture("Day2.png"), new Texture("Day3.png"), new Texture("Day4.png"),
				new Texture("Day5.png"), new Texture("Day6.png"), new Texture("Day7.png")};//array for the day counter
		
        	Texture[] hours = new Texture[] {new Texture("16-hours-left.png"),new Texture("15-hours-left.png"), new Texture("14-hours-left.png"), new Texture("13-hours-left.png"),
                new Texture("12-hours-left.png"), new Texture("11-hours-left.png"), new Texture("10-hours-left.png"), new Texture("9-hours-left.png"),
                new Texture("8-hours-left.png"),new Texture("7-hours-left.png"),new Texture("6-hours-left.png"),new Texture("5-hours-left.png"),new Texture("4-hours-left.png"),
                new Texture("3-hours-left.png"),new Texture("2-hours-left.png"), new Texture("1-hour-left.png")};//array for the hour counter
		
        	Blank = new Texture("blank.png"); //Health Bar Texture
		
		TimeToSleep = new Texture("TimeToSleep.png"); 

		batch.draw(Blank, -500, -450, Gdx.graphics.getWidth() * energy, 10); // draws health bar

		batch.draw(days[i], DAY_X, DAY_Y);//draws the day counter
        if(worldTimer >=120){
            n=0;
        }
        else if(worldTimer >=112){
            n=1;
        }
        else if(worldTimer >=104){
            n=2;
        }
        else if(worldTimer >=96){
            n=3;
        }
        else if(worldTimer >=88){
            n=4;
        }
        else if(worldTimer >=80){
            n=5;
        }
        else if(worldTimer >=72){
            n=6;
        }
        else if(worldTimer >=64){
            n=7;
        }
        else if(worldTimer >=56){
            n=8;
        }
        else if(worldTimer >=48){
            n=9;
        }
        else if(worldTimer >=40){
            n=10;
        }
        else if(worldTimer >=32){
            n=11;
        }
        else if(worldTimer >=24){
            n=12;
        }
        else if(worldTimer >=16){
            n=13;
        }
        else if(worldTimer >=8){
            n=14;
        }
        else if(worldTimer >0){
            n=15;
        }
        else if(worldTimer<0){
            batch.draw(TimeToSleep, DAY_X-200, DAY_Y-100); //If worldTimer variable is less than 0 draws time to sleep image.
        }
        if(worldTimer >0) {
            batch.draw(hours[n], DAY_X - 200, DAY_Y - 100); //Only draws hours timer if worldTimer is greater than 0.
        }

	}

	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		this.setScreen(new StarterMenuScreen(this)); //Ensure the first screen is the starter menu screen
		if(Ticked) { //Only plays music if 'Music' is starter menu is ticked.
			manager = new AssetManager();
			manager.load("audios/TimTaj - Aspire Background.mp3", Music.class);
			manager.finishLoading();
		}
			outside = new Map(); //Loads map

		}

	@Override
	public void render () {super.render();}
	
	public void update(){
		timeCount += Gdx.graphics.getDeltaTime(); //Increments timeCount until deltaTime is equal to 1 then sets value back to 0.
		if(timeCount >= 1){
			worldTimer--; //If value is greater than 1 decrements worldTimer, this acts as the seconds counter for the game.
			if(worldTimer <0) { //Player starts losing energy once worldTimer is less than 0 forcing the player to sleep starting the next day.
				energy -= 0.1;
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
}
