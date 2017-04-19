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
