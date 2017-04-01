package com.ivara.aravi.budgetbuddy;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
                    String s1 = t1.getText().toString();
                    String s2 = t2.getText().toString();
                    String s3 = t3.getText().toString();
                    try {
                        File filei = new File("/sdcard/Android", "baran");
                        File filep = new File("/sdcard/Android","baran.usr");
                        File fileU = new File("/sdcard/Android","baran.psk");
                        FileWriter fw = new FileWriter(filei);
                        BufferedWriter bw = new BufferedWriter(fw);
                        FileWriter fwp = new FileWriter(filep);
                        BufferedWriter bwp = new BufferedWriter(fwp);
                        FileWriter fwu = new FileWriter(fileU);
                        BufferedWriter bwu = new BufferedWriter(fwu);
                        bw.write(s1);
                        bwp.write(s2);
                        bwu.write(s3);
                        bw.close();
                        bwp.close();
                        bwu.close();
                        Toast.makeText(Main2Activity.this,"Registration SuccessFul",Toast.LENGTH_LONG).show();

                        File in1 = new File("sdcard/Android","in.eslock");
                        boolean deleted = in1.delete();

                        Intent in = new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(in);

                    } catch (FileNotFoundException e) {
                        System.out.println("Exception is "+e);
                        e.printStackTrace();
                    } catch (IOException e) {
                        System.out.println("Exception is "+e);

                        e.printStackTrace();
                    }


                }
            }
        });
    }
}

