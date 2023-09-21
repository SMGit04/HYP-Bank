//package com.example.hypbank.Activities;
//
//import android.app.Notification;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Build;
//
//import androidx.core.app.NotificationCompat;
//
//import com.example.hypbank.R;
//
//public class NotificationsActivity {
//    Context context;
//    String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";
//
//    public NotificationsActivity(Context context) {
//        this.context = context;
//    }
//
//    public void displayNotification(String message) {
//
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        createNotificationChannel(notificationManager, NOTIFICATION_CHANNEL_ID);
//
//        // Create an explicit intent for an Activity
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        intent.putExtra("ShowAlert", true);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
//
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
//
//        notificationBuilder.setAutoCancel(true)
//                .setDefaults(Notification.DEFAULT_ALL)
//                //  .setWhen(System.currentTimeMillis())
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("New Message")
//                .setContentText(message)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                // Set the intent that will fire when the user taps the notification
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
//
//        // .setContentInfo("Info");
//
//        notificationManager.notify(1, notificationBuilder.build());
//    }
//
//    private void createNotificationChannel(NotificationManager notificationManager, String NOTIFICATION_CHANNEL_ID) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel notificationChannel =
//                    new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NotificationsActivity", NotificationManager.IMPORTANCE_HIGH);
//
//            notificationChannel.setDescription("Channel Description");
//            notificationChannel.enableLights(true);
//            notificationChannel.setLightColor(Color.WHITE);
//            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
//            notificationChannel.enableVibration(true);
//
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//    }
//}