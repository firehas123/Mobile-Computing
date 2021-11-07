package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class OptionScreen extends AppCompatActivity {
    Button exam;
    Button practise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_screen);
        //setting on click event for both buttons
    }
}