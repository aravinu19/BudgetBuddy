package com.ivara.aravi.budgetbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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

    final int[] home = new int[1];
    final int[] ck = new int[1];

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

        ck[0] = 0;


        on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked == true){
                   t2.setVisibility(t2.VISIBLE);
                   t4.setVisibility(t4.VISIBLE);
               }
               else {
                   t2.setVisibility(t2.INVISIBLE);
                   t4.setVisibility(t4.INVISIBLE);
                   ck[0]=1;

               }
            }
        });


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int income=Integer.parseInt(t1.getText().toString());
                if(ck[0]==1)
                {
                    home[0] = Integer.parseInt(t2.getText().toString());
                }
                else
                {
                    home[0] = 0;
                }

                int ebbill=Integer.valueOf(t3.getText().toString());

                int mconst = home[0] + ebbill;

                String c1 = String.valueOf(income);
                String c2 = String.valueOf(home[0]);
                String c3 = String.valueOf(ebbill);
                String c4 = String.valueOf(mconst);

                SharedPreferences pref = getSharedPreferences("MonthlyStaticExpense", Context.MODE_PRIVATE);
                SharedPreferences.Editor set = pref.edit();
                set.putString("Income",c1);
                set.putString("HomeRent",c2);
                set.putString("EBbill",c3);
                set.putString("MonthlyExpense",c4);
                set.putString("datatest","yes");
                set.apply();


                Toast.makeText(Main3Activity.this,"Data Saved Securely !!!",Toast.LENGTH_LONG);
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
