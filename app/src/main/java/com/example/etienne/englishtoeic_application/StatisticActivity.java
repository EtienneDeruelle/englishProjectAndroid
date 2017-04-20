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

        stat.setVisibility(View.INVISIBLE);
        textStat.setText("Here you can see your statistics :");
        test.setText("You have to answer some questions to have more statistics !");

        final int nbrQ = sd.getNumberAnswerQuestion();

        if (nbrQ< 2) {
            stat2.setText(Integer.toString(nbrQ) + " question answered");
        }
        else {
            stat2.setText(Integer.toString(nbrQ) + " questions answered");
        }


        final int goodRep = sd.getNumberGoodAnswerQuestion();
        final double goodStat = goodRep / nbrQ * 100;

        if (goodStat>-1) {
            stat.setVisibility(View.VISIBLE);
            String strg = Double.toString(goodStat) + " % of good answer" ;
            stat.setText(strg);
            test.setVisibility(View.INVISIBLE);
        }

        //BOUTON QUIT
        ButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(StatisticActivity.this, MenuActivity.class);
                startActivity(intentToeic);
            }
        });




    }
}
