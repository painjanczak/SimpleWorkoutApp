package com.example.projektjava;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Database_exercises.class}, version  = 1, exportSchema = false)
public abstract class Database_main extends RoomDatabase {

    public abstract Database_dao database_dao();
    private static Database_main INSTANCE;


    public static Database_main getDbInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database_main.class, "database_test")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}

