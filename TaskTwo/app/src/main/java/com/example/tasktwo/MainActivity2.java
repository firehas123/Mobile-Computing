package com.example.tasktwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tx = findViewById(R.id.DisplayNum);
        Intent in = getIntent();
        String s  = in.getStringExtra("Num");
        tx.setText("Number you entered was "+s);

    }
}