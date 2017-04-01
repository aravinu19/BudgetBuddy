//package com.ivara.aravi.budgetbuddy;
//
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.support.v4.app.NotificationCompat;
//
///**
// * Created by Aravi on 22-03-2017.
// */
//
//public class ntinter extends BroadcastReceiver {
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//        NotificationManager nm = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
//
//        Intent intent1;
//        intent1 = new Intent(ntinter.this,REP.class);
//
//        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .setContentText("Budget Buddy")
//                .setContentText("Don't Forget to write today's Expense .")
//                .setSmallIcon(R.drawable.ic);
//
//        nm.notify(100,builder.build());
//
//    }
//}
