package com.ivara.aravi.budgetbuddy;

        import android.app.Activity;
        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.*;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.Calendar;
        import java.util.StringTokenizer;

public class MainActivity extends Activity {

    TextView t1,t2;
    Button c,v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView)findViewById(R.id.et1);
        t2 = (TextView)findViewById(R.id.et2);

        c = (Button)findViewById(R.id.b1);
        v = (Button)findViewById(R.id.b2);


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em1 = t1.getText().toString().trim();
                String pw1 = t2.getText().toString().trim();

                SharedPreferences pref = getSharedPreferences("Savedlogin", Context.MODE_PRIVATE);

                String em2 = pref.getString("uname","");

                String pw2 = pref.getString("pass","");

                //String uname = pref.getString("uname","");

                if (em1.equalsIgnoreCase(em2) && pw1.equalsIgnoreCase(pw2)) {
                    Toast.makeText(getApplicationContext(), "Hai " + em2 + ", It's Nice to See !", Toast.LENGTH_SHORT).show();

                   checkdata();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login Credentials Mismatch !!!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in1);
            }
        });
    }
    public void checkdata()
    {
        SharedPreferences spref = getSharedPreferences("MonthlyStaticExpense", Context.MODE_PRIVATE);
        String test = spref.getString("datatest", "");
        if (test.equalsIgnoreCase("yes")) {
            startActivity(new Intent(getApplicationContext(), Main4Activity.class));
        }
        else
        {
            startActivity(new Intent(getApplicationContext(), inter.class));
        }
    }
}
//Notification Activity for Budget Buddy !!!
//                        Calendar cal = Calendar.getInstance();
//                        cal.set(Calendar.HOUR_OF_DAY,20);
//                        cal.set(Calendar.MINUTE,30);
//
//                        Intent nt = new Intent(getApplicationContext(),ntinter.class);
//                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,nt,PendingIntent.FLAG_UPDATE_CURRENT);
//                        AlarmManager nti = (AlarmManager)getSystemService(ALARM_SERVICE);
//                        nti.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
