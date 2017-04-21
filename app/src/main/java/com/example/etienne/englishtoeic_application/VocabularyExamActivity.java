package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import DataBase.StatData;
import DataBase.VocabularyData;
import buisiness.Vocabulary;

/**
 * Created by etienne on 21/04/17.
 */

public class VocabularyExamActivity extends AppCompatActivity {

    VocabularyData vd = new VocabularyData(this);
    int idTheme = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_vocabulary);
        this.idTheme = getIntent().getIntExtra("idTheme",0);
        System.out.println("id du theme en question : "+idTheme);

    //TOUS OBJETS A DEFINIR
        final Button boutonFrToEn = (Button) findViewById(R.id.butFrEn);
        final Button boutonEnToFr = (Button) findViewById(R.id.butEnFr);
        final Button boutonMenu = (Button) findViewById(R.id.button8);
        final Button boutonTheme = (Button) findViewById(R.id.butTheme);


        //BOUTON FRENCH TO ENGLISH
        boutonFrToEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamActivity.this, VocabularyExamFRtoENActivity.class);
                System.out.println("azrazeraezrezrazeraezraze : "+idTheme);
                intent.putExtra("idTheme",idTheme);
                startActivity(intent);
            }
        });

    //BOUTON ENGLISH TO FRENCH
        boutonEnToFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamActivity.this, VocabularyExamENtoFRActivity.class);
                intent.putExtra("idTheme",idTheme);
                startActivity(intent);
            }
        });


    //BOUTON BACK TO THEMES
        boutonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamActivity.this, VocabulariesActivity.class);
                startActivity(intent);
            }
        });


    //BOUTON BACK TO MENU
        boutonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });




    }
}
