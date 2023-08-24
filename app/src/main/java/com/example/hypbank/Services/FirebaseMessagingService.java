package com.example.hypbank.Services;
import androidx.annotation.NonNull;
import com.example.hypbank.Activities.NotificationsActivity;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

@Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null) {
            NotificationsActivity notificationsActivity = new NotificationsActivity(this);
            notificationsActivity.displayNotification(remoteMessage.getNotification().getBody());
        }
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        // TODO: Send this token to your server for later us
    }
}
