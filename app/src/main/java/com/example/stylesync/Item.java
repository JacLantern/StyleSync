package com.example.stylesync;

import androidx.room.*;

import android.media.Image;

@Fts4
@Entity(tableName = "closet")
public class Item {
    @PrimaryKey
    public String clothingType;
    public boolean isWinter;
    public boolean isSpring;
    public boolean isFall;
    public boolean isSummer;
    public String color;
    public boolean isPatterned;

    public Item(String type, String color, boolean w, boolean sp, boolean f, boolean su, boolean patterned) {
        clothingType = type;
        this.color = color;
        isWinter = w;
        isSpring = sp;
        isFall = f;
        isSummer = su;
        isPatterned = patterned;

    }

}

