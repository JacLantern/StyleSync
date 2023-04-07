package com.example.stylesync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bNav = findViewById(R.id.bottom_navigation);
        bNav.setOnNavigationItemSelectedListener(nListener);
    }
    BottomNavigationView.OnNavigationItemSelectedListener nListener =  new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag = null;

            switch (item.getItemId()){
                case R.id.closetFragment:
                    selectedFrag = new ClosetFragment();
                    break;
                case R.id.cameraFragment:
                    selectedFrag = new CameraFragment();
                    break;
                case R.id.suggestionsFragment:
                    selectedFrag = new SuggestionsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,selectedFrag).commit();

            return true;
        }
    };
}