package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import DataBase.QuestionData;

import DataBase.RuleData;
import DataBase.StatData;
import buisiness.Question;

public class QuestionActivity extends AppCompatActivity {

    QuestionData qd = new QuestionData(this);
    StatData sd = new StatData(this);
    RuleData rd = new RuleData(this);
    Question question = null;

    String goodAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView question = (TextView) findViewById(R.id.textView4);
        TextView reponseA = (TextView) findViewById(R.id.textView5);
        TextView reponseB = (TextView) findViewById(R.id.textView6);
        TextView reponseC = (TextView) findViewById(R.id.textView7);
        TextView reponseD = (TextView) findViewById(R.id.textView8);

        qd.open();
        //qd.addAllQuestions();

        sd.open();
        rd.open();

        //sd.createStat("question_number_answer");
        //sd.createStat("question_number_good_answer");

        this.question = qd.getRandomQuestion();
        qd.close();

        // récupération d'une question
        question.setText(this.question.getQuestion());

        // récupération des réponses
        reponseA.setText(this.question.getAnswerA());
        reponseB.setText(this.question.getAnswerB());
        reponseC.setText(this.question.getAnswerC());
        reponseD.setText(this.question.getAnswerD());

        //récupération bonne réponse
        goodAnswer = this.question.getCorrectAnswer();

        final TextView result = (TextView) findViewById(R.id.textView9);
        final TextView next = (TextView) findViewById(R.id.buttonNext);
        final Button QuitButton = (Button) findViewById(R.id.buttonQuit);
        final Button BoutonA = (Button) findViewById(R.id.buttonA);
        final Button BoutonB = (Button) findViewById(R.id.buttonB);
        final Button BoutonC = (Button) findViewById(R.id.buttonC);
        final Button BoutonD = (Button) findViewById(R.id.buttonD);
        final Button BoutonNext = (Button) findViewById(R.id.buttonNext);
        final TextView lesson = (TextView) findViewById(R.id.textView10);

        BoutonNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

        // leçon de la question pas encore visible
        lesson.setText(rd.getRuleById(this.question.getRule()).getRule());
        lesson.setVisibility(View.INVISIBLE);
        rd.close();

    //BOUTON QUIT
        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(QuestionActivity.this, MenuActivity.class);
                startActivity(intentToeic);
            }
        });

     //BOUTON D
        BoutonD.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (goodAnswer.contentEquals("D")) {
                    result.setText("Good answer !");
                    sd.goodAnswerQuestion();
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + goodAnswer);
                    lesson.setVisibility(View.VISIBLE);
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
                    lesson.setVisibility(View.VISIBLE);
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
                    lesson.setVisibility(View.VISIBLE);
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
                    lesson.setVisibility(View.VISIBLE);
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
            }
        });

    }

}