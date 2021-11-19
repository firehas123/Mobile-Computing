package com.example.assignmenttwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    //objects and variables
    EditText question;
    TextView marks;
    TextView option1;
    TextView option2;
    TextView option3;
    TextView option4;
    TextView submit;
    TextView testing;
    int marksCount = 0;
    int questionNumber = 0;
    int optionWithCorrectAnswer = 3;
    ArrayList<MyData>  Data = new ArrayList<MyData>(); //will store all the emission points
    ArrayList<Question> questions = new ArrayList<Question>(); //will store all five questions to be asked
    ArrayList<Integer> randomMcqNumber = new ArrayList<Integer>(); // random option for 1 mcq only
    boolean examButtonPressed = false;
    boolean isAnyOptionSelectedOrNot = false;
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
                //delete code
        testing = findViewById(R.id.Testing);
                // delete code
        //removing keyboard from popping up in this activity
        question.setFocusable(false);
        //code start
        //adding the 17 emission points
        addData(Data);
        //fetching values from intent
        Intent intent = getIntent();
        String buttonPressedFromPreviousActivity = intent.getStringExtra("Button");
        if(buttonPressedFromPreviousActivity.equals("practise")){
            marks.setVisibility(View.INVISIBLE);
            examButtonPressed = false;
        }

        else { // meaning exam button was pressed
            marks.setVisibility(View.VISIBLE);
            examButtonPressed = true;
        }
        if(savedInstanceState==null) {
            //fetching questions for the exam or practise;
            fetchQuestions(questions, Data);
            // now i need to select random options for mcq 1 then display it
            //getting indexes of random options
            fetchOptions(questions.get(questionNumber).index, randomMcqNumber);
            //displaying first mcq manually
            question.setText("This letter comes from which location " + questions.get(questionNumber).ob.word + " ?");
            option1.setText(Data.get(randomMcqNumber.get(0)).location);
            option2.setText(Data.get(randomMcqNumber.get(1)).location);
            option3.setText(Data.get(questions.get(questionNumber).index).location);
            option4.setText(Data.get(randomMcqNumber.get(2)).location);

            marks.setText("0/5");
        }
        else{
            marks.setText(savedInstanceState.get("MarksSaved").toString());
        }
        questionNumber++;
        //event handle of all the options
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnyOptionSelectedOrNot){
                    //option selected
                    isAnyOptionSelectedOrNot = true;
                    option1.setBackgroundColor(Color.parseColor("#0000FF"));
                    option2.setBackgroundColor(Color.parseColor("#000000"));
                    option3.setBackgroundColor(Color.parseColor("#000000"));
                    option4.setBackgroundColor(Color.parseColor("#000000"));
                    // checking if the selected option is corrected or not?
                    String correctAnswer = Data.get(questions.get(questionNumber-1).index).location;
                    if(option1.getText().equals(correctAnswer)){
                        //meaning correct option was selected
                        option1.setBackgroundColor(Color.parseColor("#00FF00"));
                        //increase marks
                        marksCount++;
                    }
                    else{
                        //wrong option was selected
                        if(option2.getText().equals(correctAnswer)){
                            option1.setBackgroundColor(Color.parseColor("#FF0000"));
                            option2.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        else if(option3.getText().equals(correctAnswer)){
                            option1.setBackgroundColor(Color.parseColor("#FF0000"));
                            option3.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        else{
                            option1.setBackgroundColor(Color.parseColor("#FF0000"));
                            option4.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnyOptionSelectedOrNot) {
                    //option selected
                    isAnyOptionSelectedOrNot = true;
                    option2.setBackgroundColor(Color.parseColor("#0000FF"));
                    option1.setBackgroundColor(Color.parseColor("#000000"));
                    option3.setBackgroundColor(Color.parseColor("#000000"));
                    option4.setBackgroundColor(Color.parseColor("#000000"));
                    // checking if the selected option is corrected or not?
                    String correctAnswer = Data.get(questions.get(questionNumber-1).index).location;
                    if (option2.getText().equals(correctAnswer)) {
                        //meaning correct option was selected
                        option2.setBackgroundColor(Color.parseColor("#00FF00"));
                        marksCount++;
                    } else {
                        //wrong option was selected
                        if (option1.getText().equals(correctAnswer)) {
                            option2.setBackgroundColor(Color.parseColor("#FF0000"));
                            option1.setBackgroundColor(Color.parseColor("#00FF00"));
                        } else if (option3.getText().equals(correctAnswer)) {
                            option2.setBackgroundColor(Color.parseColor("#FF0000"));
                            option3.setBackgroundColor(Color.parseColor("#00FF00"));
                        } else {
                            option2.setBackgroundColor(Color.parseColor("#FF0000"));
                            option4.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnyOptionSelectedOrNot) {
                    //option selected
                    isAnyOptionSelectedOrNot = true;
                    option3.setBackgroundColor(Color.parseColor("#0000FF"));
                    option2.setBackgroundColor(Color.parseColor("#000000"));
                    option1.setBackgroundColor(Color.parseColor("#000000"));
                    option4.setBackgroundColor(Color.parseColor("#000000"));
                    // checking if the selected option is corrected or not?
                    String correctAnswer = Data.get(questions.get(questionNumber-1).index).location;
                    if (option3.getText().equals(correctAnswer)) {
                        //meaning correct option was selected
                        option3.setBackgroundColor(Color.parseColor("#00FF00"));
                        marksCount++;
                    } else {
                        //wrong option was selected
                        if (option2.getText().equals(correctAnswer)) {
                            option3.setBackgroundColor(Color.parseColor("#FF0000"));
                            option2.setBackgroundColor(Color.parseColor("#00FF00"));
                        } else if (option1.getText().equals(correctAnswer)) {
                            option3.setBackgroundColor(Color.parseColor("#FF0000"));
                            option1.setBackgroundColor(Color.parseColor("#00FF00"));
                        } else {
                            option3.setBackgroundColor(Color.parseColor("#FF0000"));
                            option4.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnyOptionSelectedOrNot) {
                    //option selected
                    isAnyOptionSelectedOrNot = true;
                    option4.setBackgroundColor(Color.parseColor("#0000FF"));
                    option2.setBackgroundColor(Color.parseColor("#000000"));
                    option3.setBackgroundColor(Color.parseColor("#000000"));
                    option1.setBackgroundColor(Color.parseColor("#000000"));
                    // checking if the selected option is corrected or not?
                    String correctAnswer = Data.get(questions.get(questionNumber-1).index).location;
                    if (option4.getText().equals(correctAnswer)) {
                        //meaning correct option was selected
                        option4.setBackgroundColor(Color.parseColor("#00FF00"));
                        marksCount++;
                    } else {
                        //wrong option was selected
                        if (option2.getText().equals(correctAnswer)) {
                            option4.setBackgroundColor(Color.parseColor("#FF0000"));
                            option2.setBackgroundColor(Color.parseColor("#00FF00"));
                        } else if (option3.getText().equals(correctAnswer)) {
                            option4.setBackgroundColor(Color.parseColor("#FF0000"));
                            option3.setBackgroundColor(Color.parseColor("#00FF00"));
                        } else {
                            option4.setBackgroundColor(Color.parseColor("#FF0000"));
                            option1.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                    }
                }
            }
        });

        //event handler of the next button

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //first checking is any option selected or not?
                if(isAnyOptionSelectedOrNot) {
                    if(questionNumber< 5){
                        if (questionNumber == 4)
                            submit.setText("Finish");
                        //replacing the text with the new one
                        //Then we need to extract options randomly
                        fetchOptions(questions.get(questionNumber).index, randomMcqNumber);
                        //now replacing the question
                        question.setText("This letter comes from which location " + questions.get(questionNumber).ob.word + " ?");
                        //now replacing the options
                        optionWithCorrectAnswer = new Random().nextInt(4);
                        int answersIndex = questions.get(questionNumber).index;

                        if (optionWithCorrectAnswer == 0) {
                            option1.setText(Data.get(answersIndex).location);
                            option2.setText(Data.get(randomMcqNumber.get(0)).location);
                            option3.setText(Data.get(randomMcqNumber.get(1)).location);
                            option4.setText(Data.get(randomMcqNumber.get(2)).location);
                        } else if (optionWithCorrectAnswer == 1) {
                            option2.setText(Data.get(answersIndex).location);
                            option1.setText(Data.get(randomMcqNumber.get(0)).location);
                            option3.setText(Data.get(randomMcqNumber.get(1)).location);
                            option4.setText(Data.get(randomMcqNumber.get(2)).location);
                        } else if (optionWithCorrectAnswer == 2) {
                            option3.setText(Data.get(answersIndex).location);
                            option2.setText(Data.get(randomMcqNumber.get(0)).location);
                            option1.setText(Data.get(randomMcqNumber.get(1)).location);
                            option4.setText(Data.get(randomMcqNumber.get(2)).location);
                        } else {
                            option4.setText(Data.get(answersIndex).location);
                            option2.setText(Data.get(randomMcqNumber.get(0)).location);
                            option3.setText(Data.get(randomMcqNumber.get(1)).location);
                            option1.setText(Data.get(randomMcqNumber.get(2)).location);
                        }

                        // marks text field code
                        marks.setText(Integer.toString(marksCount)+ "/5");

                        questionNumber++; // count of questions
                        //resetting all the colours to default
                        resetColour(option1,option2,option3,option4);
                        isAnyOptionSelectedOrNot = false;
                    }
                    else{
                        // all Five questions have been taken
                        // if it's practise then take back to optionScreen activity
                        // if it's Exam then take back to activity where they can share their marks

                        if (examButtonPressed) {
                            //meaning user probably wants to share his answer hence go to share activity
                            Intent intent = new Intent(Quiz.this,Share.class);
                            intent.putExtra("Marks",Integer.toString(marksCount));
                            startActivity(intent);
                        } else {
                                //return to home screen
                            Intent intent = new Intent(Quiz.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
                else{
                    //no option was selected
                    Toast myToast = Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //saving state which are required
        outState.putString("MarksSaved",marks.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        marks.setText(savedInstanceState.get("MarksSaved").toString());
    }

    private void resetColour(TextView option1, TextView option2, TextView option3, TextView option4) {
        option4.setBackgroundColor(Color.parseColor("#000000"));
        option2.setBackgroundColor(Color.parseColor("#000000"));
        option3.setBackgroundColor(Color.parseColor("#000000"));
        option1.setBackgroundColor(Color.parseColor("#000000"));
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

    private void fetchQuestions(ArrayList<Question> questions, ArrayList<MyData> data) {
        int temp = 0; // for index of the data arraylist
        while(questions.size()<5){ //fetching all 5 questions to be asked
            temp = new Random().nextInt(14);
            if(!(questions.contains(new Question(data.get(temp),temp)))){
                //add it to question
                questions.add(new Question(data.get(temp),temp));
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