package com.example.projektjava;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TimePicker;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class reminder_add extends AppCompatActivity {

    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    Button dateButton, timeButton;
    String alarmTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_add);

        final EditText chExerciseInput =  findViewById(R.id.exerciseInput);
        Button saveButton =  findViewById(R.id.saveButton);
        dateButton =  findViewById(R.id.dateButton);
        timeButton =  findViewById(R.id.timeButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExercise(chExerciseInput.getText().toString(), dateButton.getText().toString(), timeButton.getText().toString());
                createNotificationChannel();
                try {
                    Alarm(dateButton.getText().toString(), timeButton.getText().toString(), chExerciseInput.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseDate();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseTime();
            }
        });
    }

    private void chooseDate(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        dateButton.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void chooseTime(){
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        timeButton.setText(sHour + ":" + sMinute);
                        alarmTime = sHour + ":" + sMinute;
                    }
                }, hour, minutes, true);
        timePickerDialog.show();
    }

    private void Alarm(String date, String time, String message) throws ParseException {
        Intent intent = new Intent(this, Notification.class);
        intent.putExtra("date", date);
        intent.putExtra("time", time);
        intent.putExtra("message", message);
        PendingIntent pIntent = PendingIntent.getBroadcast(reminder_add.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        String dateTime = date + " " + alarmTime;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date1 = format.parse(dateTime);
        alarmManager.set(AlarmManager.RTC_WAKEUP, date1.getTime(), pIntent);

    }


    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "ReminderChannell";
            String description = "Channell";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channell = new NotificationChannel("notifyId", name, importance);
            channell.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channell);

        }
    }


    private void saveExercise(String chExercise, String chDate, String chTime){
        Database_main db  = Database_main.getDbInstance(this.getApplicationContext());

        Database_exercises exercise = new Database_exercises();
        exercise.chExercise = chExercise;
        exercise.chDate = chDate;
        exercise.chTime = chTime;

        db.database_dao().insertExercise(exercise);

        finish();

    }


}


