package com.example.alertdialog_list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String [] Colors = {"Red", "Green", "Blue"};
    ArrayList<Integer> selectedItems = new ArrayList(); // Where we track the selected items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //code for dialog list
        findViewById(R.id.btnList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("SetColor")
                        .setItems(Colors, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, Colors[which], Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        //code for mulit list
        findViewById(R.id.btnMulti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select options")
                        .setMultiChoiceItems(Colors, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            selectedItems.add(which);
                                        } else if (selectedItems.contains(which)) {
                                            selectedItems.remove(Integer.valueOf(which));
                                        }
                                    }
                                })
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String msg = "";
                                for (int i = 0; i < selectedItems.size(); i++) {
                                    msg = msg + "\n" + (i + 1) + " : " + Colors[ selectedItems.get(i)];
                                }
                                Toast.makeText(getApplicationContext(), "Total " + selectedItems.size() + " Items Selected.\n" + msg,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(MultipleChoiceDialogActivity.this,"No Option Selected",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}