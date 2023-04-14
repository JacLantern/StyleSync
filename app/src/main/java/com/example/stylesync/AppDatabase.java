package com.example.stylesync;

import androidx.room.*;

import com.example.stylesync.Item;
import com.example.stylesync.ItemDao;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}