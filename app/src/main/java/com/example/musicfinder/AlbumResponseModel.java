package com.example.musicfinder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumResponseModel {
@SerializedName("artist")
    private String artist;
@SerializedName("url")
    private String  url;

    public List<AlbumSearchImage> getImage() {
        return image;
    }

    private String name;
List<AlbumSearchImage> image;
    public AlbumResponseModel(String artist, String url, String name) {
        this.artist = artist;
        this.url = url;
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
