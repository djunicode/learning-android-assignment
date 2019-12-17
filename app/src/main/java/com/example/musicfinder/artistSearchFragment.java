package com.example.musicfinder;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
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
    RecyclerView artistSearchRecyclerView;
    String  passName[],passList[],passUrl[];//passImgUrl[];


    public artistSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View rootview=inflater.inflate(R.layout.fragment_artist_search, container, false);

        artistfragSearch=rootview.findViewById(R.id.artistfragSearch);
        artistName=rootview.findViewById(R.id.artistName);
        artistSearchRecyclerView=rootview.findViewById(R.id.artistSearchRecyclerView);

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
                Toast.makeText(getContext(),"Great choice!",Toast.LENGTH_LONG).show();
                artistSearchAPIInterface.getArtistSearchResponse(
                    "artist.search",name,"b0afd418d99a99ba1a11d0a4b8c2465c","json")
                    .enqueue(new Callback<ArtistSearchPOJO>()
                    {
                        @Override
                        public void onResponse(
                            Call<ArtistSearchPOJO> call,
                            Response<ArtistSearchPOJO> response)
                        {
                            //Toast.makeText(getContext(),"2",Toast.LENGTH_LONG).show();
                            if (response.isSuccessful())
                            {
                                String output=" ";
                               Results results =response.body().getResults();
                               Artistmatches artistmatches=results.getArtistmatches();
                               List<Artist> arList =artistmatches.getArtist();
                               int n=arList.size();
                                passName=new String[n];
                                passList=new String[n];
                                passUrl=new String[n];
                            for(int i = 0; i<arList.size(); i++)
                                {
                                    String arName=arList.get(i).getName();
                                    passName[i]=arName;
                                    String arURL=arList.get(i).getUrl();
                                    passUrl[i]=arURL;
                                    String arListeners=arList.get(i).getListeners();
                                    passList[i]=arListeners;
                                    output=i+" "+arName+" "+arURL+" "+arListeners+" ";
                                }
                              RecyclerView.Adapter adapter = new AdapterArtistSearch(passName,passList,passUrl);
                                artistSearchRecyclerView.
                                    setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(),R.anim.recycler_items_anim));
                                artistSearchRecyclerView.setAdapter(adapter);
                                artistSearchRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                    //Toast.makeText(getContext(),output,Toast.LENGTH_LONG).show();

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





