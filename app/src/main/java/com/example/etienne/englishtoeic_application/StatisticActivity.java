package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by celesteallardi on 18/04/2017.
 */

public class StatisticActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        final TextView textStat = (TextView) findViewById(R.id.statIntro);
        final TextView stat = (TextView) findViewById(R.id.stat);
        final TextView test = (TextView) findViewById(R.id.textView);
        final Button ButtonMenu = (Button) findViewById(R.id.buttonMenu);

        stat.setVisibility(View.INVISIBLE);
        textStat.setText("Here you can see your statistics. \n Actually the only statistic is the percentage of good answer :");
        test.setText("You have to awser some questions to have statistics !");

        final double goodStat = QuestionActivity.getGood() / (QuestionActivity.getGood() + QuestionActivity.getBad()) * 100;
        if (goodStat>-1) {
            stat.setVisibility(View.VISIBLE);
            stat.setText(Double.toString(goodStat) + " %");
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
