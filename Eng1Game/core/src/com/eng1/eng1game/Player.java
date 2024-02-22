package com.eng1.eng1game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Player extends Sprite {
    private Animation playerWalk;
    private float stateTimer;
    private boolean walkingRight;
    public Player(TextureRegion textureRegionWalking, Sound stepSound){
        stateTimer = 0;
        walkingRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 1; i < 4;i++){
            frames.add(new TextureRegion(getTexture(), i * 59, 0, 59, 100));
            playerWalk = new Animation(0.1f, frames);
            frames.clear();

            
        }
    }
}
