package com.example.qzquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private final String[][] questions = {
            {"Q1 What is the range of values that can be stored by int datatype in c?", "-(2^31) to (2^31)-1", "-256 to 255", "-(2^63) to (2^63)-1", "0 to (2^31)-1"},
            {"Q2 How is the 3rd element in an array accessed based on pointer notation?", "*a+3", "*(a+3)", "*(*a+3)", "&(a+3)"},
            {"Q3 How to declare a double-pointer in C?", "int *val", "int **val", "int &val", "int *&val"},
            {"Q4 Which of the following are correct file opening modes in C??", "r", "rb", "w", "all of the above"},
            {"Q5 What is the disadvantage of arrays in C?", "The amount of memory to be allocated should be before hand", "Element of an array can be accessed in constant time", "Element are stored in contiguous memory blocks","Multiple other data structure can be implemented using array"},
            {"Q6 Identify the correct extension of the user-defined header file in C++.", ".CPP", ".hg", ".h", ".hf"},
            {"Q7 Which of the following data type is supported in C++ but not in C?", "int", "double", "bool","float"},
            {"Q8 Identify the scope resolution operator.", ":", "::", "?", "None"},
            {"Q9 By which of the following can the if-else statement be replaced?", "Bitwise Operator", "Logical Operator", "Conditional Operator", "Arithmetic Operator"},
            {"Q10 Choose the correct option which is mandatory in a function.", "return_type", "parameters", "function_name", "both a and c"},
            {"Q11 Number of primitive data types in Java are?", "6", "7", "8", "9"},
            {"Q12 When is the object created with new keyword?", "At the run time", "At compile time", "Depends on the code", "None"},
            {"Q13 In which of the following is toString() method defined?", "java.lang.Object", "java.lang.string", "java.lang.util", "none"},
            {"Q14 Total constructor string class have?", "3", "7", "13", "20"},
            {"Q15 Identify the return type of a method that does not return any value.", "int ", "void", "char", "none"},
            {"Q16 What is the maximum length of a Python identifier?", "32", "16", "128", "No fixed Length is specified"},
            {"Q17 How is a code block indicated in Python?", "Bracket", "Key", "Indentation", "None of the above"},
            {"Q18 Which of the following statements are used in Exception Handling in Python?", "try", "except", "finally", "all of the above"},
            {"Q19 Which of the following types of loops are not supported in Python?", "for", "while", "do-while", "none of the above"},
            {"Q20 Which of the following functions converts date to corresponding time in Python?", "strptime", "strftime", "both a and b", "none of the above"}
    };
    private final String[] CorrectAns = {
            "-(2^31) to (2^31)-1",
            "*(a+3)",
            "int **val",
            "all of the above",
            "The amount of memory to be allocated should be before hand",
            ".h",
            "bool",
            "::",
            "Conditional Operator",
            "both a and c",
            "8",
            "At the run time",
            "java.lang.Object",
            "13",
            "void",
            "No fixed Length is specified",
            "Indentation",
            "all of the above",
            "do-while",
            "strptime"
    };
    int index=0;
    int score=0;
    Button b1,b2,b3,b4;
    TextView questionText;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        questionText=findViewById(R.id.question);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

        setQuestionAndChoice(index);

        b1.setOnClickListener(view -> checkAnswer(b1));
        b2.setOnClickListener(view -> checkAnswer(b2));
        b3.setOnClickListener(view -> checkAnswer(b3));
        b4.setOnClickListener(view -> checkAnswer(b4));
    }
    private void setQuestionAndChoice(int questionIndex) {
        questionText.setText(questions[questionIndex][0]);

        b1.setText(questions[questionIndex][1]);
        b2.setText(questions[questionIndex][2]);
        b3.setText(questions[questionIndex][3]);
        b4.setText(questions[questionIndex][4]);
    }
    private void checkAnswer(Button selectedButton) {

        String selectedAnswere = selectedButton.getText().toString();
        String correctAnswer=CorrectAns[index];
        if(selectedAnswere.equals(correctAnswer))
        {
            score++;
        }
        index++;
        if(index== questions.length)
        {
            Intent intent = new Intent(this, MainActivity3.class);
            intent.putExtra("score", score);
            startActivity(intent);
            index=0;
            score=0;
        }
        else
        {
            setQuestionAndChoice(index);
        }

    }
}