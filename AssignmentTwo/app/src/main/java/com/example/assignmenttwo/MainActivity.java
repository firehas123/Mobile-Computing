package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing var
        btn = findViewById(R.id.NextBtn);
        repo = findViewById(R.id.Repo);

        //next button onClick event
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating intent object
                Intent intent = new Intent(MainActivity.this,OptionScreen.class);
                startActivity(intent);
            }
        });
        // repo button onClick listener
        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://github.com/firehas123/Mobile-Computing/tree/main/AssignmentTwo");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });


    }

}
