package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import buisiness.Rule;
import buisiness.Theme;
import buisiness.Vocabulary;

/**
 * Created by etienne on 21/04/17.
 */

public class VocabularyData {

    private SQLiteDatabase database;
    private DataBase dbHelper;

    public VocabularyData(Context context){
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    public ArrayList<Theme> getAllTheme(){
        ArrayList<Theme> listTheme = new ArrayList<Theme>();
        String[] allColumns = {"id_theme","label_theme"};
        Cursor cursor = database.query("THEME",allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            listTheme.add(new Theme(cursor.getInt(0),cursor.getString(1)));
            cursor.moveToNext();
        }
        return listTheme;
    }

    public ArrayList<Vocabulary> getVocabularyByIdTheme(int id){
        ArrayList<Vocabulary> vocabularies = new ArrayList<Vocabulary>();
        String[] allColumns = {"english_word","french_word","id_theme"};
        Cursor cursor = database.query("VOCABULARY",allColumns,"id_theme ="+id,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            vocabularies.add(new Vocabulary(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        return vocabularies;
    }
}
