package com.example.arrayadapterdeleter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //defining the elements used in our activity
    ListView myListView;
    ArrayList<String> data = new ArrayList<>();
    EditText editText;
    Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating instance of the defined elements
        insert = findViewById(R.id.insert);
        editText = findViewById(R.id.enterItem);
        myListView = findViewById(R.id.displayList);
        //displaying data in the list
        data.add("hassan1");
        data.add("nauman1");
        data.add("hassan2");
        data.add("nauman2");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        myListView.setAdapter(arrayAdapter);
        // creating listener for the insert button
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "Empty item can't be added", Toast.LENGTH_LONG).show();
                else {
                    data.add(editText.getText().toString());
                    editText.setText("");
                    //notifying our arrayAdapter of the changes we made
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        //now adding functionality to each item on the listView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemPressed = ((TextView) view).getText().toString();
                //displaying dialog box
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to delete "+itemPressed+"?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //deleting the item
                        data.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}