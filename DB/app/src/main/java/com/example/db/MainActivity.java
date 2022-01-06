package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button butttonAdd, buttonView;
    EditText editName, editAge;
    Switch switchisActive;
    ListView listViewDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butttonAdd = findViewById(R.id.buttonAdd);
        buttonView = findViewById(R.id.buttonView);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        switchisActive = findViewById(R.id.switchisActive);
        listViewDetail = findViewById(R.id.listViewDetails);

        butttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}