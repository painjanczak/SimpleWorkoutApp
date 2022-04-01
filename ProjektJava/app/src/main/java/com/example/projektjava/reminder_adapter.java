package com.example.projektjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class reminder_adapter extends RecyclerView.Adapter<reminder_adapter.MyViewHolder> {


    private Context context;
    private List<Database_exercises> exercisesList;
    public reminder_adapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<Database_exercises> exercisesList) {
        this.exercisesList = exercisesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public reminder_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.reminder_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull reminder_adapter.MyViewHolder holder, int position) {
        holder.nameExercise.setText(this.exercisesList.get(position).chExercise);
        holder.timeDate.setText(this.exercisesList.get(position).chDate + " " + this.exercisesList.get(position).chTime);
        holder.deleteButton.setText("Usuń");
    }

    private void deleteExercise(int position) {
        exercisesList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, exercisesList.size());
    }

    private Context mContext;
    @Override
    public int getItemCount() {
        return  this.exercisesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameExercise;
        TextView timeDate;
        Button deleteButton;

        public MyViewHolder(View view) {
            super(view);
            nameExercise = view.findViewById(R.id.nameExercise);
            timeDate = view.findViewById(R.id.timeDate);
            deleteButton = view.findViewById(R.id.deleteButton);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteExercise(getAbsoluteAdapterPosition());
                    Database_main db = Database_main.getDbInstance(mContext);
                    String text2 = nameExercise.getText().toString();
                    db.database_dao().deleteByTitle(text2);
                }
            });

        }
    }
}
