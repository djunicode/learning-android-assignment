package com.example.musicfinder;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface LastFMService {
    String Base_URL = "http://ws.audioscrobbler.com/2.0/";

    @GET("?api_key=93c216cb2becec95e3073a6a2b58241e&method=album.search&format=json")
    Call<Application> getAlbum(@Query("album") String album);
}