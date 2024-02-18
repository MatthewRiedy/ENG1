package com.eng1.eng1game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    private static final int FRAME_COLS = 6;
    private static final int FRAME_ROWS = 6;

    private static final int WALKING = 0;
    private int currentAnimation;

    private Animation<TextureRegion> walkingAnimation;

    private TextureRegion[] walkingFrames;

    private TextureRegion currentFrame;
    private Animation[] animations;

    private Sound stepSound;
    private int stepIndex = 0;
    private int stateTime = 0;



    public Player(TextureRegion textureRegionWalking, Sound stepSound){
        this.stepSound = stepSound;

        // Walking Animation
        TextureRegion[][] tmp = textureRegionWalking.split(textureRegionWalking.getRegionWidth() / FRAME_COLS,
                textureRegionWalking.getRegionHeight() / FRAME_ROWS);
        walkingFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkingFrames[index++] = tmp[i][j];
            }
        }
        walkingAnimation = new Animation(0.05f, walkingFrames);
        walkingAnimation.setPlayMode(Animation.PlayMode.LOOP);

        // Array of Animations
        animations = new Animation[2];
        animations[0] = walkingAnimation;

        // Initial currentAnimation
        setCurrentAnimation(WALKING);
    }
    public void setCurrentAnimation(int currentAnimation){
        this.currentAnimation = currentAnimation;
        stateTime = 0;
        stepIndex = 0;
    }
    public int getCurrentAnimation(){
        return currentAnimation;
    }
    public void update(SpriteBatch batch){
        stateTime += Gdx.graphics.getDeltaTime();

        if(animations[currentAnimation].getKeyFrameIndex(stateTime) != stepIndex){
            if(animations[currentAnimation].getKeyFrameIndex(stateTime) == 0
                    || animations[currentAnimation].getKeyFrameIndex(stateTime) == 12) {
                stepIndex = animations[currentAnimation].getKeyFrameIndex(stateTime);
                stepSound.play();
            }
        }

        currentFrame = (TextureRegion) animations[currentAnimation].getKeyFrame(stateTime, true);

        batch.begin();
        batch.draw(currentFrame, Gdx.graphics.getWidth() / 2 - currentFrame.getRegionWidth() /2,
                Gdx.graphics.getHeight() / 2 - currentFrame.getRegionHeight() /2);
        batch.end();
    }
}
