package com.example.projektjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


class LV_adapter extends ArrayAdapter<String> {

    Context context;
    String name[];
    String description[];

    LV_adapter (Context con, String name[], String description[]) {
        super(con, R.layout.row_data, R.id.rowExercise, name);
        this.context = con;
        this.name = name;
        this.description = description;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = layoutInflater.inflate(R.layout.row_data, parent, false);
        TextView myTitle = row.findViewById(R.id.rowExercise);
        myTitle.setText(name[position]);

        return row;
    }
}

