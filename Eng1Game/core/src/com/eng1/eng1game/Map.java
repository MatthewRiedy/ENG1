package com.eng1.eng1game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Map implements Screen {
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    OrthographicCamera camera;
    eng1Game game;
    Player player;
    SpriteBatch batch;
    MapObjects interactables;
    Texture spaceButton;
    int[] playerSpawn;
    public Map(eng1Game game, String location, int[] playerSpawn){
        this.game = game;
        this.playerSpawn = playerSpawn;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 64, 45);
        tiledMap = new TmxMapLoader().load(location);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, (float) 1 /16);
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(player);
        interactables = new MapObjects();
        spaceButton = new Texture("SpaceButton.png");
    }

    /**
     *
     */
    @Override
    public void show() {
        player = new Player((TiledMapTileLayer) tiledMap.getLayers().get(2), game, this);
        player.setPosition(playerSpawn[0] * player.getCollisionLayer().getTileWidth(), (45-playerSpawn[1]) * player.getCollisionLayer().getTileHeight());
        Gdx.input.setInputProcessor(player);
        batch.begin();
        player.draw();
        batch.end();
    }

    /**
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        String[] interact = interacting();
        player.update(delta);
        player.draw();
        game.HUD();
        batch.begin();
        if (interact != null){
            batch.draw(spaceButton, player.getX(),player.getY()+20);

        }
        batch.end();
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
    public String[] interacting(){
        //gets location of player
        float playerx = player.getX();
        float playery = player.getY();
        //gets size of player
        float playerWidth = player.getWidth();
        float playerHeight = player.getHeight();
        for(MapObject object: tiledMap.getLayers().get("Interactables").getObjects()){
            //gets the location of the object
            float objectx = (float)object.getProperties().get("x");
            float objecty = (float)object.getProperties().get("y");
            //gets the size of the object
            float objectWidth = (float)object.getProperties().get("width");
            float objectHeight = (float)object.getProperties().get("height");
            if (((objectx < playerx && playerx < objectx + objectWidth) && (objecty < playery && playery < objecty+objectHeight) )){
                return new String[]{object.getName(), String.valueOf(object.getProperties().get("spawn"))};
            }

        }
        return null;
    }
}
