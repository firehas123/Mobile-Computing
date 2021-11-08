package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    //obects
    EditText question;
    TextView marks;
    TextView option1;
    TextView option2;
    TextView option3;
    TextView option4;
    TextView submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //initializing objects;
        question = findViewById(R.id.Question);
        marks = findViewById(R.id.Marks);
        option1 = findViewById(R.id.OptionOne);
        option2 = findViewById(R.id.OptionTwo);
        option3 = findViewById(R.id.OptionThree);
        option4 = findViewById(R.id.OptionFour);
        submit = findViewById(R.id.Submit);
        //removing keyboard from popping
        question.setFocusable(false);
       //adding options listener
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackgroundColor(Color.parseColor("#0000FF"));
                option2.setBackgroundColor(Color.parseColor("#000000"));
                option3.setBackgroundColor(Color.parseColor("#000000"));
                option4.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option2.setBackgroundColor(Color.parseColor("#0000FF"));
                option1.setBackgroundColor(Color.parseColor("#000000"));
                option3.setBackgroundColor(Color.parseColor("#000000"));
                option4.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option3.setBackgroundColor(Color.parseColor("#0000FF"));
                option2.setBackgroundColor(Color.parseColor("#000000"));
                option1.setBackgroundColor(Color.parseColor("#000000"));
                option4.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option4.setBackgroundColor(Color.parseColor("#0000FF"));
                option2.setBackgroundColor(Color.parseColor("#000000"));
                option3.setBackgroundColor(Color.parseColor("#000000"));
                option1.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
        // creatiing (makhārij al-ḥurūf) arrayList
        ArrayList<MyData>  obj = new ArrayList<MyData>();
        //adding the 17 emission points
        addData(obj);
        //fetching values from intent
        Intent intent = getIntent();
        String buttonPressedFromPreviousActivity = intent.getStringExtra("Button");
        if(buttonPressedFromPreviousActivity.equals("practise"))
                marks.setVisibility(View.INVISIBLE);
        else
                marks.setVisibility(View.VISIBLE);
        //fetchnig questions for the exam or practise;
        ArrayList<Question> questions = new ArrayList<Question>();
        ArrayList<Integer> randomMcqNumber = new ArrayList<Integer>();
        fetchQuestions(questions,obj);
        // five questions have been fetched now displaying on the screen
        final int[] questionNumber = {0};

        String temp = null;
        try {
            temp = new String(questions.get(questionNumber[0]).ob.word.getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        question.setText(   "This letter comes from which location " + "\"" +temp +"\"?");
        int answersIndex = questions.get(questionNumber[0]).index;
        fetchOptions(answersIndex,randomMcqNumber);
        option3.setText(obj.get(answersIndex).location);
        option1.setText(obj.get(randomMcqNumber.get(0)).location);
        option2.setText(obj.get(randomMcqNumber.get(1)).location);
        option4.setText(obj.get(randomMcqNumber.get(2)).location);
        questionNumber[0]++;
        int marksCount = 0;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable viewColor1 = (ColorDrawable) option1.getBackground();
                int colorOption1 = viewColor1.getColor();
                ColorDrawable viewColor2 = (ColorDrawable) option2.getBackground();
                int colorOption2 = viewColor2.getColor();
                ColorDrawable viewColor3 = (ColorDrawable) option3.getBackground();
                int colorOption3 = viewColor3.getColor();
                ColorDrawable viewColor4 = (ColorDrawable) option4.getBackground();
                int colorOption4 = viewColor4.getColor();
                if() {
                    if (questionNumber[0] < 5) {
                        //evaluating the answer then replacing the options with the new answers
                        if (questionNumber[0] == 4)
                            submit.setText("Finish");
                        //evaluation code

                        //
                        //replacing code
                        String arbicText = null;
                        try {
                            arbicText = new String(questions.get(questionNumber[0]).ob.word.getBytes(), "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        question.setText("This letter comes from which location " + "\"" + arbicText + "\"?");
                        int optionWithCorrectAnswer = new Random().nextInt(4);
                        int answersIndex = questions.get(questionNumber[0]).index;
                        fetchOptions(answersIndex, randomMcqNumber);
                        if (optionWithCorrectAnswer == 0) {
                            option1.setText(obj.get(answersIndex).location);
                            option2.setText(obj.get(randomMcqNumber.get(0)).location);
                            option3.setText(obj.get(randomMcqNumber.get(1)).location);
                            option4.setText(obj.get(randomMcqNumber.get(2)).location);
                        } else if (optionWithCorrectAnswer == 1) {
                            option2.setText(obj.get(answersIndex).location);
                            option1.setText(obj.get(randomMcqNumber.get(0)).location);
                            option3.setText(obj.get(randomMcqNumber.get(1)).location);
                            option4.setText(obj.get(randomMcqNumber.get(2)).location);
                        } else if (optionWithCorrectAnswer == 2) {
                            option3.setText(obj.get(answersIndex).location);
                            option2.setText(obj.get(randomMcqNumber.get(0)).location);
                            option1.setText(obj.get(randomMcqNumber.get(1)).location);
                            option4.setText(obj.get(randomMcqNumber.get(2)).location);
                        } else {
                            option4.setText(obj.get(answersIndex).location);
                            option2.setText(obj.get(randomMcqNumber.get(0)).location);
                            option3.setText(obj.get(randomMcqNumber.get(1)).location);
                            option1.setText(obj.get(randomMcqNumber.get(2)).location);
                        }

                        questionNumber[0]++;
                        //
                    } else {
                        // all Five questions have been taken
                        // if it's practise then take back to optionScreen activity
                        // if it's Exam then take back to acitivity where they can share their marks
                        if (intent.getStringExtra("Button").equals("practise")) {

                        } else {

                        }
                    }
                }
            }
        });
    }

    private void fetchOptions(int answersIndex, ArrayList<Integer> randomMcqNumber) {
        int temp = 0;
        while(randomMcqNumber.size()<3){
            temp = new Random().nextInt(14);
            if(!(answersIndex==temp)){
                //add it to option
                if(!(randomMcqNumber.contains(temp))){
                    randomMcqNumber.add(temp);
                }
            }
        }
    }

    private void fetchQuestions(ArrayList<Question> questions, ArrayList<MyData> obj) {
        int temp = 0;
        while(questions.size()<5){
            temp = new Random().nextInt(14);
            if(!(questions.contains(new Question(obj.get(temp),temp)))){
                //add it to question
                questions.add(new Question(obj.get(temp),temp));
            }
        }
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
class Question{
    MyData ob; //question
    int index; //index of arrayList
    public Question(MyData object,int i){
        this.ob=object;
        this.index=i;
    }
}