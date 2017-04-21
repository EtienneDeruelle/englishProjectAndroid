package com.example.etienne.englishtoeic_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import DataBase.StatData;
import DataBase.VocabularyData;
import buisiness.Vocabulary;

/**
 * Created by etienne on 21/04/17.
 */

public class VocabularyExamENtoFRActivity extends AppCompatActivity {

    VocabularyData vd = new VocabularyData(this);
    StatData sd = new StatData(this);
    int idTheme = 0;

    public static int laOuJeSuis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_vocabulary_en_fr);
        this.idTheme = getIntent().getIntExtra("idTheme",1);

        //TOUS OBJETS A DEFINIR
        final Button boutonFrToEn = (Button) findViewById(R.id.butFrEn2);
        final Button boutonEnToFr = (Button) findViewById(R.id.butEnFr2);
        final Button boutonOk = (Button) findViewById(R.id.buttonOK2);
        final Button boutonNext = (Button) findViewById(R.id.butNext2);
        final Button boutonMenu = (Button) findViewById(R.id.button82);
        final Button boutonTheme = (Button) findViewById(R.id.butTheme2);

        final TextView mot1 = (TextView) findViewById(R.id.mot2);
        final TextView result = (TextView) findViewById(R.id.textView142);
        final TextView result2 = (TextView) findViewById(R.id.textView122);

        final EditText saisie = (EditText) findViewById(R.id.editText2);

        //TOUT CE QUI EST INVISIBLE AU DEBUT
        boutonNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        boutonEnToFr.setEnabled(false);
        boutonFrToEn.setEnabled(false);


        //TOUT RECUP QUESTION VOCABULAIRE
        vd.open();
        Intent intent = getIntent();
        final ArrayList<Vocabulary> listeVoca = vd.getVocabularyByIdTheme(getIdTheme());
        vd.close();
        sd.open();


        // ???
        final int tailleListeVoca = listeVoca.size();


        //MISE EN PLACE QUESTION DE VOCABULAIRE
        Vocabulary motDeVoca = listeVoca.get(laOuJeSuis);
        final String motFrancais = motDeVoca.getFrenchWord();
        final String motAnglais = motDeVoca.getEnglishWord();
        mot1.setText(motAnglais);



        //BOUTON FRENCH TO ENGLISH
        boutonFrToEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VocabularyExamFRtoENActivity test = new VocabularyExamFRtoENActivity();
                test.setLaOuJeSuis2(laOuJeSuis);
                Intent intent = new Intent(VocabularyExamENtoFRActivity.this, VocabularyExamFRtoENActivity.class);
                intent.putExtra("idTheme",getIdTheme());
                startActivity(intent);

            }
        });



        //BOUTON OK
        boutonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonOk.setEnabled(false);
                boutonFrToEn.setEnabled(true);

                //gestion réponse
                String reponseSaisie = saisie.getText().toString();

                if (reponseSaisie.contentEquals(motFrancais)) {
                    result.setText("Good answer !");
                    sd.goodAnswerVocabulary();
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + motFrancais);
                    sd.wrongAnswerVocabulary();
                    sd.close();
                }


                result.setVisibility(View.VISIBLE);
                saisie.setEnabled(false);

                // /*
                //gestion prochain mot
                laOuJeSuis = laOuJeSuis + 1;
                if(laOuJeSuis >= tailleListeVoca){
                    String tpn = "It was the last question for this theme !";
                    result2.setText(tpn);
                    boutonNext.setEnabled(false);
                    boutonOk.setEnabled(false);
                    boutonFrToEn.setEnabled(false);
                    laOuJeSuis = 0;


                }
                else {
                    boutonNext.setVisibility(View.VISIBLE);
                }
                // */
            }
        });

        //BOUTON NEXT QUESTION
        boutonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamENtoFRActivity.this, VocabularyExamENtoFRActivity.class);
                intent.putExtra("idTheme",getIdTheme());
                startActivity(intent);

            }
        });



        //BOUTON BACK TO THEMES
        boutonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamENtoFRActivity.this, VocabulariesActivity.class);
                startActivity(intent);
            }
        });



        //BOUTON BACK TO MENU
        boutonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamENtoFRActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });




    }

    public static void setLaOuJeSuis(int i) {
        laOuJeSuis = i;
    }
    public static int getLaOuJeSuis() {
        return laOuJeSuis;
    }
    public int getIdTheme(){return this.idTheme;}
}
