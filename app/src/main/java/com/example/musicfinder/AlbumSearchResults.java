package com.example.musicfinder;

import com.google.gson.annotations.SerializedName;

public class AlbumSearchResults {
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
