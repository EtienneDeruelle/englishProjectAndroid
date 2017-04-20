package buisiness;

/**
 * Created by etienne on 21/04/17.
 */

public class Theme {

    private int idTheme;
    private String labelTheme;

    public Theme(int idTheme, String labelTheme) {
        this.idTheme = idTheme;
        this.labelTheme = labelTheme;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getLabelTheme() {
        return labelTheme;
    }

    public void setLabelTheme(String labelTheme) {
        this.labelTheme = labelTheme;
    }
}
