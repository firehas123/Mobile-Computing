package com.example.color_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView,textView2,textView4,valueinPounds;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView4= findViewById(R.id.textView4);
        valueinPounds = findViewById(R.id.valueOfPounds);

        editText = findViewById(R.id.editText);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ConvertFromKiloToFound();
            }
        });
    }

    private void ConvertFromKiloToFound(){

        String valueEnteredinKILO = editText.getText().toString();

        double Kilo = Double.parseDouble(valueEnteredinKILO);

        double pounds = Kilo * 2.205;

        valueinPounds.setText(""+ pounds);

    }
}