package com.example.projektjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LC_activitydata extends AppCompatActivity {

    TextView ex_description;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lc_activitydata);

        ex_description = findViewById(R.id.listdata);

        if (position == 0) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 1) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 2) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 3) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 4) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 5) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 6) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 7) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 8) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 9) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 10) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 11) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 12) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 13) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
        if (position == 14) {
            Intent intent = getIntent();
            String description_exercises = intent.getStringExtra("description");
            ex_description.setText(description_exercises);
        }
    }
}