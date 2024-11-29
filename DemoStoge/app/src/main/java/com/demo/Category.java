package com.demo;

import java.io.Serializable;

public class Category implements Serializable {

    byte[] icon;
    int ID;
    String Author;
    String Title;

    public Category(int id, byte[] icon, String title, String author) {
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Category(byte[] icon, int ID, String author, String title) {
        this.icon = icon;
        this.ID = ID;
        Author = author;
        Title = title;
    }




}


