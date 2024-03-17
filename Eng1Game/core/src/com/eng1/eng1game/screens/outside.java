package com.eng1.eng1game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.eng1.eng1game.Map;
import com.eng1.eng1game.eng1Game;

public class outside implements Screen {
    Map gameMap;
    OrthographicCamera camera;
    eng1Game game;
    public outside (eng1Game game){

        this.game = game;

        gameMap = new Map();

        camera = new OrthographicCamera();

        camera.setToOrtho(false, 1024, 720);

        camera.update();

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameMap.render(camera);
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
