package com.example.projektjava;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Database_dao {

    @Query("SELECT * FROM database_exercises")
    List<Database_exercises> getAllExercises();

    @Insert
    void insertExercise(Database_exercises... exercises);

    @Delete
    void delete(Database_exercises exercise);

    @Query("DELETE FROM Database_exercises WHERE ch_exercise = :exercise")
    abstract void deleteByTitle(String exercise);

    @Query("DELETE FROM database_exercises")
    void deleteAll();

}

