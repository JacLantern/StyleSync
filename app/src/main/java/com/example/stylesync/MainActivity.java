package com.example.stylesync;

import androidx.annotation.NonNull;
import android.widget.*;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import androidx.*;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    String[] item = {"Material", "Design", "Components", "Android","5.0 Lollipop"};
    String[] types = {"T-Shirt", "Jeans", "Sweatpants", "Blouse", "Vest", "Shorts", "Leggings", "Overalls"};
    String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Black", "White"};

    AutoCompleteTextView aCTV;
    CheckBox summer;
    CheckBox fall;
    CheckBox winter;
    CheckBox spring;
    CheckBox patterned;
    AutoCompleteTextView type;
    AutoCompleteTextView color;
    Button save;


    ArrayAdapter<String> adapterItems;
    ArrayAdapter<String> adapterColors;
    ArrayAdapter<String> adapterTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bNav = findViewById(R.id.bottom_navigation);
        bNav.setOnNavigationItemSelectedListener(nListener);
        summer = (CheckBox)findViewById(R.id.checkBox4);
        spring = (CheckBox)findViewById(R.id.checkBox);
        winter = (CheckBox)findViewById(R.id.checkBox2);
        fall= (CheckBox)findViewById(R.id.checkBox3);
        patterned = (CheckBox)findViewById(R.id.checkBox5);
        type = (AutoCompleteTextView)findViewById(R.id.clothing_type_select);
        color = (AutoCompleteTextView)findViewById(R.id.color_select);
        save = (Button)findViewById(R.id.button);

        aCTV = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item);
        aCTV.setAdapter(adapterItems);

        adapterColors = new ArrayAdapter<String>(this,R.layout.list_item, colors);
        color.setAdapter(adapterColors);

        adapterTypes = new ArrayAdapter<String>(this,R.layout.list_item, types);
        type.setAdapter(adapterTypes);

        aCTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.clothing_type_select, new MainFragment())
                    .commitNow();

        }

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "closet").allowMainThreadQueries().build();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.itemDao().insertItem(new Item(type.getText().toString(), color.getText().toString(), winter.isChecked(), spring.isChecked(), fall.isChecked(), summer.isChecked(), patterned.isChecked()));
            }
        });



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