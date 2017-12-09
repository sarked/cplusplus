package com.example.sarked.asynchron;

import android.content.Intent;
import android.os.AsyncTask;

public class MyTask extends AsyncTask<Integer, Double, String> {

    protected String doInBackground(Integer... params){
    //код, который должен запускаться зараллельно
        //запускается с набором определенных параметров, за параметры отвечает первый параметр - Integer, попадут в массив аргументов params
   //третий параметр - он устанавливает возвращаемый результат - Стринг
        //publishProgress(...); для передачи во второй метод данных типа Double

        //нужно сделать прил, которое показывает сообщение через опр время опр кол-во раз
        //извлекаем два аргумента из массива параметров:
        int delay = params[0];
        int repeat = params[1];
        //цикл для повторения, здесь выполняется логика асинхронной задачи
        for(int i=0; i<repeat; i++){
            try{
                Thread.sleep(delay);
                //i+0.0 - это привидение типов, чтобы перевести в Double
                publishProgress((i+0.0)/repeat);
                //отправляем во второй метод, чтобы он отправил в мейнактивити полученный прогресс
            }catch (InterruptedException e){

            }
        }
    return "Finish";
}

    protected void onProgressUpdate(Double... params){
        //вызывается по методу внутри первого метода, прогресс задачи будет ознаменоваться вторым параметром - в типе данных Double
        double val=params[0];
        MainActivity.self.showProgress(val);
    }
    protected void onPostExecute(String result){

        MainActivity.self.onResult(result);
        //запускается после окончания ервого метода.
        //сюда передается вернувшийся из первого метода Стринг
        //этот метод и второй может вызывать методы активности, первый метод не может
    }
}
