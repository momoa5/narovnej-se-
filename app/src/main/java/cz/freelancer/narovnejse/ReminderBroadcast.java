package cz.freelancer.narovnejse;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class ReminderBroadcast  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyLemubit")
                .setSmallIcon(R.drawable.logo_icon)
                .setContentTitle("Nehrb se!")
                .setContentText("Uz ses narovnal/a?")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(200, builder.build());

    }

}
