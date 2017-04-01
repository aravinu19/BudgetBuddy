package com.ivara.aravi.budgetbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main3Activity extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    Button s;
    Switch on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        t1 = (TextView)findViewById(R.id.inc);
        t2 = (TextView)findViewById(R.id.hrent);
        t3 = (TextView)findViewById(R.id.peb);
        t4 = (TextView)findViewById(R.id.rent);
        on = (Switch)findViewById(R.id.s1);
        s = (Button)findViewById(R.id.smit);
        t2.setVisibility(t2.INVISIBLE);
        t4.setVisibility(t4.INVISIBLE);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int income=Integer.parseInt(t1.getText().toString());
                int home=Integer.parseInt(t2.getText().toString());
                int ebbill=Integer.parseInt(t3.getText().toString());
                if(on.isChecked())
                {
                    t2.setVisibility(t2.VISIBLE);
                    t4.setVisibility(t4.VISIBLE);
                }
                else
                {
                    t2.setVisibility(t2.INVISIBLE);
                    t4.setVisibility(t4.INVISIBLE);
                    home = 0;
                }
                int mconst = home + ebbill;

                try {
                    File in = new File("/sdcard/Android","in.eslock");
                    FileWriter fw = null;
                    fw = new FileWriter(in);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(income);
                    bw.close();
                    File mnConst = new File("/sdcard/Android","mcst.eslock");
                    FileWriter fw1 = new FileWriter(mnConst);
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    bw1.write(mconst);
                    bw1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(Main3Activity.this,"Data Saved Securely !!!",Toast.LENGTH_LONG);
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
