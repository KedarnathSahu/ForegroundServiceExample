package com.cumulations.foregroundserviceexample;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import static com.cumulations.foregroundserviceexample.NotificationChannelCreater.CHANNEL_ID;

public class ForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String body=intent.getStringExtra("body");

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        NotificationCompat.Builder notification=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Foreground Service is running.")
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentIntent(pendingIntent);

        //Show the Foreground Notification: Non-Cancelable
        startForeground(1,notification.build());

        //Show the Notification: Cancelable
//        NotificationManagerCompat.from(this).notify(1,notification.build());


        //2 ways we can stop foreground services by: stopService() & stopForeground()
        //do some task and write some condition to check if the job z done. Thn stop the foreground.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            stopForeground(1);
//        }

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
