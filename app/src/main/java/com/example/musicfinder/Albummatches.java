package com.example.musicfinder;

import com.example.musicfinder.AlbumResponseModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Albummatches {

    public ArrayList<AlbumResponseModel> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<AlbumResponseModel> album) {
        this.album = album;
    }
@SerializedName("album")
    ArrayList<AlbumResponseModel> album = new ArrayList<AlbumResponseModel>();




}
