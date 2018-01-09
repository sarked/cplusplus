package com.example.sarked.textquest;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBConnection extends SQLiteOpenHelper {
    public static String ROOMS_TABLE_NAME="rooms";
    public static String ROOMS_WAY="rooms";
    public static String ROOMS_TEXT="text";
    public static String ROOMS_VAR_A="var_a";
    public static String ROOMS_VAR_B="var_b";
    public static String ROOMS_VAR_A_WAY="var_a_way";
    public static String ROOMS_VAR_B_WAY="var_b_way";
    public static String ROOMS_VAR_A_PRICE="var_a_price";
    public static String ROOMS_VAR_B_PRICE="var_b_price";

    public DBConnection (Context ctx){
        super (ctx, "db_name",null,1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ROOMS_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +ROOMS_WAY+" TEXT,"
                +ROOMS_TEXT+" TEXT,"
                +ROOMS_VAR_A+" TEXT,"
                +ROOMS_VAR_A_WAY+" TEXT,"
                +ROOMS_VAR_A_PRICE+" INTEGER,"
                +ROOMS_VAR_B+" TEXT,"
                +ROOMS_VAR_B_WAY+" TEXT,"
                +ROOMS_VAR_B_PRICE+" INTEGER)");

        ContentValues cv =new ContentValues();

        cv.put(ROOMS_WAY,"001");
        cv.put(ROOMS_TEXT,"Вы просыпаетесь в своей постели, сладко потягиваясь. Пытаетесь вспомнить что вам снилось, но сон убегает, как пляжный песок просачивается сквозь пальцы. Ну да и не важно. Солнце светит сквозь зашторенные занавески намекая на то, что пора бы и подняться. Давай, тебя столько ждет сегодня!");
        cv.put(ROOMS_VAR_A,"Встать с левой ноги");
        cv.put(ROOMS_VAR_A_WAY,"a01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Встать с правой ноги");
        cv.put(ROOMS_VAR_B_WAY,"b91");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"a01");
        cv.put(ROOMS_TEXT,"Вы идете на кухню и завариваете себе тот приятный чай из мышиной требухи, что посоветовал вам коллега по религии. Так чем бы сегодня заняться? Можно пойти на работу, там наверняка куча дел, а можно заняться чем-нибудь на благо общества. Агитацией, например!");
        cv.put(ROOMS_VAR_A,"Пойти на работу");
        cv.put(ROOMS_VAR_A_WAY,"b01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Займемся просвещением");
        cv.put(ROOMS_VAR_B_WAY,"a11");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"b01");
        cv.put(ROOMS_TEXT,"Хорошенько позавтракав вы отправляетесь на работу. Вы не особо любите свою работу - тухнуть по 8 часов в офисе то ещё удовольствие. Однако сегодня шеф разрешил уйти пораньше, когда суточная норма прибыли будет выполнена. У вас появилась мысль открыть кассу и досрочно закрыть план из своего кошелька. Небольшие деньги, зато весь день будете свободны! Или же остается честно отработать рабочий день.");
        cv.put(ROOMS_VAR_A,"Закинуть в кассу (150 золотых)");
        cv.put(ROOMS_VAR_A_WAY,"d01");
        cv.put(ROOMS_VAR_A_PRICE,150);
        cv.put(ROOMS_VAR_B,"Отсидеть полный день (+20 золота)");
        cv.put(ROOMS_VAR_B_WAY,"d01");
        cv.put(ROOMS_VAR_B_PRICE,-20);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"a11");
        cv.put(ROOMS_TEXT,"Хорошенько позавтракав вы решаете сегодня заняться агитацией своего религиозного кружка. Можно потратить немного денег на то, чтобы распечатать пачку листовок, да развесить их тут и там, а можно пойти по домам, чтобы найти новых соверников и может быть заработать немного денег.");
        cv.put(ROOMS_VAR_A,"Распространение листовок (70 золотых)");
        cv.put(ROOMS_VAR_A_WAY,"a21");
        cv.put(ROOMS_VAR_A_PRICE,70);
        cv.put(ROOMS_VAR_B,"Пойду по домам");
        cv.put(ROOMS_VAR_B_WAY,"a31");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"a31");
        cv.put(ROOMS_TEXT,"Надев свой самый лучший костюмчик вы отправились на местную улицу богачей. Им не жалко будет растаться с какой-нибудь мелочью для благого дела. В первом дома вам открывает милая старушка с янтарными бусами. Сначала она думает, что вы её внук и называет ласковым именем Жорик, но потом извиняется и выслушивает вашу просьбу...");
        cv.put(ROOMS_VAR_A,"Пожертвуйте на храм 30 золота");
        cv.put(ROOMS_VAR_A_WAY,"c01");
        cv.put(ROOMS_VAR_A_PRICE,-30);
        cv.put(ROOMS_VAR_B,"Пожертвуйте на храм 1 золота");
        cv.put(ROOMS_VAR_B_WAY,"c02");
        cv.put(ROOMS_VAR_B_PRICE,-1);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"c01");
        cv.put(ROOMS_TEXT,"Получив от бабули щедрое подношение вы решаете больше не мучать её рассказами о вашей маленькой секте, а пойти по своим делам.");
        cv.put(ROOMS_VAR_A,"Да хранит вас дедушка Нургл");
        cv.put(ROOMS_VAR_A_WAY,"d01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Спасибо, до свидания");
        cv.put(ROOMS_VAR_B_WAY,"d01");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"c02");
        cv.put(ROOMS_TEXT,"Рассказав бабке о разнице между всеми богами Хаоса вы получаете свою заслуженную монетку. Вспомнив про странное поведение бабушки вначале вашего разговора закрадывается мысль о возможном склерозе юной леди. Может быть попросить у неё еще?");
        cv.put(ROOMS_VAR_A,"А пожертвуйте на трон Кхорну 1 золота");
        cv.put(ROOMS_VAR_A_WAY,"c23");
        cv.put(ROOMS_VAR_A_PRICE,-1);
        cv.put(ROOMS_VAR_B,"Спасибо, всё пойдет во благо высшего замысла божьего");
        cv.put(ROOMS_VAR_B_WAY,"c01");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"c23");
        cv.put(ROOMS_TEXT,"Рассказав бабке о черепах для трона черепов вы получаете свою заслуженную монетку. Может быть ещё раз проканает?");
        cv.put(ROOMS_VAR_A,"А пожертвуйте на храм Нурглу 1 золота");
        cv.put(ROOMS_VAR_A_WAY,"c02");
        cv.put(ROOMS_VAR_A_PRICE,-1);
        cv.put(ROOMS_VAR_B,"Остановиться");
        cv.put(ROOMS_VAR_B_WAY,"c01");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"d01");
        cv.put(ROOMS_TEXT,"Это был воистину адский день. Вы очень устали и ничего не хотите больше, чем пойти домой.");
        cv.put(ROOMS_VAR_A,"Глаза смыкаются");
        cv.put(ROOMS_VAR_A_WAY,"f05");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Как же хочется спать");
        cv.put(ROOMS_VAR_B_WAY,"f05");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"b91");
        cv.put(ROOMS_TEXT,"Заварив кружечку хорошего кофе и прочтя молитву Слаанеш вы задумываетесь чем бы заняться сегодня: можно пойти на работу, а можно просто прогуляться по городу для своего удовольствия");
        cv.put(ROOMS_VAR_A,"Побатрачить немного");
        cv.put(ROOMS_VAR_A_WAY,"b01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Отправлюсь на прогулку");
        cv.put(ROOMS_VAR_B_WAY,"e01");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"e01");
        cv.put(ROOMS_TEXT,"Идя по улице вы замечаете на тротуаре немощную женщину в платке. В вас просыпается непреодолимое желание...");
        cv.put(ROOMS_VAR_A,"Перевести бабку через дорогу");
        cv.put(ROOMS_VAR_A_WAY,"f01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Толкнуть старую под грузовик");
        cv.put(ROOMS_VAR_B_WAY,"f03");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"a21");
        cv.put(ROOMS_TEXT,"Распечатав тысячу листов с молитвой Тзинчу вы заклеили тысячи объявлений гадалок, колдунов, настройщиков интернета и прочих шарлатанов.");
        cv.put(ROOMS_VAR_A,"Фух");
        cv.put(ROOMS_VAR_A_WAY,"d01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Не легко быть исправным культистом");
        cv.put(ROOMS_VAR_B_WAY,"d01");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"f01");
        cv.put(ROOMS_TEXT,"Вы подбегаете к бабуле и услужливо подаете руку старой женщине. Она сначала смущается, а потом соглашается на ваше предложение помощи. Пройдя опасный участок вы останавливаетесь, а женщина поворачивается к вам, чтобы отблагодарить. Впервые увидев её лицо вы замечаете квадратные небольшие, но довольно густые усики. Только через несколько секунд до вас доходит, что вы помогли Гитлеру, который скрывался под видом беспомощной старушки.");
        cv.put(ROOMS_VAR_A,"Взять автограф");
        cv.put(ROOMS_VAR_A_WAY,"f04");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Толкнуть нациста под грузовик");
        cv.put(ROOMS_VAR_B_WAY,"f03");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"f04");
        cv.put(ROOMS_TEXT,"Гитлер с радостью выполняет вашу просьбу - расписаться на груди. Не так часто он встречает человека, который не стремится его убить. В приподнятом настроении вы отправляетесь домой.");
        cv.put(ROOMS_VAR_A,"Неделю мыться не буду");
        cv.put(ROOMS_VAR_A_WAY,"f05");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Позвоню тетушке - ни за что не поверит");
        cv.put(ROOMS_VAR_B_WAY,"f05");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"f03");
        cv.put(ROOMS_TEXT,"Вы толкаете жертву обстоятельств под проезжающий грузовик. Не то место, не то время, прости. Может быть в другой день всё произошло бы иначе. А сегодня - еще одна жертва кровавому богу.");
        cv.put(ROOMS_VAR_A,"Мрачно пойти домой");
        cv.put(ROOMS_VAR_A_WAY,"f05");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Радостно пойти домой");
        cv.put(ROOMS_VAR_B_WAY,"f05");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"f05");
        cv.put(ROOMS_TEXT,"Закрыв за собой дверь вы оказываетесь в тихой и уютной своей квартире. Единственное чего вы хотите - упасть на кровать и заснуть. Но перед сном нужно обязательно...");
        cv.put(ROOMS_VAR_A,"Помолиться");
        cv.put(ROOMS_VAR_A_WAY,"g01");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Утолить голод");
        cv.put(ROOMS_VAR_B_WAY,"g02");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"g01");
        cv.put(ROOMS_TEXT,"Отодвинув шторку в спальне вы открываете нишу с небольшим алтарем. После того, как вы зажгли свечи вы читаете короткую молитву о милостыне божьей...");
        cv.put(ROOMS_VAR_A,"Кхорну");
        cv.put(ROOMS_VAR_A_WAY,"g03");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Нурглу");
        cv.put(ROOMS_VAR_B_WAY,"g03");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"g02");
        cv.put(ROOMS_TEXT,"Этого никак нельзя забывать - ежедневная жертва богу хаоса, дабы утолить его голод. Что же сделать, помастурбировать во славу Слаанешу или практиковать магию для Тзинча.");
        cv.put(ROOMS_VAR_A,"Порно с конями");
        cv.put(ROOMS_VAR_A_WAY,"g03");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Черная магия");
        cv.put(ROOMS_VAR_B_WAY,"g03");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

        cv.put(ROOMS_WAY,"g03");
        cv.put(ROOMS_TEXT,"Сразу после необходимых приготовлений вы проваливаетесь в сон. Вам снятся ветра хаоса, в которых кружатся души обезумевших культистов, а также страхи и надежды всех людей. То тут, то там снуют бестелесные демоны, которые готовы выхватить вас из потока и полакомиться свежей плотью. Вам пока везет, если можно назвать везением пребывание в варпе. Вы оказываетесь в покоях одного из богов. Вы помните по книгам мельчайшие подробности владений четырех, но не можете определить чьи именно это харомы. Одно вы знаете точно - бог выделил вас за верную службу. И он готов сделать вас своим чемпионом. Вы чувствуете пронзающую боль и то, как ваше тело начинает изменяться... Это дар, это дар - повторяете вы себе, - я должен терпеть. Но терпеть нет больше сил и вы теряете сознание.");
        cv.put(ROOMS_VAR_A,"Проснуться");
        cv.put(ROOMS_VAR_A_WAY,"001");
        cv.put(ROOMS_VAR_A_PRICE,0);
        cv.put(ROOMS_VAR_B,"Проснуться");
        cv.put(ROOMS_VAR_B_WAY,"001");
        cv.put(ROOMS_VAR_B_PRICE,0);
        db.insert(ROOMS_TABLE_NAME,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        db.execSQL("DROP TABLE "+ROOMS_TABLE_NAME);
        this.onCreate(db);
    }
}
