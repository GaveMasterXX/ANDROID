package pdm.ipbeja.pt.work;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class NotificationHelper extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationClick = new Intent(context, MainActivity.class);
        notificationClick.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivities(context, 100, new Intent[]{notificationClick}, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_down_float)
                .setContentTitle("HealthBox")
                .setContentText("Tens medicamentos para Tomar!!")
                .setAutoCancel(true);

        notificationManager.notify(100, builder.build());
    }
}
