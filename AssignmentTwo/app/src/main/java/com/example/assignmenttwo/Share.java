package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Share extends AppCompatActivity {
    TextView output;
    Button share;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        share = findViewById(R.id.button);
        output = findViewById(R.id.Output);
        home = findViewById(R.id.button2);
        Intent intent = getIntent();
        String marks = intent.getStringExtra("Marks");
        output.setText("Congratulations you scored "+marks+"/5");
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, output.getText());
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Share.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}