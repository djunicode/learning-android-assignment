package com.example.musicfinder;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TagTopArtistFragment ttFrag=new TagTopArtistFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_main,ttFrag);
        mBottomNavigationView=findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.tagTopArtist:
                                setFrag(ttFrag);
                        }
                    }
                });



    }


    void setFrag(Fragment fragment)
    {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_main,fragment);
        mBottomNavigationView=findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemReselectedListener(
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.artistSearch:

                            setFrag(new artistSearchFragment());
                            break;
                        case R.id.albumSearch:setFrag(new AlbumSearch());
                    }
                }
            });



    }

    void setFrag(Fragment fragment)
    {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction()
            .replace(R.id.frame_layout_main,fragment);

        ft.commit();
    }
}