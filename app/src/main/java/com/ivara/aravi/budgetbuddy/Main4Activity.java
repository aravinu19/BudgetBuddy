package com.ivara.aravi.budgetbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Main4Activity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    Button s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        t1 = (TextView)findViewById(R.id.food);
        t2 = (TextView)findViewById(R.id.trans);
        t3 = (TextView)findViewById(R.id.shop);
        t4 = (TextView)findViewById(R.id.rc);
        t5 = (TextView)findViewById(R.id.eta);
        t6 = (TextView)findViewById(R.id.dt);
        s = (Button)findViewById(R.id.su);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(t1.getText().toString());
                int t = Integer.parseInt(t1.getText().toString());
                int sp = Integer.parseInt(t1.getText().toString());
                int mrc = Integer.parseInt(t1.getText().toString());
                int etn = Integer.parseInt(t1.getText().toString());
                Calendar cal = Calendar.getInstance();
                String d = cal.getTime().toString();
                int expofday = f+t+sp+mrc+etn;
                t6.setText("Expense Of the Day ("+d+")");
                try
                {
                    File fd = new File("sdcard/Android", "fd.eslock");
                    FileWriter fwfd = new FileWriter(fd);
                    BufferedWriter brfd = new BufferedWriter(fwfd);
                    brfd.write(f);
                    brfd.close();
                    File ft = new File("sdcard/Android", "ftrans.eslock");
                    FileWriter fwft = new FileWriter(ft);
                    BufferedWriter brft = new BufferedWriter(fwft);
                    brft.write(t);
                    brft.close();
                    File fsp = new File("sdcard/Android", "fsp.eslock");
                    FileWriter fwsp = new FileWriter(fsp);
                    BufferedWriter brsp = new BufferedWriter(fwsp);
                    brsp.write(sp);
                    brsp.close();
                    File fmrc = new File("sdcard/Android", "fmobrc.eslock");
                    FileWriter fwmrc = new FileWriter(fd);
                    BufferedWriter brmrc = new BufferedWriter(fwfd);
                    brfd.write(mrc);
                    brfd.close();
                    File fet = new File("sdcard/Android", "fetn.eslock");
                    FileWriter fetn = new FileWriter(fet);
                    BufferedWriter bret = new BufferedWriter(fetn);
                    brfd.write(etn);
                    brfd.close();
                    File fexp = new File("sdcard/Android", "fd.eslock");
                    FileWriter fwexp = new FileWriter(fexp);
                    BufferedWriter brexp = new BufferedWriter(fwexp);
                    brfd.write(expofday);
                    brfd.close();


                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        });
    }
}
