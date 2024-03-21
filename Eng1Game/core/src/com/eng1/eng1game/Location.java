package com.eng1.eng1game;

public enum Location {
    DORM("Dorm"), OUTSIDE("outside"), GYM("Gym"), CANTEEN("Canteen"), STUDY("StudyBuilding");
    private final String name;
    private Location(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
