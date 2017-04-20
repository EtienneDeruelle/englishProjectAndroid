package buisiness;

/**
 * Created by etienne on 21/04/17.
 */

public class Vocabulary {

    private String englishWord;
    private String frenchWord;
    private int idTheme;

    public Vocabulary(String englishWord, String frenchWord, int idTheme) {
        this.englishWord = englishWord;
        this.frenchWord = frenchWord;
        this.idTheme = idTheme;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getFrenchWord() {
        return frenchWord;
    }

    public void setFrenchWord(String frenchWord) {
        this.frenchWord = frenchWord;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }
}
