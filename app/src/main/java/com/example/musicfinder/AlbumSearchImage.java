package com.example.musicfinder;

import com.google.gson.annotations.SerializedName;

public class AlbumSearchImage
{
    @SerializedName("#text")
        private String url ;
        private String size;

    public AlbumSearchImage(String url, String size) {
        this.url = url;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }
}
