package com.example.musicfinder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TagTopArtistInterface
    {
        //http://ws.audioscrobbler.com/ base url
//        method=tag.gettopartists&tag=pop&api_key=a7fe20ad29f194f5833e08e8e10ad66f&format=json

        @GET("/2.0/")
        Call<Postlist> getTagTopArtistSearchResponse (
            @Query("method") String method,
            @Query("tag") String k,
            @Query("api_key") String key,
            @Query("format") String format
    );

//<ArtistSearchPOJO>
    }

