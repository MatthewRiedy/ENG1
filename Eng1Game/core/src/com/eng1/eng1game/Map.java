package com.eng1.eng1game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Map implements Screen {
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    OrthographicCamera camera;
    eng1Game game;
    public Map(eng1Game game, String location){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 64, 45);
        tiledMap = new TmxMapLoader().load(location);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, (float) 1 /16);
    }

    /**
     *
     */
    @Override
    public void show() {

    }

    /**
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    /**
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     *
     */
    @Override
    public void pause() {

    }

    /**
     *
     */
    @Override
    public void resume() {

    }

    /**
     *
     */
    @Override
    public void hide() {

    }

    public void dispose(){
        tiledMap.dispose();
    }


}
