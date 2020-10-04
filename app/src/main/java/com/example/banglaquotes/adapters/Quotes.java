package com.example.banglaquotes.adapters;

import java.io.Serializable;

public class Quotes implements Serializable {
    private int images;
    private String title;
    private String details;

    public Quotes() {
    }

    public Quotes(int images, String title, String details) {
        this.images = images;
        this.title = title;
        this.details = details;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}
