package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionScreen extends AppCompatActivity {
    Button exam;
    Button practise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_screen);
        // this the screen where user will decide whether he wants ot select exam button option or non exam button option
        //setting on click event for both buttons
        exam = findViewById(R.id.buttonE);
        practise = findViewById(R.id.buttonP);
        //getting intent
        Intent in = new Intent(OptionScreen.this,Quiz.class);
        //implementing the button
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.putExtra("Button","Exam");
                startActivity(in);
            }
        });
        practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.putExtra("Button","practise");
                startActivity(in);
            }
        });
    }
}