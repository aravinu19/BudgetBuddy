package com.ivara.aravi.budgetbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    Button sh,vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        sh = (Button)findViewById(R.id.se);

        vm = (Button)findViewById(R.id.v);

        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spe1 = getSharedPreferences("ExpenseTotal-07,2017", Context.MODE_PRIVATE);
                int tp = spe1.getInt("Total",0);
                Toast.makeText(getApplicationContext(),"Expense Total = "+tp,Toast.LENGTH_LONG).show();
            }
        });

        vm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main6Activity.class));
            }
        });

    }
}
