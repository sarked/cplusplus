package com.example.sarked.alphabattle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static MainActivity self;

    final ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        self=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //оружие
        Weapon sword = new MeleeWeapon ("sword",20, 7);
        final MeleeWeapon mace = new MeleeWeapon ("mace",30, 4);
        MeleeWeapon knife = new MeleeWeapon ("knife",25, 10);
        RangeWeapon bow = new RangeWeapon ("bow",27, 9);
        RangeWeapon wand = new RangeWeapon ("wand",15, 20);
        //и спеллы
        AttackSpell fireball = new AttackSpell("fireball",20);
        AttackSpell corrupt = new AttackSpell("corruption",35);
        AttackSpell grenade = new AttackSpell("grenade",15);
        AttackSpell clap = new AttackSpell("clap",30);
        DefSpell rest = new DefSpell("restoration",10);
        final DefSpell shield = new DefSpell("magic shield",15);

        //коллекция людей
        final ArrayList<Creature>humans = new ArrayList <>();
        //коллекция монстров
        final ArrayList<Creature>monsters = new ArrayList <>();
        //


        humans.add(new Human ("Paladin", 90, 30, 2, mace, shield));
        humans.add(new Human ("Knigth", 100, 40, 1, sword, grenade));
        humans.add(new Human ("Priest", 60, 15, 5, knife, rest));
        humans.add(new Human ("Archer", 60, 25, 5, bow, grenade));
        humans.add(new Human ("Mage", 60, 20, 5, wand, fireball));
        monsters.add(new Monster ("Witch", 90, 30, 2, wand, corrupt));
        monsters.add(new Monster ("Troll", 120, 40, 1, mace, shield));
        monsters.add(new Monster ("Necromancer", 60, 20, 5, sword, clap));
        monsters.add(new Monster ("Werwolf", 80, 25, 5, knife, shield));
        monsters.add(new Monster ("Skeleton", 60, 20, 7, bow, grenade));


        final Button start = (Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.GONE);
                try {
                    while (humans.size()>0&&monsters.size()>0) {

                        //for(int i = 0; i < humans.size(); i++){
                        System.out.println("Старт большого цикла, "+monsters.size()+" не равен нулю,"+humans.size()+" не равен нулю");

                        int i=0;
                        while(i<humans.size()&&i<monsters.size()){
                            i+=1;
                            //откат
                            System.out.println("Ход людей. В команде монстров "+monsters.size()+", людей "+humans.size()+" ходят люди:");
                            System.out.println("Ходит: "+i);
                            FightTask ft = new FightTask(i,humans, monsters);
                            ft.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
                            //Thread.sleep(1000);

                            //проверку: есть ещё у монстров юниты?
                            System.out.println("Ход монстров. В команде монстров "+monsters.size()+", людей "+humans.size()+" ходят монстры:");
                            System.out.println("Ходит: "+i);
                            FightTask ft2 = new FightTask(i,monsters, humans);
                            ft2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
                            //Thread.sleep(1000);
                            //проверку: есть ещё у людей юниты?
                            System.out.println("Монстры походили. В команде монстров "+monsters.size()+", людей "+humans.size());
                        }
//                    for (Creature h:humans) {
//                        System.out.println("Ход людей. В команде монстров "+monsters.size()+", людей "+humans.size()+" ходят люди:");
//                        System.out.println("Ходит: "+h);
//                    FightTask ft = new FightTask(humans.indexOf(h),humans, monsters);
//                    ft.execute();
//                    }
//                    Thread.sleep(1000);
                    }
                    System.out.println("Игра окончена");


                } catch (Exception e) {
                    System.out.println("ошибка главного цикла");
                }
            }
        });

//        ListView ListView = (android.widget.ListView)findViewById(R.id.log);
//        final ArrayList<String> items = new ArrayList<>();
//        items.add("One");
//        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this, R.layout.list_item, items);
//        ListView.setAdapter(adapter);
        //добавление существ по нажатию кнопки


//                final Scanner in = new Scanner(System.in);
//                Thread t2=new Thread (new Runnable () {
//                    public void run() {
//                        //добавить в 1 или 2 команду существо
//                        while(monsters.size()!=0||humans.size()!=0) {
//                            int input=in.nextInt();
//                            if (input==1) {
//                                humans.add(new Human ("Paladin", 90, 30, 2, mace, shield));
//                                System.out.println("	(в команду ЛЮДЕЙ пришло подкрепление)");
//                            }else {
//                                monsters.add(new Monster ("Troll", 120, 40, 1, mace, shield));
//                                System.out.println("	(в команду МОНСТРОВ пришло подкрепление)");
//                            }
//                        }
//                    }
//                });

               // t1.start();
             // t2.start();

        //конец копипаста

    }
//
//


    void showProgress(String val){
        ListView ListView = (android.widget.ListView)findViewById(R.id.log);
        items.add(val);
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this, R.layout.list_item, items);
        ListView.setAdapter(adapter);
        //Toast.makeText(getApplicationContext(), val, Toast.LENGTH_SHORT).show();
    }
    void onFinish(String res){
       // Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }

}

