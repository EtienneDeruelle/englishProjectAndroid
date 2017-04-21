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

public class VocabularyExamFRtoENActivity extends AppCompatActivity {

    VocabularyData vd = new VocabularyData(this);
    StatData sd = new StatData(this);

    private static int laOuJeSuis2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_vocabulary_fr_en);

        //sd.createStat("vocabulary_number_answer");
        //sd.createStat("vocabulary_number_good_answer");

    //TOUS OBJETS A DEFINIR
        final Button boutonFrToEn = (Button) findViewById(R.id.butFrEn1);
        final Button boutonEnToFr = (Button) findViewById(R.id.butEnFr1);
        final Button boutonOk = (Button) findViewById(R.id.buttonOK1);
        final Button boutonNext = (Button) findViewById(R.id.butNext1);
        final Button boutonMenu = (Button) findViewById(R.id.button81);
        final Button boutonTheme = (Button) findViewById(R.id.butTheme1);

        final TextView mot1 = (TextView) findViewById(R.id.mot1);
        final TextView result = (TextView) findViewById(R.id.textView141);
        final TextView result2 = (TextView) findViewById(R.id.textView121);

        final EditText saisie = (EditText) findViewById(R.id.editText1);

    //TOUT CE QUI EST INVISIBLE AU DEBUT
        boutonNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        boutonFrToEn.setEnabled(false);
        boutonEnToFr.setEnabled(false);


    //TOUT RECUP QUESTION VOCABULAIRE
        vd.open();
        final ArrayList<Vocabulary> listeVoca = vd.getVocabularyByIdTheme(1);
        vd.close();

        sd.open();


    // ???
        final int tailleListeVoca = listeVoca.size();






    //MISE EN PLACE QUESTION DE VOCABULAIRE
        Vocabulary motDeVoca = listeVoca.get(laOuJeSuis2);
        String motFrancais = motDeVoca.getFrenchWord();
        final String motAnglais = motDeVoca.getEnglishWord();
        mot1.setText(motFrancais);


    //BOUTON ENGLISH TO FRENCH
        boutonEnToFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VocabularyExamENtoFRActivity test = new VocabularyExamENtoFRActivity();
                test.setLaOuJeSuis(laOuJeSuis2);
                Intent intent = new Intent(VocabularyExamFRtoENActivity.this, VocabularyExamENtoFRActivity.class);
                startActivity(intent);

            }
        });


    //BOUTON OK
        boutonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonOk.setEnabled(false);
                boutonEnToFr.setEnabled(true);

                //gestion réponse
                String reponseSaisie = saisie.getText().toString();

                if (reponseSaisie.contentEquals(motAnglais)) {
                    result.setText("Good answer !");
                    sd.goodAnswerVocabulary();
                    sd.close();
                }
                else {
                    result.setText("Sorry, the right answer was " + motAnglais);
                    sd.wrongAnswerVocabulary();
                    sd.close();
                }


                result.setVisibility(View.VISIBLE);
                saisie.setEnabled(false);

            // /*
                //gestion prochain mot
                laOuJeSuis2 = laOuJeSuis2 + 1;
                if(laOuJeSuis2 >= tailleListeVoca){
                    String tpn = "It was the last question for this theme !";
                    result2.setText(tpn);
                    boutonNext.setEnabled(false);
                    boutonOk.setEnabled(false);
                    boutonEnToFr.setEnabled(false);
                    laOuJeSuis2 = 0;

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
                Intent intent = new Intent(VocabularyExamFRtoENActivity.this, VocabularyExamFRtoENActivity.class);
                startActivity(intent);

            }
        });



    //BOUTON BACK TO THEMES
        boutonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamFRtoENActivity.this, VocabulariesActivity.class);
                startActivity(intent);
            }
        });



    //BOUTON BACK TO MENU
        boutonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyExamFRtoENActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });




    }

    public static void setLaOuJeSuis2(int i) {
        laOuJeSuis2 = i;
    }
    public static int getLaOuJeSuis2() {
        return laOuJeSuis2;
    }
}
