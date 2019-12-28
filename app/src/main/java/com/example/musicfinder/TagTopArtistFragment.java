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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class TagTopArtistFragment extends Fragment {

    Button tagTopArtistSearch;
    EditText tagGenre;
    String genreName;
    RecyclerView tagTopArtistRecyclerView;
    String  passName[],passRank[],passUrl[];


    public TagTopArtistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview= inflater.inflate(R.layout.fragment_tag_top_artist,container,false);

        tagGenre= rootview.findViewById(R.id.tagTopArtistName);
        tagTopArtistSearch=rootview.findViewById(R.id.tagTopArtistfragSearch);
        tagTopArtistRecyclerView=rootview.findViewById(R.id.tagTopArtistSearchRecyclerView);

        RecyclerView.Adapter adapter = new TagArtistAdapter(passName, passRank, passUrl, genreName);
        tagTopArtistRecyclerView.setAdapter(adapter);
        tagTopArtistRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tagTopArtistSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                genreName=tagGenre.getText().toString();
                String url="http://ws.audioscrobbler.com";


                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                TagTopArtistInterface tagTopArtistInterface=retrofit.create(TagTopArtistInterface.class);
                Toast.makeText(getContext(),"Great choice!",Toast.LENGTH_LONG).show();
                tagTopArtistInterface.getTagTopArtistSearchResponse("tag.gettopartists",genreName,"a7fe20ad29f194f5833e08e8e10ad66f","json")
                        .enqueue(new Callback<Postlist>() {
                            @Override
                            public void onResponse(Call<Postlist> call, Response<Postlist> response) {

                            if(response.isSuccessful()) {
                                Topartists topartists = response.body().getTopartists();
                                List<Artist> artistList = topartists.getArtist();
                                int n = artistList.size();
                                passName = new String[n];
                                passRank = new String[n];
                                passUrl = new String[n];

                                for (int i = 0; i < n; i++) {
                                    passName[i] = artistList.get(i).getName();
                                    passUrl[i] = artistList.get(i).getUrl();
                                    passRank[i] = artistList.get(i).getAttr().getRank();


                                }

                                RecyclerView.Adapter adapter = new TagArtistAdapter(passName, passRank, passUrl, genreName);
                                tagTopArtistRecyclerView.setAdapter(adapter);
                                tagTopArtistRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            }
                            else
                                {
                                Toast.makeText(getContext(), "Error loading data", Toast.LENGTH_LONG).show();
                            }

                            }

                            @Override
                            public void onFailure(Call<Postlist> call, Throwable t) {
                                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                                Log.i("SEE",t.fillInStackTrace().getLocalizedMessage());
                                Log.i("SEE",t.fillInStackTrace().getMessage());
                                //Log.i("SEE",t.fillInStackTrace().getCause());
                                Toast.makeText(getContext(),t.fillInStackTrace().getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                Toast.makeText(getContext(),t.fillInStackTrace().toString(),Toast.LENGTH_LONG).show();
                                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();                            }
                        });

            }
        });
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_tag_top_artist, container, false);
        return rootview;
    }

}
