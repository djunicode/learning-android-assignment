package com.example.musicfinder;

import com.example.musicfinder.Albummatches;
import com.google.gson.annotations.SerializedName;

public class Results{
    @SerializedName("albummatches")
    Albummatches AlbummatchesObject;


    // Getter Methods

    public Albummatches getAlbummatches() {
        return AlbummatchesObject;
    }


    public void setAlbummatches( Albummatches albummatchesObject ) {
        this.AlbummatchesObject = albummatchesObject;
    }


}
