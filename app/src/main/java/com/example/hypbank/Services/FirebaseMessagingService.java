package com.example.hypbank.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.hypbank.Activities.MainActivity;
import com.example.hypbank.R;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the context variable when the service is created
        context = getApplicationContext();
    }
    Context context;
@Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    super.onMessageReceived(remoteMessage);

    String title = remoteMessage.getNotification().getTitle();
    String message = remoteMessage.getNotification().getBody();

    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    createNotificationChannel(notificationManager, NOTIFICATION_CHANNEL_ID);

    // Create an explicit intent for an Activity
    Intent intent = new Intent(context, MainActivity.class);
    intent.putExtra("SHOW_ALERT", true);
    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID);

    notificationBuilder.setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true);

    notificationManager.notify(1, notificationBuilder.build());
}

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }

    private void createNotificationChannel(NotificationManager notificationManager, String NOTIFICATION_CHANNEL_ID) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NotificationsActivity", NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.setDescription("Channel Description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.WHITE);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
