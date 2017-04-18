package buisiness;

/**
 * Created by etienne on 17/04/17.
 */

public class Question {

    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private char correctAnswer;
    private int rule;

    public Question(String question, String answerA, String answerC, String answerB, String answerD, char correctAnswer, int rule) {
        this.question = question;
        this.answerA = answerA;
        this.answerC = answerC;
        this.answerB = answerB;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.rule = rule;
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

    public char getCorrectAnswer(){
        return correctAnswer;
    }

    public void setCorrectAnswer(char correctAnswer){
        this.correctAnswer=correctAnswer;
    }
}
