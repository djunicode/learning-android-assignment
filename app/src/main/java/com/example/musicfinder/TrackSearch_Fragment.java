package com.example.musicfinder;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TrackSearch_Fragment extends Fragment
{
    private String urlString,temp;
    Context cont;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_track_search_,null);
        Button search = v.findViewById(R.id.searchBtn);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTrack = v.findViewById(R.id.editTrack);
                String songName = editTrack.getText().toString();

                if(songName!=null)
                {
                    temp = "http://ws.audioscrobbler.com/2.0/?method=track.search&api_key=2d9dba387ac1c3dd723f22bb9407e042&format=json&track=";
                    urlString = temp.concat( songName );
                    new ProcessJSON(cont,v).execute(urlString);
                }
                else
                {
                    Toast.makeText(cont, "You have not entered anything!", Toast.LENGTH_LONG).show();
                }

            }
        });


        return v;
    }

    public void onAttach(Context context) {

        super.onAttach(context);
        this.cont = context;

    }

}
