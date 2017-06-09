package com.example.statusbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onNotify(View view) {

        Intent intent = new Intent(this, NotificationActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle("Title")
        .setContentInfo("Info")
        .setContentText("Text")
        .setDefaults(Notification.DEFAULT_ALL)
        .setOngoing(true)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .addAction(R.mipmap.ic_launcher, "Action1", pendingIntent);

        Notification notification = builder.build();
        manager.notify(4654, notification);

    }
}
