package com.example.etienne.englishtoeic_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import buisiness.Question;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView question = (TextView) findViewById(R.id.textView4);
        TextView reponseA = (TextView) findViewById(R.id.textView5);
        TextView reponseB = (TextView) findViewById(R.id.textView6);
        TextView reponseC = (TextView) findViewById(R.id.textView7);
        TextView reponseD = (TextView) findViewById(R.id.textView8);

        // récupération d'une question
        //Question interrogation =

        //question.setText();
    }
}
