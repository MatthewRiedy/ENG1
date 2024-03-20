package com.eng1.eng1game;

public enum Spawn {
    START(new int[]{8, 11}), DORMENTER(new int[]{49, 37}), DORMEXIT(new int[]{15, 13}), GYMENTER(new int[]{41, 28}), GYMEXIT(new int[]{55, 29}),
    CANTEENENTER(new int[]{24, 39}), CANTEENEXIT(new int[]{35, 19}), STUDYENTER(new int[]{52, 35}), STUDYEXIT(new int[]{20, 31});
    private final int[] pos;
    private Spawn(int[] pos){
        this.pos = pos;
    }
    public int[] getName(){
        return pos;
    }
}
