package com.example.stylesync;

import androidx.annotation.NonNull;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    String[] item = {"Material", "Design", "Components", "Android","5.0 Lollipop"};

    AutoCompleteTextView aCTV;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bNav = findViewById(R.id.bottom_navigation);
        bNav.setOnNavigationItemSelectedListener(nListener);

        aCTV = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item);

        aCTV.setAdapter(adapterItems);

        aCTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();

        }

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