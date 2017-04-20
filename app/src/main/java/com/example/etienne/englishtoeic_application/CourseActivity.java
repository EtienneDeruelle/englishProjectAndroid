package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import DataBase.RuleData;
import buisiness.Rule;

/**
 * Created by etienne on 18/04/17.
 */

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        final Button menuBut = (Button) findViewById(R.id.butMenu);

    //BOUTON QUIT
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentM = new Intent(CourseActivity.this, MenuActivity.class);
                startActivity(intentM);
            }
        });


        final Button lessonButton = (Button) findViewById(R.id.buttonBack);

    //BOUTON RETOUR LECON
        lessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentL = new Intent(CourseActivity.this, CoursesActivity.class);
                startActivity(intentL);
            }
        });
}

    @Override
    public void onStart(){
        super.onStart();
        TextView tagNameT = (TextView) findViewById(R.id.textView1);
        TextView ruleT = (TextView) findViewById(R.id.textView2);
        TextView ruleTranslationT = (TextView) findViewById(R.id.textView3);

        // récupération de la règle
        Intent intent = getIntent();
        int lessonNumber = intent.getIntExtra("numberLesson",1);
        RuleData ruledb = new RuleData(this);
        ruledb.open();
        Rule rule = ruledb.getRuleById(lessonNumber);
        ruledb.close();

        tagNameT.setText(rule.getTagName());
        ruleT.setText(rule.getRule());
        ruleTranslationT.setText(rule.getRuleTranslation());

    }
}
