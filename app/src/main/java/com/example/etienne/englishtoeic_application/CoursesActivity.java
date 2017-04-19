package com.example.etienne.englishtoeic_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.CourseAdapter;
import DataBase.RuleData;
import buisiness.Rule;

/**
 * Created by etienne on 18/04/17.
 */

public class CoursesActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);


        mListView = (ListView) findViewById(R.id.listView);
        List<Rule> rules = genererRules();
        CourseAdapter adapter = new CourseAdapter(CoursesActivity.this, rules);
        mListView.setAdapter(adapter);
    }

    private List<Rule> genererRules(){
        List<Rule> rules = new ArrayList<Rule>();
        RuleData ruledb = new RuleData(this);
        ruledb.open();
        rules = ruledb.getAllRule();
        ruledb.close();
        return rules;
    }


}
