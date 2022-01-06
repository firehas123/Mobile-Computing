package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

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
            CustomerModel customerModel;
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"Add Button Clicked",Toast.LENGTH_LONG).show();
                customerModel = new CustomerModel(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),switchisActive.isChecked(),1);
                
            }
        });
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"Add View Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}