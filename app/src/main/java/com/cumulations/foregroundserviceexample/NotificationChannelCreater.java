package com.cumulations.foregroundserviceexample;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationChannelCreater extends Application {
    public static final String CHANNEL_ID="channel1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel serviceChannel =new NotificationChannel(CHANNEL_ID,"Foreground Service Channel",NotificationManager.IMPORTANCE_DEFAULT);
            getSystemService(NotificationManager.class).createNotificationChannel(serviceChannel);
        }
    }
}
