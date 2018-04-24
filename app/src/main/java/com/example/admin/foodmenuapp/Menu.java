package com.example.admin.foodmenuapp;

import java.io.Serializable;

public class Menu implements Serializable{

    private String nameOfDish;

    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    public int getNumOfDish() {
        return numOfDish;
    }

    public void setNumOfDish(int numOfDish) {
        this.numOfDish = numOfDish;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    private int numOfDish;
    private int thumbnail;

    public Menu() {
    }
    public Menu(String nameOfDish, int numOfDish, int thumbnail) {
        this.nameOfDish = nameOfDish;
        this.numOfDish = numOfDish;
        this.thumbnail = thumbnail;
    }
}
