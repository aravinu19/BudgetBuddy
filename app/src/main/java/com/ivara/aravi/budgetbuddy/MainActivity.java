package com.ivara.aravi.budgetbuddy;

        import android.app.Activity;
        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.Intent;
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
            public void onClick(View view) {
                try
                {
                    File filei = new File("/sdcard/Android", "baran");
                    FileReader fp = new FileReader(filei);
                    BufferedReader br = new BufferedReader(fp);
                    File filep = new File("/sdcard/Android", "baran.usr");
                    FileReader fpp = new FileReader(filep);
                    BufferedReader brp = new BufferedReader(fpp);
                    File fileu = new File("/sdcard/Android", "baran.psk");
                    FileReader fpu = new FileReader(fileu);
                    BufferedReader bru = new BufferedReader(fpu);
                    String c1 = t1.getText().toString();
                    String c2 = t2.getText().toString();

                    String s1 = br.readLine().toString();
                    String s2 = brp.readLine().toString();
                    String s3 = bru.readLine().toString();
                    System.out.println(s1+"\n"+s2+"\n"+s3);
                    System.out.println("Typed Data:"+c1+"\n"+c2+"\n"+s1.compareTo(c1)+"\n"+c2.compareTo(s2));
                    int g,f,k = 0;
                    g=s1.compareTo(c1);
                    f=s2.compareTo(c2);
                    System.out.println("Aravi Debuger"+g+"b"+f+"bb"+c2+"\n"+k);
                    if(g==k)
                    {
                        k=1;
                    }
                    if(k==1) {
                        Toast.makeText(MainActivity.this, s1 + " Login Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,inter.class);
                        startActivity(intent);

                        //Notification Activity for Budget Buddy !!!
//                        Calendar cal = Calendar.getInstance();
//                        cal.set(Calendar.HOUR_OF_DAY,20);
//                        cal.set(Calendar.MINUTE,30);
//
//                        Intent nt = new Intent(getApplicationContext(),ntinter.class);
//                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,nt,PendingIntent.FLAG_UPDATE_CURRENT);
//                        AlarmManager nti = (AlarmManager)getSystemService(ALARM_SERVICE);
//                        nti.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,s2+" Login Credentials Mismatch",Toast.LENGTH_LONG).show();
                    }


                }
                catch (IOException e)
                {
                    e.printStackTrace();
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
}
