package com.eng1.eng1game;

import com.badlogic.gdx.assets.AssetManager;

public class Assets {

    public AssetManager manager;

    public void load(){
        if(manager == null){
            manager = new AssetManager();
        }
    }

}
