package com.example.projektjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LC_activity extends AppCompatActivity {

    public static final int number_exercises = 15;

    ListView listView;
    static String[] name_exercises = new String[number_exercises];
    static String[] description_exercises = new String[number_exercises];


    public void readFile(String[] array, String filename)  {

        int counter = 0;

        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename)));
            String result;
            while ((result = reader.readLine()) != null) {
                array[counter] = result;
                counter++;
            }
            reader.close();

        }
        catch (IOException e) {
            System.out.println("Ooops... Wystąpił błąd: ");
            e.printStackTrace();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lc);

        listView = findViewById(R.id.listview);

        readFile(name_exercises, "exercises.csv");
        readFile(description_exercises, "exercises_descriptions.csv");

        LV_adapter adapter = new LV_adapter(this, name_exercises, description_exercises);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[0]);
                    intent.putExtra("description", description_exercises[0]);
                    startActivity(intent);

                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[1]);
                    intent.putExtra("description", description_exercises[1]);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[2]);
                    intent.putExtra("description", description_exercises[2]);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[3]);
                    intent.putExtra("description", description_exercises[3]);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[4]);
                    intent.putExtra("description", description_exercises[4]);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[5]);
                    intent.putExtra("description", description_exercises[5]);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[6]);
                    intent.putExtra("description", description_exercises[6]);
                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[7]);
                    intent.putExtra("description", description_exercises[7]);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[8]);
                    intent.putExtra("description", description_exercises[8]);
                    startActivity(intent);
                }
                if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[9]);
                    intent.putExtra("description", description_exercises[9]);
                    startActivity(intent);
                }
                if (position == 10) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[10]);
                    intent.putExtra("description", description_exercises[10]);
                    startActivity(intent);
                }
                if (position == 11) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[11]);
                    intent.putExtra("description", description_exercises[11]);
                    startActivity(intent);
                }
                if (position == 12) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[12]);
                    intent.putExtra("description", description_exercises[12]);
                    startActivity(intent);
                }
                if (position == 13) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[13]);
                    intent.putExtra("description", description_exercises[13]);
                    startActivity(intent);
                }
                if (position == 14) {
                    Intent intent = new Intent(getApplicationContext(), LC_activitydata.class);
                    intent.putExtra("name", name_exercises[14]);
                    intent.putExtra("description", description_exercises[14]);
                    startActivity(intent);
                }
            }
        });
    }


}

