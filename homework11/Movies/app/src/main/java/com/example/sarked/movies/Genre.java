package com.example.sarked.movies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Genre {
    String name;
    Collection films;

    Genre(String n, Collection f){
        name=n;
        films=f;
    }

    //здесь можно хранить коллекции фильмов???????
//лист + метод

    static Collection<Item> getHorrors(){
        final ArrayList<Item> hor=new ArrayList<Item>();
        Item psiho=new Item("Психо, 1960","Девушка, недовольная романом с разведенным мужчиной, уделяющим ей внимание только наездами, крадет на работе крупную сумму денег и в спешке бежит из города. В мотеле, где она остановилась на ночь, ей приходится столкнуться с его молодым владельцем…");
        Item drugie=new Item("Другие, 2001","Красавица Грейс увозит своих больных детей в особняк на одном из островов у побережья Англии, чтобы дождаться окончания Второй мировой войны. Войны, с которой вернется ее муж.");
        Item chuzhoy=new Item("Чужой, 1979","В далеком будущем возвращающийся на Землю грузовой космический корабль перехватывает исходящий с неизвестной планеты неопознанный сигнал. Экипаж принимает решение совершить посадку и разобраться, в чем дело. Оказавшись на планете, астронавты повсюду обнаруживают неопознанные предметы, по виду напоминающие гигантские коконы…");
        Item mizery=new Item("Мизери, 1990","Писатель Пол Шелдон не помнит сильного снегопада, из-за которого он разбился на своей машине где-то в горах. Он также не помнит, как его нашла и спасла от неминуемой смерти женщина.");
        Item drakula=new Item("Дракула, 1992","Конец XIX века, Лондон. Молодой юрист Джонатан Харкер и красавица девушка Мина любят друг друга. Джонатан на время вынужден оставить невесту одну и отправиться по делам в Трансильванию к графу Дракуле, желающему приобрести недвижимость в столице Англии. Но Джонатан не знает, кто такой Дракула на самом деле…");
        Item nechto=new Item("Нечто, 1982","Команде ученых американской исследовательской базы в Антарктике предстоит столкнуться с необъяснимым, чудовищным кошмаром. Отрезанные от всего света полярники вступают в неравную схватку с инопланетной тварью, пробудившейся после тысячелетней спячки во льдах.");
        hor.add(psiho);
        hor.add(drugie);
        hor.add(chuzhoy);
        hor.add(mizery);
        hor.add(drakula);
        hor.add(nechto);
        return hor;
    }
    static Collection<Item> getComedies(){
        final ArrayList<Item> com=new ArrayList<Item>();
        Item forest=new Item("Форест Гамп, 1994","От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни.");
        Item oneandone=new Item("1+1, 2011","Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, — молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.");
        Item ivan=new Item("Иван Васильевич меняет профессию, 1973","Инженер-изобретатель Тимофеев сконструировал машину времени, которая соединила его квартиру с далеким шестнадцатым веком — точнее, с палатами государя Ивана Грозного. Туда-то и попадают тезка царя пенсионер-общественник Иван Васильевич Бунша и квартирный вор Жорж Милославский.");
        Item fiction=new Item("Криминальное чтиво, 1994","Двое бандитов Винсент Вега и Джулс Винфилд проводят время в философских беседах в перерыве между разборками и «решением проблем» с должниками своего криминального босса Марселласа Уоллеса. Параллельно разворачиваются три истории.");
        Item jazz=new Item("В джазе только девушки, 1959","Когда чикагские музыканты Джо и Джерри случайно становятся свидетелями бандитской перестрелки, они в срочном порядке смываются на поезде во Флориду, прикинувшись женщинами. Теперь они — Джозефина и Дафна, новенькие и хорошенькие инструменталистки женского джаз — банда.");
        com.add(forest);
        com.add(oneandone);
        com.add(ivan);
        com.add(fiction);
        com.add(jazz);
        return com;
    }
    static Collection<Item> getScifi(){
        final ArrayList<Item> sf=new ArrayList<Item>();
        Item interstellar=new Item("Интерстеллар, 2014","Когда засуха приводит человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и переселить человечество на другую планету.");
        Item backfuture=new Item("Назад в будущее, 1985","Подросток Марти с помощью машины времени, сооруженной его другом профессором доком Брауном, попадает из 80-х в далекие 50-е. Там он встречается со своими будущими родителями, еще подростками, и другом-профессором, совсем молодым.");
        Item element=new Item("Пятый элемент, 1997","Каждые пять тысяч лет открываются двери между измерениями и темные силы стремятся нарушить существующую гармонию. Каждые пять тысяч лет Вселенной нужен герой, способный противостоять этому злу. XXIII век. Нью-йоркский таксист Корбен Даллас должен решить глобальную задачу — спасение всего рода человеческого.");
        Item kpex=new Item("Планета Ка-Пэкс, 2001","В Манхэттенский психиатрический институт привозят странного человека в черных очках. Он зовет себя Протом и утверждает, что его родина — далекая планета Ка-Пэкс, откуда он мгновенно перенесся на Землю в луче света. Несмотря на все усилия, опытному доктору Пауэллу не удается разгадать загадку таинственного пациента, который охотно и весьма убедительно доказывает всем свое внеземное происхождение и заранее назначает дату своего возвращения на Ка-Пэкс. ");
        sf.add(interstellar);
        sf.add(backfuture);
        sf.add(element);
        sf.add(kpex);
        return sf;
    }
    static Collection<Item> getFantasy(){
        final ArrayList<Item> fan=new ArrayList<Item>();
        Item mile=new Item("Зеленая миля, 1999","Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.");
        Item pirat=new Item("Пираты Карибского моря: Проклятие Черной жемчужины, 2003","Жизнь харизматичного авантюриста, капитана Джека Воробья, полная увлекательных приключений, резко меняется, когда его заклятый враг — капитан Барбосса — похищает корабль Джека, Черную Жемчужину, а затем нападает на Порт Ройал и крадет прекрасную дочь губернатора, Элизабет Свонн.");
        Item dracon=new Item("Как приручить дракона, 2010","Вы узнаете историю подростка Иккинга, которому не слишком близки традиции его героического племени, много лет ведущего войну с драконами. Мир Иккинга переворачивается с ног на голову, когда он неожиданно встречает дракона Беззубика, который поможет ему и другим викингам увидеть привычный мир с совершенно другой стороны…");
        Item hobbit=new Item("Хоббит: Нежданное путешествие, 2012","Фильм повествует о путешествии Бильбо Бэггинса, который пускается в грандиозный поход, целью которого является отвоевание утраченного королевства гномов Эребор у зловещего дракона Смауга. Совершенно неожиданно с хоббитом налаживает контакт волшебник Гэндальф Серый. Так Бильбо находит себя, присоединяясь к компании тринадцати гномов, возглавляемых легендарным воином, Торином Дубощитом. ");
        Item surok=new Item("День сурка, 1993","Телевизионный комментатор Фил Коннорс каждый год приезжает в маленький городок в штате Пенсильвания на празднование Дня сурка. Но на этот раз веселье рискует зайти слишком далеко. Время сыграло с ним злую шутку: оно взяло да и остановилось.");
        Item ghost=new Item("Привидение, 1990","Счастливая парочка возвращается домой после вечера в театре. На тёмной аллее на них нападает грабитель… Защищаясь, Сэм погибает. Теперь он только призрак, но всё еще может помочь своей возлюбленной! Сэм-привидение узнаёт, что его смерть не была случайной, а над Молли нависла смертельная опасность! Но для Молли он теперь «человек-невидимка», которого она не видит и не слышит. Как предупредить её об опасности?");
        Item potter=new Item("Гарри Поттер и философский камень, 2001","Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: его родители умерли, едва ему исполнился год, а от дяди и тётки, взявших сироту на воспитание, достаются лишь тычки да подзатыльники. Но в одиннадцатый день рождения Гарри всё меняется. Странный гость, неожиданно появившийся на пороге, приносит письмо, из которого мальчик узнаёт, что на самом деле он волшебник и принят в Хогвартс — школу магии.");
        fan.add(mile);
        fan.add(pirat);
        fan.add(dracon);
        fan.add(hobbit);
        fan.add(surok);
        fan.add(ghost);
        fan.add(potter);
        return fan;
    }
    static Collection<Item> getDram(){
        final ArrayList<Item> dr=new ArrayList<Item>();
        Item pobeg=new Item("Побег из Шоушенка, 1994","Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.");
        Item spisok=new Item("Список Шиндлера, 1993","Фильм рассказывает реальную историю загадочного Оскара Шиндлера, члена нацистской партии, преуспевающего фабриканта, спасшего во время Второй мировой войны почти 1200 евреев.");
        Item lev=new Item("Король Лев, 1994","У величественного Короля-Льва Муфасы рождается наследник по имени Симба. Уже в детстве любознательный малыш становится жертвой интриг своего завистливого дяди Шрама, мечтающего о власти.");
        Item klub=new Item("Бойцовский клуб, 1999","Терзаемый хронической бессонницей и отчаянно пытающийся вырваться из мучительно скучной жизни, клерк встречает некоего Тайлера Дардена, харизматического торговца мылом с извращенной философией. Тайлер уверен, что самосовершенствование — удел слабых, а саморазрушение — единственное, ради чего стоит жить.");
        Item leon=new Item("Леон, 1994","Профессиональный убийца Леон, не знающий пощады и жалости, знакомится со своей очаровательной соседкой Матильдой, семью которой расстреливают полицейские, замешанные в торговле наркотиками. Благодаря этому знакомству он впервые испытывает чувство любви, но…");
        dr.add(pobeg);
        dr.add(spisok);
        dr.add(leon);
        dr.add(lev);
        dr.add(klub);
        return dr;
    }
    static Collection<Item> getSer(){
        final ArrayList<Item> sr=new ArrayList<Item>();
        Item ip=new Item("Игра Престолов, 2011","К концу подходит время благоденствия, и лето, длившееся почти десятилетие, угасает. Вокруг средоточия власти Семи королевств, Железного трона, зреет заговор, и в это непростое время король решает искать поддержки у друга юности Эддарда Старка. В мире, где все — от короля до наемника — рвутся к власти, плетут интриги и готовы вонзить нож в спину, есть место и благородству, состраданию и любви. Между тем, никто не замечает пробуждение тьмы из легенд далеко на Севере — и лишь Стена защищает живых к югу от нее.");
        Item firefly=new Item("Светлячок, 2002","Капитан Малькольм Рейнольдс — закаленный в боях ветеран галактической гражданской войны, сражавшийся не на той (проигравшей) стороне, зарабатывает на жизнь мелкими преступлениями и перевозит грузы на своем корабле «Серенити».");
        Item clinic=new Item("Клиника, 2001","Отучившись четыре года в медицинской школе, Джон Дориан приходит работать интерном в клинику. Вместе с ним здесь же будет применять полученные знания и его лучший друг со времен колледжа Крис Терк. Не имеющие опыта практической работы, молодые специалисты сразу же погружаются в хаотический мир жизни больницы…");
        Item sherlock=new Item("Шерлок, 2010","События разворачиваются в наши дни. Он прошел Афганистан, остался инвалидом. По возвращении в родные края встречается с загадочным, но своеобразным гениальным человеком. Тот в поиске соседа по квартире. Лондон, 2010 год. Происходят необъяснимые убийства. Скотланд-Ярд без понятия, за что хвататься. Существует лишь один человек, который в силах разрешить проблемы и найти ответы на сложные вопросы.");
        sr.add(ip);
        sr.add(firefly);
        sr.add(clinic);
        sr.add(sherlock);
        return sr;
    }

}