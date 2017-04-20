package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import DataBase.QuestionData;

import DataBase.StatData;
import buisiness.Question;

public class QuestionActivity extends AppCompatActivity {

    QuestionData qd = new QuestionData(this);
    StatData sd = new StatData(this);

    String goodAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        qd.open();
        qd.addAllQuestions();

        sd.open();
        sd.createStat("question_number_answer");
        sd.createStat("question_number_good_answer");


        final TextView result = (TextView) findViewById(R.id.textView9);
        final TextView next = (TextView) findViewById(R.id.buttonNext);
        final Button QuitButton = (Button) findViewById(R.id.buttonQuit);
        final Button BoutonA = (Button) findViewById(R.id.buttonA);
        final Button BoutonB = (Button) findViewById(R.id.buttonB);
        final Button BoutonC = (Button) findViewById(R.id.buttonC);
        final Button BoutonD = (Button) findViewById(R.id.buttonD);
        final Button BoutonNext = (Button) findViewById(R.id.buttonNext);

        BoutonNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

    //BOUTON QUIT
        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(QuestionActivity.this, MenuActivity.class);
                startActivity(intentToeic);
                //sd.close();
            }
        });

     //BOUTON D
        BoutonD.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (goodAnswer.contentEquals("D")) {
                    //result.setText("Good answer !");
                    //sd.goodAnswerQuestion();
                    sd.upDateStat("question_number_answer", 2);
                    result.setText(Integer.toString(sd.getNumberAnswerQuestion()));
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + goodAnswer);
                    //sd.wrongAnswerQuestion();
                    sd.close();
                }

                next.setText("Next question");
                BoutonNext.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);

                BoutonA.setEnabled(false);
                BoutonB.setEnabled(false);
                BoutonC.setEnabled(false);
                BoutonD.setEnabled(false);
            }


        });

    //BOUTON C
        BoutonC.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (goodAnswer.contentEquals("C")) {
                    result.setText("Good answer !");
                    sd.goodAnswerQuestion();
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + goodAnswer);
                    sd.wrongAnswerQuestion();
                    sd.close();
                }

                next.setText("Next question");
                BoutonNext.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);

                BoutonA.setEnabled(false);
                BoutonB.setEnabled(false);
                BoutonC.setEnabled(false);
                BoutonD.setEnabled(false);
            }


        });

     //BOUTON B
        BoutonB.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (goodAnswer.contentEquals("B")) {
                    result.setText("Good answer !");
                    sd.goodAnswerQuestion();
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + goodAnswer);
                    sd.wrongAnswerQuestion();
                    sd.close();
                }

                next.setText("Next question");
                BoutonNext.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);

                BoutonA.setEnabled(false);
                BoutonB.setEnabled(false);
                BoutonC.setEnabled(false);
                BoutonD.setEnabled(false);
            }


        });

    //BOUTON A
        BoutonA.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (goodAnswer.contentEquals("A")) {
                    result.setText("Good answer !");
                    sd.goodAnswerQuestion();
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + goodAnswer);
                    sd.wrongAnswerQuestion();
                    sd.close();
                }

                next.setText("Next question");
                BoutonNext.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);

                BoutonA.setEnabled(false);
                BoutonB.setEnabled(false);
                BoutonC.setEnabled(false);
                BoutonD.setEnabled(false);
            }


        });


    //BOUTON NEXT
        BoutonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(QuestionActivity.this, QuestionActivity.class);
                startActivity(intentToeic);
                //sd.close();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView question = (TextView) findViewById(R.id.textView4);
        TextView reponseA = (TextView) findViewById(R.id.textView5);
        TextView reponseB = (TextView) findViewById(R.id.textView6);
        TextView reponseC = (TextView) findViewById(R.id.textView7);
        TextView reponseD = (TextView) findViewById(R.id.textView8);

        Question quest = qd.getRandomQuestion();
        qd.close();

        // récupération d'une question
        question.setText(quest.getQuestion());

        // récupération des réponses
        reponseA.setText(quest.getAnswerA());
        reponseB.setText(quest.getAnswerB());
        reponseC.setText(quest.getAnswerC());
        reponseD.setText(quest.getAnswerD());

        //récupération bonne réponse
        goodAnswer = quest.getCorrectAnswer();


    }

}