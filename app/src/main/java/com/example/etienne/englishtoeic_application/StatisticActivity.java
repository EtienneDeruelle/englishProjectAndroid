package com.example.etienne.englishtoeic_application;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import DataBase.StatData;


/**
 * Created by celesteallardi on 18/04/2017.
 */

public class StatisticActivity extends AppCompatActivity {

    StatData sd = new StatData(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        sd.open();

        final TextView textStat = (TextView) findViewById(R.id.statIntro);
        final TextView stat = (TextView) findViewById(R.id.stat);
        final TextView test = (TextView) findViewById(R.id.textView);
        final Button ButtonMenu = (Button) findViewById(R.id.buttonMenu);
        final TextView stat2 = (TextView) findViewById(R.id.stat2);
        final Button reset = (Button) findViewById(R.id.buttonReset);
        final TextView statVoc = (TextView) findViewById(R.id.statVoc);
        final TextView stat2voc = (TextView) findViewById(R.id.stat2Voc);

        stat.setVisibility(View.INVISIBLE);
        textStat.setText("Here you can see your statistics : \n \n Statistics for the TOEIC : ");

     //NOMBRE DE QUESTIONS REPONDUES
        final double nbrQ = sd.getNumberAnswerQuestion();
        final double goodRep = sd.getNumberGoodAnswerQuestion();
        final double nbrV = sd.getNumberAnswerVocabulary();
        final double goodVoc = sd.getNumberAnswerGoodVocabulary();
        sd.close();

        double nbr;
        if(nbrQ == 0){
            nbr=0;
            test.setText("You have to answer some questions to have more statistics !");
        }
        else{
            nbr = goodRep / nbrQ * 100;
            stat.setVisibility(View.VISIBLE);
            String strg = Double.toString(Math.round(goodRep/nbrQ*100)) + " % of good answer" ;
            stat.setText(strg);
            test.setVisibility(View.INVISIBLE);
        }


        /*
        double nbrV;
        if(nbrV == 0){
            nbr=0;
            test.setText("You have to answer some questions to have more statistics !");
        }
        else{
            nbr = goodVoc / nbrV * 100;
            stat.setVisibility(View.VISIBLE);
            String strg = Double.toString(Math.round(goodVoc/nbrV*100)) + " % of good answer" ;
            stat.setText(strg);
            test.setVisibility(View.INVISIBLE);
        }
         */


        //AFFICHAGE SANS FAUTE D'ORTHOGRAPHE
        if (nbrQ< 2) {
            stat2.setText(Double.toString(nbrQ) + " question answered");
        }
        else {
            stat2.setText(Double.toString(nbrQ) + " questions answered");
        }

        if (nbrV< 2) {
            stat2voc.setText(Double.toString(nbrV) + " question answered");
        }
        else {
            stat2voc.setText(Double.toString(nbrV) + " questions answered");
        }

        //BOUTON QUIT
        ButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentM = new Intent(StatisticActivity.this, MenuActivity.class);
                startActivity(intentM);
            }
        });


        //BOUTON REMISE A ZERO
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd.open();
                sd.upDateStat("question_number_answer", 0);
                sd.upDateStat("question_number_good_answer", 0);
                sd.close();
                Intent intentR = new Intent(StatisticActivity.this, StatisticActivity.class);
                startActivity(intentR);
            }
        });


    }
}
