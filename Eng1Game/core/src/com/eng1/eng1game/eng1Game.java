package com.eng1.eng1game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.eng1.eng1game.screens.StarterMenuScreen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class eng1Game extends Game {

	private Skin skin;
	private Player player;

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 900;

	public static final int ORIGIN_X = -500;
	public static final int ORIGIN_Y = -450;

	public OrthographicCamera camera;
	public SpriteBatch batch;

	private Assets assets;
	
	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		this.setScreen(new StarterMenuScreen(this));

		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();

		skin = new Skin();
		skin.addRegions(assets.manager.get("player.pack", TextureAtlas.class));

		player = new Player(skin.getRegion("walking"), assets.manager.get("audios/stepSound.wav", Sound.class));
		}

	@Override
	public void render () {
        super.render();
		player.update(batch);
	}
	
	@Override
	public void dispose () {

	}

}
