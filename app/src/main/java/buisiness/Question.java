package buisiness;

/**
 * Created by etienne on 17/04/17.
 */

public class Question {

    private int idQuestion;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    private int rule;

    public Question(int idQuestion, String question, String answerA, String answerC, String answerB, String answerD, String correctAnswer, int rule) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.answerA = answerA;
        this.answerC = answerC;
        this.answerB = answerB;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.rule = rule;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer=correctAnswer;
    }
}
