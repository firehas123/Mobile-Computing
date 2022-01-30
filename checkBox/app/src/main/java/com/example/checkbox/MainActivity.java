package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public CheckBox first,second;
    public Button button;
    public TextView text;
    public ArrayList<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first=findViewById(R.id.checkBox);
        second=findViewById(R.id.checkBox2);
        button=findViewById(R.id.button);
        result=new ArrayList<String>();
        //text.setEnabled(false);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(first.isChecked())
                {
                    result.add("first check Box");
                }
                else
                {
                    result.remove("first check Box");
                }
            }


        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(second.isChecked())
                {
                    result.add("second check Box");
                }
                else
                {
                    result.remove("second check Box");
                }


            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                for(String a:result)
                {
                    sb.append(a).append("/n");
                }
                text.setText(sb.toString());
                //text.setEnabled(false);
            }
        });
    }
}