package com.ivara.aravi.budgetbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class inter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter);
        File in = new File("/sdcard/Android","in.eslock");
        if(in.exists())
        {
            Intent intent = new Intent(inter.this, Main4Activity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(inter.this,Main3Activity.class);
            startActivity(intent);
        }
    }
}
