package com.mayendrams.cekrek;

//NIM               : 10117613
//NAMA              : Mayendra Muhammad Shiddiq
//Tanggal Dibuat    : 30-04-2019

public class ScreenItem {

    String Title,Description;
    int screenImg;

    public ScreenItem(String title, String description, int screenImg) {
        Title = title;
        Description = description;
        this.screenImg = screenImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        this.screenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return screenImg;
    }
}
