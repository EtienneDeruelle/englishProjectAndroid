package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import buisiness.Question;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView result = (TextView) findViewById(R.id.textView9);
        final TextView next = (TextView) findViewById(R.id.buttonNext);
        final Button QuitButton = (Button) findViewById(R.id.buttonQuit);
        final Button BoutonA = (Button) findViewById(R.id.buttonA);
        final Button BoutonB = (Button) findViewById(R.id.buttonB);
        final Button BoutonC = (Button) findViewById(R.id.buttonC);
        final Button BoutonD = (Button) findViewById(R.id.buttonD);
        final Button BoutonNext = (Button) findViewById(R.id.buttonNext);

        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(QuestionActivity.this, MenuActivity.class);
                startActivity(intentToeic);
            }
        });

        BoutonA.setOnClickListener(new View.OnClickListener() {
            // if (recupBonneReponse == "A")

                @Override
                public void onClick (View v){
                result.setText("Good answer");
                    next.setText("Next question");

                }

            //else { result.setText("Sorry, let's move on to the next question"); }

        });

        BoutonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(QuestionActivity.this, QuestionActivity.class);
                startActivity(intentToeic);
            }
        });



    }

    //je prend en compte qu'une question est liée à 4 réponses possibles et une bonne réponse

    String quest = "Diane ------ a meeting of the partners to discuss the merger situation.";
    String respA = "called";
    String respB = "claimed";
    String respC = "asked";
    String respD = "installed";
    @Override
    protected void onStart() {
        super.onStart();
        TextView question = (TextView) findViewById(R.id.textView4);
        TextView reponseA = (TextView) findViewById(R.id.textView5);
        TextView reponseB = (TextView) findViewById(R.id.textView6);
        TextView reponseC = (TextView) findViewById(R.id.textView7);
        TextView reponseD = (TextView) findViewById(R.id.textView8);

        // récupération d'une question
        //récupération de la réponse
        String bonneReponse = "C";


        question.setText(quest);
        reponseA.setText(respA);
        reponseB.setText(respB);
        reponseC.setText(respC);
        reponseD.setText(respD);
    }



}