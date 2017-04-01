package com.ivara.aravi.budgetbuddy;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main2Activity extends Activity {
    TextView t1,t2,t3;
    Button B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1=(TextView) findViewById(R.id.em);

        t2=(TextView) findViewById(R.id.un);

        t3=(TextView) findViewById(R.id.pw);

        B=(Button)findViewById(R.id.b);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1.getText()!=null && t2.getText()!=null && t3.getText()!=null) {
                    String s1 = t1.getText().toString().trim();
                    String s2 = t2.getText().toString();
                    String s3 = t3.getText().toString().trim();

                    SharedPreferences spref = getSharedPreferences("Savedlogin",Context.MODE_PRIVATE);

                    SharedPreferences.Editor set = spref.edit();
                    set.putString("Email",s1);
                    set.putString("uname",s2);
                    set.putString("pass",s3);
                    set.apply();

                    SharedPreferences pref = getSharedPreferences("MonthlyStaticExpense",Context.MODE_PRIVATE);
                    String test = pref.getString("datatest","");
                    if (test.equalsIgnoreCase("yes"))
                    {
                        SharedPreferences.Editor del = pref.edit();
                        del.clear().commit();
                        del.apply();
                    }
                    Toast.makeText(getApplicationContext(),"Registration Successful !",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All fields are necessary !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

