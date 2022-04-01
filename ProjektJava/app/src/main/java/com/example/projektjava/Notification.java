package com.example.projektjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.List;

public class Notification extends BroadcastReceiver {

    private Database_main databaseMain;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String text = bundle.getString("message");

        databaseMain = Database_main.getDbInstance(context.getApplicationContext());
        Database_dao databaseDao = databaseMain.database_dao();
        Database_exercises exercise = new Database_exercises();
        exercise.setChExercise(text);
        exercise.setChDate((intent.getStringExtra("date")));
        exercise.setChTime((intent.getStringExtra("time")));
        exercise.setUid(intent.getIntExtra("uid",0));
        databaseDao.delete(exercise);
        databaseMain.destroyInstance();
        Database_main db = Database_main.getDbInstance(context.getApplicationContext());
        db.database_dao().deleteByTitle(text);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyId")
                .setSmallIcon(R.drawable.alarm)
                .setContentTitle(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(100,builder.build());
    }


}
