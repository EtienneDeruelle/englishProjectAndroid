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

import Adapter.ThemeAdapter;
import Adapter.VocabularyAdapter;
import DataBase.VocabularyData;
import buisiness.Theme;
import buisiness.Vocabulary;

/**
 * Created by etienne on 21/04/17.
 */

public class VocabularyActivity extends AppCompatActivity {

    ListView mListView =null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        mListView = (ListView) findViewById(R.id.listViewVocabulary);
        Intent intent = getIntent();
        List<Vocabulary> vocabularies = genererVocabularies(intent.getIntExtra("idTheme",1));
        VocabularyAdapter adapter = new VocabularyAdapter(VocabularyActivity.this,0, vocabularies);
        mListView.setAdapter(adapter);


        final Button goodBye = (Button) findViewById(R.id.buttonGoogBye);
        //BOUTON QUIT
        goodBye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQ = new Intent(VocabularyActivity.this, VocabulariesActivity.class);
                startActivity(intentQ);
            }
        });

    }

    private List<Vocabulary> genererVocabularies(int idTheme){
        List<Vocabulary> voca = new ArrayList<Vocabulary>();
        VocabularyData vocdb = new VocabularyData(this);
        vocdb.open();
        voca = vocdb.getVocabularyByIdTheme(idTheme);
        vocdb.close();
        return voca;
    }

}
