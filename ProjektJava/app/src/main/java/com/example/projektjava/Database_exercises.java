package com.example.projektjava;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Database_exercises {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "ch_exercise")
    public String chExercise;

    @ColumnInfo(name = "ch_date")
    public String chDate;

    @ColumnInfo(name = "ch_time")
    public String chTime;

    public void setChExercise(String chExercise) {
        this.chExercise = chExercise;
    }
    public void setChDate(String chDate) {
        this.chDate = chDate;
    }
    public void setChTime(String chTime) {
        this.chTime = chTime;
    }
    public void setUid(int uid){ this.uid = uid; }

}
