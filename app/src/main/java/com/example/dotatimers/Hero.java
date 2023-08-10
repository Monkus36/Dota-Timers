package com.example.dotatimers;

public class Hero {

    private String name;
    private int timer;
    private int counter;
    private int imageId;

    public Hero(String name, int timer, int imageId) {
        this.name = name;
        this.timer = timer;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getTimer() {
        return timer;
    }

    public int getCounter() {
        return counter;
    }

    public int getImageId() {
        return imageId;
    }

    public void incrementCounter() {
        counter++;
    }
}
