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

    public void deleteThemeById(int idTheme){
        database.delete("THEME", "id_theme = "+idTheme, null);
    }

    public void createTheme(int id_theme, String label_theme){
        ContentValues values = new ContentValues();
        values.put("id_theme",id_theme);
        values.put("label_theme", label_theme);
        database.insert("THEME",null,values);
    }

    public void createVoca(int id_theme, String english, String french){
        ContentValues values = new ContentValues();
        values.put("english_word", english);
        values.put("french_word", french);
        values.put("id_theme",id_theme);
        database.insert("VOCABULARY",null,values);
    }

    public void createAllTheme() {
        this.createTheme(1, "Weather");
        this.createTheme(2, "Elections");
        this.createTheme(3, "Qualities");
        this.createTheme(4, "Shortcomings");
    }

    public void createAllVoca() {
        this.createVoca(1, "a thunderstorm", "un orage");
        this.createVoca(1, "mild", "doux");
        this.createVoca(1, "unsettled", "incertain");
        this.createVoca(1, "a typhoon", "un typhon");
        this.createVoca(1, "to shine", "briller");
        this.createVoca(1, "fair weather", "beau temps");
        this.createVoca(1, "a cyclone", "a cyclone");
        this.createVoca(1, "a hit wave", "une vague de chaleur");
        this.createVoca(1, "a gust of wind", "un coup de vent");
        this.createVoca(1, "a hurricane", "un ouragan");
        this.createVoca(1, "a storm", "une tempête");
        this.createVoca(1, "a clap of thunder", "un coup de tonnerre");
        this.createVoca(1, "a flash of lightning", "un éclair");
        this.createVoca(1, "a shelter", "un abris");
        this.createVoca(1, "a lull", "une accalmie");
        this.createVoca(1, "a draught", "un courant d'air");
        this.createVoca(1, "to whirl", "tourbilloner");
        this.createVoca(1, "a cloud", "un nuage");
        this.createVoca(1, "cloudless", "dégagé");
        this.createVoca(1, "damp", "humide");
        this.createVoca(1, "wet", "mouillé");
        this.createVoca(1, "a rainbow", "un arc-en-ciel");
        this.createVoca(1, "a drop of rain", "une goutte de pluie");
        this.createVoca(1, "the fog", "le brouillard");
        this.createVoca(1, "to freeze", "geler");
        this.createVoca(1, "snowflakes", "des flocons de neige");
        this.createVoca(1, "a snowball", "une boule de neige");
        this.createVoca(1, "to melt", "fondre");
        this.createVoca(1, "the hail", "la grêle");
        this.createVoca(1, "a flood", "une inondation");
        this.createVoca(1, "the drizzle", "la bruine");
        this.createVoca(1, "the mist", "la brume");
        this.createVoca(1, "a hailstone", "un grêlon");
        this.createVoca(1, "a snowfall", "une chute de neige");
        this.createVoca(1, "the frost", "le gel");
        this.createVoca(1, "cloudy", "nuageux");
        this.createVoca(1, "a scorching sun", "un soleil de plomb");
        this.createVoca(1, "the climate", "le climat");
// +48 MOTS SUR WEATHER

        this.createVoca(2, "a ballot", "un vote");
        this.createVoca(2, "a referendum", "un référendum");
        this.createVoca(2, "the general elections", "les élections législatives");
        this.createVoca(2, "a political party", "un parti politique");
        this.createVoca(2, "a candidate", "un candidat");
        this.createVoca(2, "an election campaign", "une campagne électorale");
        this.createVoca(2, "a blank vote", "un vote blanc");
        this.createVoca(2, "the overall majority", "la majorité absolue");
        this.createVoca(2, "the polling booth", "l'isoloir");
        this.createVoca(2, "an opinion poll", "un sondage d'opinion");
        this.createVoca(2, "a proxy vote", "un vote par procuration");
        this.createVoca(2, "the abstention rate", "le taux d'abstention");
        this.createVoca(2, "to vote", "voter");
        this.createVoca(2, "to go to the poll", "se rendre aux urnes");
        this.createVoca(2, "to stand as candidate", "se porter candidat");
        this.createVoca(2, "an electoral roll", "une liste électorale");
        this.createVoca(2, "a ballot box", "une urne électorale");
        this.createVoca(2, "to cast a blank vote", "voter blanc");
        this.createVoca(2, "an elector", "un électeur");
        this.createVoca(2, "the first ballot", "le premier tour");
        this.createVoca(2, "a voter card", "une carte d'électeur");
        this.createVoca(2, "to elect", "élire");
        this.createVoca(2, "the counting of votes", "le dépouillement");
        this.createVoca(2, "an undecided voter", "un électeur indécis");
        this.createVoca(2, "the electoral fraud", "la fraude électorale");
        this.createVoca(2, "the registred voters", "les électeurs inscrits");
        this.createVoca(2, "to engage in tactical voting", "voter utile");
        this.createVoca(2, "a protest vote", "un vote de protestation");
        this.createVoca(2, "to run for office", "se présenter à des élections");
        this.createVoca(2, "a polling place", "un bureau de vote");
        this.createVoca(2, "to make a speech", "faire un discours");
        this.createVoca(2, "a ballot paper", "un bulletin de vote");
        this.createVoca(2, "the relative majority", "la majorité relative");
        this.createVoca(2, "the turnout", "la participation");

//34 MOTS SUR ELECTIONS

        this.createVoca(3, "tolerant", "tolérent");
        this.createVoca(3, "accurate", "précis");
        this.createVoca(3, "conscientious", "consciencieux");
        this.createVoca(3, "daring", "audacieux");
        this.createVoca(3, "punctual", "ponctuel");
        this.createVoca(3, "careful", "soigneux");
        this.createVoca(3, "polite", "poli");
        this.createVoca(3, "faithful", "fidèle");
        this.createVoca(3, "tactful", "délicat");
        this.createVoca(3, "energetic", "énergique");
        this.createVoca(3, "frank", "franc");
        this.createVoca(3, "efficient", "efficace");
        this.createVoca(3, "hard working", "travailleur");
        this.createVoca(3, "wise", "sage");
        this.createVoca(3, "unobtrusive", "discret");
        this.createVoca(3, "helpful", "serviable");
        this.createVoca(3, "intuitive", "intuitif");
        this.createVoca(3, "cautious", "prudent");
        this.createVoca(3, "skilful", "adroit");
        this.createVoca(3, "brave", "brave");
        this.createVoca(3, "reliable", "digne de confiance");
        this.createVoca(3, "gifted", "doué");
        this.createVoca(3, "generous", "généreux");
        this.createVoca(3, "patient", "patient");
        this.createVoca(3, "ambitious", "ambicieux");
        this.createVoca(3, "tenacious", "tenace");
        this.createVoca(3, "experienced", "expérimenté");
        this.createVoca(3, "courageous", "courageux");
        this.createVoca(3, "dignified", "digne");
        this.createVoca(3, "calm", "calme");
        this.createVoca(3, "honest", "honnête");
        this.createVoca(3, "painstaking", "assidu");
        this.createVoca(3, "sensible", "raisonnable");
        this.createVoca(3, "sensitive", "sensible");
//34 MOTS SUR QUALITIES


        this.createVoca(4, "contemptuous", "méprisant");
        this.createVoca(4, "touchy", "susceptible");
        this.createVoca(4, "vain", "vaniteux");
        this.createVoca(4, "boisterous", "turbulent");
        this.createVoca(4, "hypocritical", "hypocrite");
        this.createVoca(4, "lazy", "paresseux");
        this.createVoca(4, "cheeky", "effronté");
        this.createVoca(4, "stubborn", "têtu");
        this.createVoca(4, "envious", "envieux");
        this.createVoca(4, "boastful", "vantard");
        this.createVoca(4, "supercilious", "hautain");
        this.createVoca(4, "harmful", "malfaisant");
        this.createVoca(4, "cruel", "cruel");
        this.createVoca(4, "dishonest", "malhonnête");
        this.createVoca(4, "shy", "timide");
        this.createVoca(4, "idle", "oisif");
        this.createVoca(4, "impolite", "impolite");
        this.createVoca(4, "clumsy", "maladroit");
        this.createVoca(4, "jealous", "jaloux");
        this.createVoca(4, "noisy", "bruyant");
        this.createVoca(4, "self-centered", "égocentrique");
        this.createVoca(4, "insolent", "insolent");
        this.createVoca(4, "miserly", "avare");
        this.createVoca(4, "arrogant", "arrogant");
        this.createVoca(4, "sly", "sournois");
        this.createVoca(4, "moody", "lunatique");
        this.createVoca(4, "careless", "insouciant");
        this.createVoca(4, "inquisitive", "curieux");
        this.createVoca(4, "disobedient", "désobéissant");
        this.createVoca(4, "bold", "intrépide");
        this.createVoca(4, "naughty", "méchant");
        this.createVoca(4, "selfish", "égoïste");
        this.createVoca(4, "heartless", "impitoyable");
        this.createVoca(4, "cowardly", "lâche");
        this.createVoca(4, "disdainful", "dédaigneux");
        this.createVoca(4, "haughty", "hautain");
        this.createVoca(4, "silly", "stupide");
        this.createVoca(4, "greedy", "gourmant");
        this.createVoca(4, "bossy", "autoritaire");

//40 MOTS SUR Shortcomings


    }

}
