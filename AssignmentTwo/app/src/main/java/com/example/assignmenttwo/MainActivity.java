package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<MyData>  obj = new ArrayList<MyData>();
        //adding the 17 emission points
        addData(obj);
    }
    public void addData(ArrayList temp){
        temp.add(new MyData("أ ة","End of Throat")); //1
        temp.add(new MyData("ع ح","Middle of Throat")); //2
        temp.add(new MyData("غ خ","Start of Throat")); //3
        temp.add(new MyData("ق","Base of Tongue which is near Uvula touching the mouth roof")); //4
        temp.add(new MyData("ك","Portion of Tongue near its base touching the roof of mouth")); //5
        temp.add(new MyData("ج ش ى","Tongue touching the center of the mouth roof")); //6
        temp.add(new MyData("ض","One side of the tongue touching the molar teeth")); //7
        temp.add(new MyData("ل","Rounded tip of the tongue touching the base of the frontal 8 teeth")); //8
        temp.add(new MyData("ن","Rounded tip of the tongue touching the base of the frontal 6 teeth")); //9
        temp.add(new MyData("ر","Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth")); //10
        temp.add(new MyData("ط د ت","Tip of the tongue touching the base of the front 2 teeth")); //11
        temp.add(new MyData("ظ  ذ  ث","Tip of the tongue touching the tip of the frontal 2 teeth")); //12
        temp.add(new MyData("ص ز س","Tip of the tongue comes between the front top and bottom teeth")); //13
        temp.add(new MyData("م ن","While pronouncing the ending sound of  م  or ن , bring the vibration to the nose")); //14



    }
}
class MyData{
    String word,location;
    MyData(String wrd,String loc){ //paramenterized constructor
        this.word=wrd;
        this.location=loc;
    }
    MyData(){} //default constructor
}