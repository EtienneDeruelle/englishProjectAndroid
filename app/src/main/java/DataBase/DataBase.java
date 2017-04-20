package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by etienne on 01/03/17.
 */

public class DataBase extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "DBApp";
    public static final int version = 1 ;


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("creation db");

        db.execSQL("CREATE TABLE RULE (id_rule INTEGER PRIMARY KEY AUTOINCREMENT,tag_name VARCHAR(50) UNIQUE, rule TEXT, rule_translation TEXT)");

        db.execSQL("CREATE TABLE QUESTION (id_question INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT, answer_A VARCHAR(30), answer_B VARCHAR(30)" +
                ", answer_C VARCHAR(30), answer_D VARCHAR(30), correct_answer VARCHAR(1), id_rule INT,FOREIGN KEY (id_rule) REFERENCES RULE(id_rule))");

        db.execSQL("CREATE TABLE STAT (label_stat VARCHAR(30) UNIQUE, number_stat INTEGER DEFAULT 0)");

        db.execSQL("CREATE TABLE THEME (id_theme INTEGER PRIMARY KEY AUTOINCREMENT, label_theme VARCHAR(30))");

        db.execSQL("CREATE TABLE VOCABULARY (english_word VARCHAR(50) PRIMARY KEY, french_word VARCHAR(50), id_theme INTEGER, FOREIGN KEY (id_theme) REFERENCES THEME(id_theme))");

        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (1,'weather')");
        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (2,'travel')");
        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (3,'company')");
        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (4,'history')");

        db.execSQL("INSERT INTO VOCABULARY(english_word,french_word,id_theme) VALUES ('weather forcast','prévision météo',1)");
        db.execSQL("INSERT INTO VOCABULARY(english_word,french_word,id_theme) VALUES ('sunny spell','éclaircie',1)");
        db.execSQL("INSERT INTO VOCABULARY(english_word,french_word,id_theme) VALUES ('tidal waves','raz-de-marré',1)");
        db.execSQL("INSERT INTO VOCABULARY(english_word,french_word,id_theme) VALUES ('warm','chaleur',1)");


        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('question_number_answer')");
        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('question_number_good_answer')");
        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('vocabulary_number_answer')");
        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('vocabulary_number_good_answer')");

        db.execSQL("INSERT INTO RULE VALUES (1,'haricot 2tante','la tante doit manger le haricot', 'the aunt must eat the bean')");
        db.execSQL("INSERT INTO RULE VALUES (2,'kung fu','The kung fu is a martial sport. It can be dangerous to pratice this sport.', 'Le kung fu est un sport de combat. Il peut etre dangeureux de pratiquer ce sport.')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public DataBase (Context context){
        super(context, DATABASE_NAME, null, version);
    }



}