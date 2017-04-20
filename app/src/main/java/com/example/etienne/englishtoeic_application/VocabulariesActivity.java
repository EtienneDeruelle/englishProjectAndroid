package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.CourseAdapter;
import Adapter.ThemeAdapter;
import DataBase.RuleData;
import DataBase.VocabularyData;
import buisiness.Rule;
import buisiness.Theme;

/**
 * Created by etienne on 21/04/17.
 */

public class VocabulariesActivity extends AppCompatActivity {

    ListView mListView =null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabularies);
        mListView = (ListView) findViewById(R.id.listViewVoc);
        List<Theme> themes = genererThemes();
        ThemeAdapter adapter = new ThemeAdapter(VocabulariesActivity.this,0, themes);
        mListView.setAdapter(adapter);


        final Button goodBye = (Button) findViewById(R.id.buttonGoogBye);
        //BOUTON QUIT
        goodBye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQ = new Intent(VocabulariesActivity.this, MenuActivity.class);
                startActivity(intentQ);
            }
        });

    }

    private List<Theme> genererThemes(){
        List<Theme> themes = new ArrayList<Theme>();
        VocabularyData vocdb = new VocabularyData(this);
        vocdb.open();
        themes = vocdb.getAllTheme();
        vocdb.close();
        return themes;
    }
}
