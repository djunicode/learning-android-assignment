package com.example.musicfinder;

import com.google.gson.annotations.SerializedName;

public class Image
{@SerializedName("#text")
    private String url ;
    private String size;
    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }
}