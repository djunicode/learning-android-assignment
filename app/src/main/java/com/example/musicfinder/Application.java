package com.example.musicfinder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Application {
@SerializedName("results")
    Results ResultsObject;


    // Getter Methods

    public Results getResults() {
        return ResultsObject;
    }

    // Setter Methods

    public void setResults( Results resultsObject ) {
        this.ResultsObject = resultsObject;
    }
}
