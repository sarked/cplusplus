package com.example.sarked.alphabattle;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Random;

public class FightTask extends AsyncTask <Integer, String, String> {

    int creature;
    ArrayList <Creature> humans;
    ArrayList <Creature> monsters;
    final Random randomEnemy = new Random();
    final Random randomAlly = new Random();
    ArrayList <String> log;
    int en;
    int al;

    FightTask (int c, ArrayList <Creature> h,ArrayList <Creature> m){
        creature=c;
        humans=h;
        monsters=m;
    }

    protected String doInBackground(Integer... params){
        try {
            //for (Creature h:humans) {
            en=randomEnemy.nextInt(monsters.size());
            humans.get(creature).attack(monsters.get(en));
            publishProgress(humans.get(creature).log);
            if (monsters.get(en).health<=0) {
                monsters.remove(en);
            }
            //Thread.sleep(1000);
            if (monsters.size()==0) {
                publishProgress("Он был последним, игра окончена");
                //System.exit(0);
                return "В команде монстров не осталось существ. Выиграла команда людей!";
            }
            //Thread.sleep(1000);
            //определяем тип спелла и применяем
            if(humans.get(creature).spell instanceof DefSpell) {
                al=randomAlly.nextInt(humans.size());
                humans.get(creature).magic(humans.get(al));
                publishProgress(humans.get(al).log);

            } else {
                en=randomEnemy.nextInt(monsters.size());
                humans.get(creature).magic(monsters.get(en));
                publishProgress(monsters.get(en).log);
                if (monsters.get(en).health<=0) {
                    monsters.remove(en);
                    //Thread.sleep(1000);

                    if (monsters.size()==0) {
                        publishProgress("Он был последним, игра окончена");
                        System.out.println("	В команде монстров не осталось существ. Выиграла команда людей!");
                        //System.exit(0);
                        return "В команде монстров не осталось существ. Выиграла команда людей!";
                    }
                }
            }
            //}
            //Thread.sleep(1000);
        } catch (Exception e) {}

        return "конец потока";
    }

    protected void onProgressUpdate(String... params){
        String val=params[0];
        MainActivity.self.showProgress(val);
    }

    protected void onPostExecute(String result){
        MainActivity.self.onFinish(result);
    }

    void innerThread(){

    }
}
