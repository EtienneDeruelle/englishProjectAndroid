package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by etienne on 01/03/17.
 */

public class DataBase extends SQLiteOpenHelper{

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  .........");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public DataBase (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }



}
