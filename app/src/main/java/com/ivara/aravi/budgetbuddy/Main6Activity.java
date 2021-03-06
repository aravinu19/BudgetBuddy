package com.ivara.aravi.budgetbuddy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main6Activity extends AppCompatActivity {

    TextView t1,t2,t3;

    Button sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        t1 =(TextView) findViewById(R.id.mn);
        t2 = (TextView)findViewById(R.id.yr);
        t3=(TextView)findViewById(R.id.dy);

        sh =(Button)findViewById(R.id.show);

        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = t1.getText().toString();
                StringBuilder builder = new StringBuilder(m);
                builder.setCharAt(0,Character.toUpperCase(builder.charAt(0)));
                m = builder.toString();
                String y = t2.getText().toString();
                String d = t3.getText().toString();

                SharedPreferences spe1 = getSharedPreferences("Expense-"+m+"-"+d+","+y, Context.MODE_PRIVATE);
                int data = spe1.getInt("ExpenseOfDay",0);

                Toast.makeText(getApplicationContext(),"Expense of "+d+"-"+m+"-"+y+" is "+data,Toast.LENGTH_LONG).show();
            }
        });
    }
}
