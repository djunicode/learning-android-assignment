package com.example.musicfinder;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ArtistSearchAPIInterface {
    //http://ws.audioscrobbler.com/ base url

    //method=artist.search&artist=selena&api_key=ca2ce4bd011365f7253c207a6bb93f80&format=json
    @GET("/2.0/")
    Call<ArtistSearchPOJO> getArtistSearchResponse(
            @Query("method") String method,
            @Query("artist") String k,
            @Query("api_key") String key,
            @Query("format") String format
    );

//<ArtistSearchPOJO>
}
