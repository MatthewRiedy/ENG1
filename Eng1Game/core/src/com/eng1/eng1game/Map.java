package com.eng1.eng1game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Map {
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    public Map(){ //Creates 2 instances of map load and tile render
        tiledMap = new TmxMapLoader().load("outside.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }
    public void render (OrthographicCamera camera){//Sets camera and renders tiles
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }
    public void dispose(){
        tiledMap.dispose();
    }


}
