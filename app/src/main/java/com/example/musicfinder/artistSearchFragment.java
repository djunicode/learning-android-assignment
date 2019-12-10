package com.example.musicfinder;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class artistSearchFragment extends Fragment {

    Button artistfragSearch;
    EditText artistName;
    String name;
    public artistSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View rootview=inflater.inflate(R.layout.fragment_artist_search, container, false);
        artistfragSearch=rootview.findViewById(R.id.artistfragSearch);
        artistName=rootview.findViewById(R.id.artistName);

        artistfragSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = artistName.getText().toString();
                Toast.makeText(getContext(), name,
                    Toast.LENGTH_SHORT).show();

                Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://ws.audioscrobbler.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

                ArtistSearchAPIInterface artistSearchAPIInterface =


                    retrofit.create(ArtistSearchAPIInterface.class);
                Toast.makeText(getContext(),"1",Toast.LENGTH_LONG).show();
                artistSearchAPIInterface.getArtistSearchResponse(
                    "artist.search",name,"b0afd418d99a99ba1a11d0a4b8c2465c","json")
                    .enqueue(new Callback<ArtistSearchPOJO>() {
                        @Override
                        public void onResponse(
                            Call<ArtistSearchPOJO> call,
                            Response<ArtistSearchPOJO> response)
                        {
                            Toast.makeText(getContext(),"2",Toast.LENGTH_LONG).show();
                            if (response.isSuccessful())
                            {
                                String output=" ";
                                //response.body().getResults();
                               Results results =response.body().getResults();
                                Toast.makeText(getContext(),"3",Toast.LENGTH_LONG).show();
                               Artistmatches artistmatches=results.getArtistmatches();
                                Toast.makeText(getContext(),"4",Toast.LENGTH_LONG).show();
                               List<Artist> arList =artistmatches.getArtist();
                                Toast.makeText(getContext(),"5",Toast.LENGTH_LONG).show();
                                for(int i = 0; i<arList.size(); i++)
                                {
                                    Toast.makeText(getContext(),"6",Toast.LENGTH_LONG).show();
                                    String arName=arList.get(i).getName();
                                    String arURL=arList.get(i).getUrl();
                                    String arListeners=arList.get(i).getListeners();
                                    Toast.makeText(getContext(),"7",Toast.LENGTH_LONG).show();
                                    output=i+" "+arName+" "+arURL+" "+arListeners+" ";
                                }

                                    Toast.makeText(getContext(),output,Toast.LENGTH_LONG).show();
                            } else
                                {
                                    Toast.makeText(getContext(),"Error loading data",Toast.LENGTH_LONG).show();

                                }

                        }

                        @Override
                        public void onFailure(
                            Call<ArtistSearchPOJO> call,
                            Throwable t) {
                           Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                           Log.i("SEE",t.fillInStackTrace().getLocalizedMessage());
                            Log.i("SEE",t.fillInStackTrace().getMessage());
                            //Log.i("SEE",t.fillInStackTrace().getCause());
                            Toast.makeText(getContext(),t.fillInStackTrace().getLocalizedMessage(),Toast.LENGTH_LONG).show();
                            Toast.makeText(getContext(),t.fillInStackTrace().toString(),Toast.LENGTH_LONG).show();
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                        }
                    });


            }//on click end
        });//on click listener end
        return rootview;

    }//on create view end
}//fragment end





/*
 ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        apiService.getTopRatedMovies().enqueue(new Callback<Movie>() {
            @Override            public void onResponse(Call<Movie> call, Response<Movie> response) {

                if(response.isSuccessful()) {
                //  Toast.makeText(MainActivity.this, "OUTPUT : "+response.body().getContacts(), Toast.LENGTH_LONG).show();
                Log.d("MainActivity", "posts loaded from API");
                 List<Contact> contactList =  response.body().getContacts();
                 for(int i = 0; i<contactList.size(); i++)
                    {
                        int statusCode  = response.code();
                          String id = contactList.get(i).getId();
                         String name = contactList.get(i).getName();
                          String email = contactList.get(i).getEmail();
                           String address = contactList.get(i).getAddress();
                             String gender = contactList.get(i).getGender();
                             Phone phone = contactList.get(i).getPhone();
                               String mobile = phone.getMobile();
                             String home = phone.getHome();
                                String office = phone.getOffice();
                     Toast.makeText(MainActivity.this, "OUTPUT : "+statusCode +", "+ id +", "+ name +", "+ email +", "+ address +", "+ gender +", "+ mobile +", "+ home +", "+ office, Toast.LENGTH_LONG).show();                    }
                }else {
                    int statusCode  = response.code();
                     // handle request errors depending on status code                }
            }

            @Override            public void onFailure(Call<Movie> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
 */