package com.example.musicfinder;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
Fragment fg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bv;
        bv=findViewById(R.id.bottomnav);
        bv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.album:fg=new AlbumSearch();
                        break;
                    case R.id.track:
                        break;
                    case R.id.artist:
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fg).commit();
                return true;
            }
        });

    }
}
