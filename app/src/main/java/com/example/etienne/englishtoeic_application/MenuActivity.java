package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import DataBase.VocabularyData;

/**
 * Created by etienne on 28/01/17.
 */

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Button ToeicButton = (Button) findViewById(R.id.button);
        final Button CourseButton = (Button) findViewById(R.id.button2);
        final Button StatButton = (Button) findViewById(R.id.button3);
        final Button VocButton = (Button) findViewById(R.id.buttonVoc);


        ToeicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToeic = new Intent(MenuActivity.this, QuestionActivity.class);
                startActivity(intentToeic);
            }
        });


        CourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCourse = new Intent(MenuActivity.this, CoursesActivity.class);
                startActivity(intentCourse);
            }
        });



        StatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStat = new Intent(MenuActivity.this, StatisticActivity.class);
                startActivity(intentStat);
            }
        });

        VocButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentVoc = new Intent(MenuActivity.this, VocabulariesActivity.class);
                startActivity(intentVoc);
            }
        });




    }


}
