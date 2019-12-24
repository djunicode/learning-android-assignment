package com.example.musicfinder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Application {
@SerializedName("results")
    AlbumSearchResults ResultsObject;


    // Getter Methods

    public AlbumSearchResults getResults() {
        return ResultsObject;
    }

    // Setter Methods

    public void setResults( AlbumSearchResults resultsObject ) {
        this.ResultsObject = resultsObject;
    }
}
