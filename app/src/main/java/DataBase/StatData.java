package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import buisiness.Rule;

/**
 * Created by etienne on 20/04/17.
 */

public class StatData {

    private SQLiteDatabase database;
    private DataBase dbHelper;

    public StatData(Context context){
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    public void createStat(String label){
        ContentValues values = new ContentValues();
        values.put("label_stat",label);
        database.insert("STAT",null,values);
    }

    public void upDateStat(String label, int number){
        ContentValues values = new ContentValues();
        values.put("number_stat",number);
        database.update("STAT",values,"label_stat = '"+label+"'",null);
    }

    public int getNumberStat(String label){
        String[] allColumns = {"label_stat","number_stat"};
        Cursor cursor = database.query("STAT",allColumns,"label_stat ='"+label+"'",null,null,null,null);
        cursor.moveToFirst();
        int numberOfStat=0;
        if(!cursor.isAfterLast()){
            numberOfStat = cursor.getInt(1);
        }

        return numberOfStat;
    }

    public void goodAnswerQuestion(){
        int numberOfAnswer = getNumberStat("question_number_answer")+1;
        int numberOfGoodAnswer = getNumberStat("question_number_good_answer")+1;
        upDateStat("question_number_answer",numberOfAnswer);
        upDateStat("question_number_good_answer",numberOfGoodAnswer);
    }

    public void wrongAnswerQuestion(){
        int numberOfAnswer = getNumberStat("question_number_answer")+1;
        upDateStat("question_number_answer",numberOfAnswer);
    }

    public void goodAnswerVocabulary(){
        int numberOfAnswer = getNumberStat("vocabulary_number_answer")+1;
        int numberOfGoodAnswer = getNumberStat("vocabulary_number_good_answer")+1;
        upDateStat("vocabulary_number_answer",numberOfAnswer);
        upDateStat("vocabulary_number_good_answer",numberOfGoodAnswer);
    }

    public void wrongAnswerVocabulary(){
        int numberOfAnswer = getNumberStat("vocabulary_number_answer")+1;
        upDateStat("vocabulary_number_answer",numberOfAnswer);
    }

    public int getNumberAnswerQuestion(){
        return getNumberStat("question_number_answer");
    }

    public int getNumberGoodAnswerQuestion(){
        return getNumberStat("question_number_good_answer");
    }

    public int getNumberAnswerVocabulary(){
        return getNumberStat("vocabulary_number_answer");
    }

    public int getNumberAnswerGoodVocabulary(){
        return getNumberStat("vocabulary_number_good_answer");
    }


}
