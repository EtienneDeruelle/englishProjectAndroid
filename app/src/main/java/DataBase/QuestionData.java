package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;

import buisiness.Question;

/**
 * Created by etienne on 19/04/17.
 */

public class QuestionData {

    private SQLiteDatabase database;
    private DataBase dbHelper;

    public QuestionData(Context context){
        dbHelper = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    public void createQuestion(Question question){
        ContentValues values = new ContentValues();
        values.put("question",question.getQuestion());
        values.put("answer_A",question.getAnswerA());
        values.put("answer_B",question.getAnswerB());
        values.put("answer_C",question.getAnswerC());
        values.put("answer_D",question.getAnswerD());
        values.put("correct_answer",question.getCorrectAnswer());
        values.put("id_rule",question.getRule());
        database.insert("QUESTION",null,values);
    }

    public void deleteQuestion(Question question){
        int id = question.getIdQuestion();
        database.delete("QUESTION", "id_question = "+id, null);
    }

    public void deleteQuestionById(int id){
        database.delete("QUESTION", "id_question = "+id, null);
    }

    public Question getQuestionById(int id){
        Question question = null;
        String[] allColumns = {"id_question","question","answer_A","answer_B","answer_C","answer_D","correct_answer","id_rule"};
        Cursor cursor = database.query("QUESTION",allColumns,"id_question ="+id,null,null,null,null);
        cursor.moveToFirst();
        if(!cursor.isAfterLast()){
            question = new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7));
        }
        return question;
    }

    public Question getRandomQuestion(){
        ArrayList<Question> questions = new ArrayList<Question>();
        String[] allColumns = {"id_question","question","answer_A","answer_B","answer_C","answer_D","correct_answer","id_rule"};
        Cursor cursor = database.query("QUESTION",allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            questions.add(new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7)));
            cursor.moveToNext();
        }
        cursor.close();
        Random rand = new Random();
        int indexAleatoire = rand.nextInt(questions.size());
        return questions.get(indexAleatoire);
    }
}
