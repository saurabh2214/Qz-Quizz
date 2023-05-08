package com.example.qzquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView t1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        t1 = findViewById(R.id.output);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int score = extras.getInt("score",0);
            t1.setText(String.valueOf(score));
        }
    }
}