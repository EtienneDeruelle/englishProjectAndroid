package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import buisiness.Rule;

/**
 * Created by etienne on 17/04/17.
 */

public class RuleData {

    private SQLiteDatabase database;
    private DataBase dbHelper;

    public RuleData(Context context){
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    public void createRule(Rule rule){
        ContentValues values = new ContentValues();
        values.put("tag_name",rule.getTagName());
        values.put("rule",rule.getRule());
        values.put("rule_translation",rule.getRuleTranslation());
        database.insert("RULE",null,values);
    }

    public void delete(Rule rule){
        int id = rule.getIdRule();
        database.delete("RULE", "id_rule = "+id, null);
    }

    public ArrayList<Rule> getAllRule(){
        ArrayList<Rule> rules = new ArrayList<Rule>();
        String[] allColumns = {"id_rule","tag_name","rule","rule_translation"};
        Cursor cursor = database.query("RULE",allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rules.add(new Rule(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        return rules;
    }

    public Rule getRuleById(int id){
        Rule rule = null;
        String[] allColumns = {"id_rule","tag_name","rule","rule_translation"};
        Cursor cursor = database.query("RULE",allColumns,"id_rule ="+id,null,null,null,null);
        cursor.moveToFirst();
        if(!cursor.isAfterLast()){
            rule= new Rule(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        }
        return rule;
    }
}
