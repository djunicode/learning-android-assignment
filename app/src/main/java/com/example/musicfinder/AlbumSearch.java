package com.example.musicfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumSearch extends Fragment {
    private RecyclerView rv;
    private RecyclerView.Adapter Adapter;
    private List<AlbumResponseModel> list;
    private EditText searchEdittext;
     String searchString;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.albumsearch,container,false);  }

    @Override
    public void onViewCreated(@NonNull final  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchEdittext=getView().findViewById(R.id.albumsrch);


        list=new ArrayList<>();
        searchEdittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH)
                {
                    searchString =searchEdittext.getText().toString();

                    Retrofit rf=new Retrofit.Builder().baseUrl(LastFMService.Base_URL).addConverterFactory(GsonConverterFactory.create()).build();

                    LastFMService api=rf.create(LastFMService.class );

                   Call<Application> resp =api.getAlbum(searchString);


                    resp.enqueue(new Callback<Application>() {
                       @Override
                       public void onResponse(Call<Application> call,
                               Response<Application> response) {

                           if(response.isSuccessful()) {

                                Application app=response.body();
                                AlbumSearchResults res=app.ResultsObject;
                                Albummatches am=res.AlbummatchesObject;

                               list = am.album;


                               Adapter = new AlbumAdaptor(list, view.getContext());

                               rv=getView().findViewById(R.id.recyclerview);

                               rv.setHasFixedSize(true);
                               rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
                               rv.setAdapter(Adapter);


                           }
                           else
                           {
                               Toast.makeText(view.getContext(),"resp not",Toast.LENGTH_SHORT).show();
                           }


                       }

                       @Override
                       public void onFailure(Call<Application> call, Throwable t) {
                           Toast.makeText(view.getContext(),"error in retrieval",Toast.LENGTH_SHORT).show();


                       }
                   });

                    return true;
                }
                Toast.makeText(view.getContext(),"enter valid search query",Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
}
