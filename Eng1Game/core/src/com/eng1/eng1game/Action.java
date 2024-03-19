package com.eng1.eng1game;

public enum Action {
    EAT("eat"), SLEEP("sleep"), STUDY("study"), ENJOY("enjoy");
    private final String name;
    private Action(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

}
