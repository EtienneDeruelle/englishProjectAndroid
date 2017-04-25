package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by etienne on 01/03/17.
 */

public class DataBase extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "DBApp";
    public static final int version = 1 ;

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("creation db");

        db.execSQL("CREATE TABLE RULE (id_rule INTEGER PRIMARY KEY AUTOINCREMENT,tag_name VARCHAR(50) UNIQUE, rule TEXT, rule_translation TEXT)");

        db.execSQL("CREATE TABLE QUESTION (id_question INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT, answer_A VARCHAR(30), answer_B VARCHAR(30)" +
                ", answer_C VARCHAR(30), answer_D VARCHAR(30), correct_answer VARCHAR(1), id_rule INT,FOREIGN KEY (id_rule) REFERENCES RULE(id_rule))");

        db.execSQL("CREATE TABLE STAT (label_stat VARCHAR(30) UNIQUE, number_stat INTEGER DEFAULT 0)");

        db.execSQL("CREATE TABLE THEME (id_theme INTEGER PRIMARY KEY AUTOINCREMENT, label_theme VARCHAR(30))");

        db.execSQL("CREATE TABLE VOCABULARY (english_word VARCHAR(50) PRIMARY KEY, french_word VARCHAR(50), id_theme INTEGER, FOREIGN KEY (id_theme) REFERENCES THEME(id_theme))");

        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('question_number_answer')");
        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('question_number_good_answer')");
        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('vocabulary_number_answer')");
        db.execSQL("INSERT INTO STAT(label_stat) VALUES ('vocabulary_number_good_answer')");

        db.execSQL("INSERT INTO RULE VALUES (1,'3rd person','With he, she or it the verb must finish with the letter -s.', 'Au présent avec la 3ème personne du singulier, le verbe prend un -s.')");
        db.execSQL("INSERT INTO RULE VALUES (2,'present continuous','With the present continuous, the action is describe with the verb to be and an other verb witch finish with -ing.','Avec le présent continue, on conjugue le verbe avec -ing précédé du verbe to be.')");
        db.execSQL("INSERT INTO RULE VALUES (3,'present perfect','With the present perfect, is used the verb to have and the part participle of an other verb.','Avec le present perfect, on utilise le verbe to have suivie d''un verbe au participe passé. Le present perfect est utilisé pour décrire une action qui a des conséquences sur le présent ou une action toujours en cours.')");
        db.execSQL("INSERT INTO RULE VALUES (4,'past simple','The past simple is used for describe a past action or a habit in the past. The verbs are finish with -ed.', 'Le passé est utilisé pour décrire une action fini ou une habitude dans le passé. Les verbes finissent par -ed.')");
        db.execSQL("INSERT INTO RULE VALUES (5,'past continuous','The past continuous describes an action witch was ongoing in the past. We use the verb to be to the past and the current verb with -ing at the end.', 'Le passé continue est utilisé pour décrire une action qui était en cours dans le passé. On utilise le verbe to be au passé et le verbe courrant avec -ing  à la fin.')");


        db.execSQL("INSERT INTO QUESTION VALUES (1,'She ------ at the conservatory every monday.','dance','dances','is dancing','have danced','B',1)");
        db.execSQL("INSERT INTO QUESTION VALUES (2,'You are eating a burger. Where usually ------ you your junk food ?','bought','are buying','buy','buys','D',1)");
        db.execSQL("INSERT INTO QUESTION VALUES (3,'Every Friday, I eat fish. We are Friday at noon, so I ------ a fish.','eat','am eating','have eaten','am eat','B',2)");
        db.execSQL("INSERT INTO QUESTION VALUES (4,'Mike and Paul ------ football now.',' are playing','play','have played','plays','A',2)");
        db.execSQL("INSERT INTO QUESTION VALUES (5,'I''m not hungry. I ------ a burger.','have just eat','just eaten','have just eaten','am eating','C',3)");
        db.execSQL("INSERT INTO QUESTION VALUES (6,'The rock band is tired. They ------ all the night.','have played','played','has played','are playing','A',3)");
        db.execSQL("INSERT INTO QUESTION VALUES (7,'Yesterday, Alexander ------ to the museum.','went','goes','is going','gone','A',4)");
        db.execSQL("INSERT INTO QUESTION VALUES (8,'When I was in Ireland, I ------ to church each Saturday.','didn''t went','don''t go','don''t went','didn''t go','D',4)");
        db.execSQL("INSERT INTO QUESTION VALUES (9,'When you called me, I ------ with Paul.','danced','am dancing','was dancing','will dance','C',5)");
        db.execSQL("INSERT INTO QUESTION VALUES (10,'We ------ a chicken pepperoni during your yoga class of yesterday.','was cooking','were cooking','will cook','are cooking','B',5)");




        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (1, 'Weather')");
        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (2, 'Elections')");
        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (3, 'Qualities')");
        db.execSQL("INSERT INTO THEME(id_theme, label_theme) VALUES (4, 'Shortcomings')");

        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a thunderstorm', 'un orage')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'mild', 'doux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'unsettled', 'incertain')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a typhoon', 'un typhon')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'to shine', 'briller')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'fair weather', 'beau temps')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a cyclone', 'a cyclone')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a hit wave', 'une vague de chaleur')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a gust of wind', 'un coup de vent')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a hurricane', 'un ouragan')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a storm', 'une tempête')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a clap of thunder', 'un coup de tonnerre')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a flash of lightning', 'un éclair')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a shelter', 'un abris')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a lull', 'une accalmie')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a draught', 'un courant d''air')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'to whirl', 'tourbilloner')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a cloud', 'un nuage')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'cloudless', 'dégagé')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'damp', 'humide')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'wet', 'mouillé')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a rainbow', 'un arc-en-ciel')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a drop of rain', 'une goutte de pluie')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'the fog', 'le brouillard')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'to freeze', 'geler')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'snowflakes', 'des flocons de neige')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a snowball', 'une boule de neige')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'to melt', 'fondre')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'the hail', 'la grêle')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a flood', 'une inondation')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'the drizzle', 'la bruine')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'the mist', 'la brume')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a hailstone', 'un grêlon')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a snowfall', 'une chute de neige')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'the frost', 'le gel')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'cloudy', 'nuageux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'a scorching sun', 'un soleil de plomb')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (1, 'the climate', 'le climat')");
// +48 MOTS SUR WEATHER

        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a ballot', 'un vote')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a referendum', 'un référendum')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the general elections', 'les élections législatives')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a political party', 'un parti politique')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a candidate', 'un candidat')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'an election campaign', 'une campagne électorale')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a blank vote', 'un vote blanc')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the overall majority', 'la majorité absolue')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the polling booth', 'l''isoloir')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'an opinion poll', 'un sondage d''opinion')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a proxy vote', 'un vote par procuration')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the abstention rate', 'le taux d''abstention')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to vote', 'voter')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to go to the poll', 'se rendre aux urnes')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to stand as candidate', 'se porter candidat')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'an electoral roll', 'une liste électorale')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a ballot box', 'une urne électorale')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to cast a blank vote', 'voter blanc')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'an elector', 'un électeur')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the first ballot', 'le premier tour')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a voter card', 'une carte d''électeur')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to elect', 'élire')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the counting of votes', 'le dépouillement')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'an undecided voter', 'un électeur indécis')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the electoral fraud', 'la fraude électorale')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the registred voters', 'les électeurs inscrits')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to engage in tactical voting', 'voter utile')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a protest vote', 'un vote de protestation')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to run for office', 'se présenter à des élections')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a polling place', 'un bureau de vote')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'to make a speech', 'faire un discours')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'a ballot paper', 'un bulletin de vote')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the relative majority', 'la majorité relative')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (2, 'the turnout', 'la participation')");

//34 MOTS SUR ELECTIONS

        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'tolerant', 'tolérent')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'accurate', 'précis')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'conscientious', 'consciencieux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'daring', 'audacieux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'punctual', 'ponctuel')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'careful', 'soigneux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'polite', 'poli')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'faithful', 'fidèle')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'tactful', 'délicat')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'energetic', 'énergique')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'frank', 'franc')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'efficient', 'efficace')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'hard working', 'travailleur')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'wise', 'sage')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'unobtrusive', 'discret')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'helpful', 'serviable')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'intuitive', 'intuitif')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'cautious', 'prudent')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'skilful', 'adroit')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'brave', 'brave')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'reliable', 'digne de confiance')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'gifted', 'doué')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'generous', 'généreux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'patient', 'patient')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'ambitious', 'ambicieux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'tenacious', 'tenace')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'experienced', 'expérimenté')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'courageous', 'courageux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'dignified', 'digne')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'calm', 'calme')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'honest', 'honnête')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'painstaking', 'assidu')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'sensible', 'raisonnable')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (3, 'sensitive', 'sensible')");
//34 MOTS SUR QUALITIES


        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'contemptuous', 'méprisant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'touchy', 'susceptible')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'vain', 'vaniteux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'boisterous', 'turbulent')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'hypocritical', 'hypocrite')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'lazy', 'paresseux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'cheeky', 'effronté')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'stubborn', 'têtu')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'envious', 'envieux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'boastful', 'vantard')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'supercilious', 'hautain')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'harmful', 'malfaisant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'cruel', 'cruel')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'dishonest', 'malhonnête')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'shy', 'timide')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'idle', 'oisif')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'impolite', 'impolite')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'clumsy', 'maladroit')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'jealous', 'jaloux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'noisy', 'bruyant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'self-centered', 'égocentrique')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'insolent', 'insolent')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'miserly', 'avare')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'arrogant', 'arrogant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'sly', 'sournois')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'moody', 'lunatique')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'careless', 'insouciant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'inquisitive', 'curieux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'disobedient', 'désobéissant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'bold', 'intrépide')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'naughty', 'méchant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'selfish', 'égoïste')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'heartless', 'impitoyable')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'cowardly', 'lâche')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'disdainful', 'dédaigneux')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'haughty', 'hautain')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'silly', 'stupide')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'greedy', 'gourmant')");
        db.execSQL("INSERT INTO VOCABULARY(id_theme,english_word,french_word) VALUES (4, 'bossy', 'autoritaire')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public DataBase (Context context){
        super(context, DATABASE_NAME, null, version);
    }



}