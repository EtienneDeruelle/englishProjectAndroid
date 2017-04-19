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

    public void addAllQuestions() {

        final Question q = new Question(1, "Diane ------ a meeting of the partners to discuss the merger situation.", "installed", "called", "asked", "claimed", "B", 1);
        this.createQuestion(q);

        final Question q2 = new Question(2, "He is going to have to fly to Los Angeles, ------ he likes it or not.", "when", "nor", "only", "whether", "D", 1);
        this.createQuestion(q2);

        final Question q3 = new Question(3, "At lunch, he ------ eat at his desk than go out with us.", "would rather", "would prefer", "better", "would", "A", 1);
        this.createQuestion(q3);

        final Question q4 = new Question(4, "The executives in ------ management decided to go ahead with the buyout.", "old", "senior", "chief", "superior", "B", 1);
        this.createQuestion(q4);

    }



}
