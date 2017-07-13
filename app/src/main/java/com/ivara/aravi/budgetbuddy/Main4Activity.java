package com.ivara.aravi.budgetbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main4Activity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    Button s;
    ImageButton b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        b = (ImageButton)findViewById(R.id.eim1);

        t1 = (TextView)findViewById(R.id.food);
        t2 = (TextView)findViewById(R.id.trans);
        t3 = (TextView)findViewById(R.id.shop);
        t4 = (TextView)findViewById(R.id.rc);
        t5 = (TextView)findViewById(R.id.eta);
        t6 = (TextView)findViewById(R.id.dt);

        Calendar cal = Calendar.getInstance();

        String dateStr = "1/04/2017";

        final String[] date= new String[10];

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateObj = curFormater.parse(dateStr);
            SimpleDateFormat postFormater = new SimpleDateFormat("MMMM-dd,yyyy");
//

            date[0] = postFormater.format(cal.getTime());
            Log.d("Aravi","Date check :"+date[0]);
        }
        catch (Exception e){}

        t6.setText("Expense Of the Day ("+date[0]+")");
        try{
            SimpleDateFormat ne = new SimpleDateFormat("MM,yyyy");
            date[1]= ne.format(cal.getTime());
            Log.d("Aravi","Date check :"+date[1]);
        }
        catch (Exception e){}

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main5Activity.class));
            }
        });

        s = (Button)findViewById(R.id.su);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                int f = Integer.parseInt(t1.getText().toString());
                int t = Integer.parseInt(t1.getText().toString());
                int sp = Integer.parseInt(t1.getText().toString());
                int mrc = Integer.parseInt(t1.getText().toString());
                int etn = Integer.parseInt(t1.getText().toString());

                int expofday = f+t+sp+mrc+etn;

                SharedPreferences pref = getSharedPreferences("Expense-"+date[0], Context.MODE_PRIVATE);
                SharedPreferences.Editor set = pref.edit();
                set.putInt("Food",f);
                set.putInt("Transport",t);
                set.putInt("Shopping",sp);
                set.putInt("MobileRC",mrc);
                set.putInt("Entertainment",etn);
                set.putInt("ExpenseOfDay",expofday);
                set.apply();

                SharedPreferences spe1 = getSharedPreferences("ExpenseTotal-"+date[1],Context.MODE_PRIVATE);
                int tp = spe1.getInt("Total",0);
                expofday=tp+expofday;

                SharedPreferences spe = getSharedPreferences("ExpenseTotal-"+date[1],Context.MODE_PRIVATE);

                SharedPreferences.Editor set1 = spe.edit();
                set1.putInt("Total",expofday);
                set1.apply();

                Toast.makeText(getApplicationContext(),"Data of the Day" +date[0]+" is Saved ! Plz Come Back Tomorrow!!",Toast.LENGTH_LONG).show();

            }
        });
    }
}
