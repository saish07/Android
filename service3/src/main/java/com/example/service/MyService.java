package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by saish on 19/6/17.
 */

public class MyService extends Service{
    private MediaPlayer player;

    public MyService() {
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                player = MediaPlayer.create(MyService.this, R.raw.abc);
                player.start();
            }
        }).start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();
    }
}
