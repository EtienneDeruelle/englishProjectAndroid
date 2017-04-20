package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
