package com.example.sarked.pizza;

import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.ListPopupWindow.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {
    private MainActivity self;

    //список-корзина
    final ArrayList<OrderedPizza> ordered = new ArrayList<>();
    //метод подсчета и вывода пицц из корзины
    void order(){
        double finsum=0;
        //обозначаем текстовые поля, которые будут меняться.
        TextView q=(TextView)findViewById(R.id.quantity);
        TextView sm=(TextView)findViewById(R.id.sum);
        for (int siz = 0; siz < ordered.size(); siz++) {
            finsum=finsum+ordered.get(siz).price;
            q.setText(String.valueOf(siz+1));
            sm.setText(String.valueOf(finsum));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;

        //задаем работу закрепленных в шапке кнопок. Сперва находим их в атикивити_мейн
        final Button isbtn = (Button) findViewById(R.id.issue);
        Button paybtn = (Button) findViewById(R.id.pay);
        //теперь задаем для них всплывающие при нажатии диалоги
        isbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder (self);
                dialog.setTitle ("Выберите дату доставки");

                //вставляем отдельный лайаут с датой
                LayoutInflater inflater = getLayoutInflater();
                LinearLayout layout = (LinearLayout)findViewById(R.id.date_layout);
                final View view = inflater.inflate(R.layout.date, layout);
                dialog.setView(view);
//ВОПРОС: Как ещё можно создать дейтпикер без обращения к лайауту? Мб так? ошибка контекста
                //DatePicker dDatePicker = new DatePicker(dialog);

                dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //глубже{
                        AlertDialog.Builder dialog2 = new AlertDialog.Builder (self);
                        dialog2.setTitle ("Выберите время доставки");
                        //вставляем отдельный лайаут со временем
                        LayoutInflater inflater = getLayoutInflater();
                        LinearLayout layout = (LinearLayout)findViewById(R.id.time_layout);
                        final View view = inflater.inflate(R.layout.time, layout);
                        dialog2.setView(view);
//ВОПРОС: этот код выбрасывает ошибку.
                        TimePicker mTimePicker = (TimePicker) view.findViewById(R.id.timePicker);
                        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                            @Override
                            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                            }
                        });

                        dialog2.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog2, int which) {
                                //ещё глубже{
                                AlertDialog.Builder dialog3 = new AlertDialog.Builder (self);
                                dialog3.setTitle ("Ваш заказ:");
                                //динамически построить чек, подтягиваем лайаут под чек
                                LayoutInflater inflater=getLayoutInflater();
                                LinearLayout chlayout = (LinearLayout)findViewById(R.id.check_layout);
                                final View view = inflater.inflate(R.layout.check, chlayout);
                                chlayout = (LinearLayout)view.findViewById(R.id.check_layout);
                               // dialog3.setView(view);

//ВОПРОС:лабуда может с контекстами?  Где активность происходит? Все смешалось - подтягивается лайаут, а потом в него создаются линерлаяуты и элементы и всё это в диалоге в диалоге в кнопке в лаяуте мейнактивности
                                    //тут должен быть итерационный цикл, но пока и так не работает
                                    LinearLayout lay=new LinearLayout(getApplicationContext());
                                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
                                    lay.setLayoutParams(params);
                                    lay.setOrientation(LinearLayout.VERTICAL);

                                    TextView tx1 = new TextView(getApplicationContext());
                                    tx1.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
                                    tx1.setText("23424234");



                                dialog3.setView(chlayout);
                               // dialog3.setView(tx1);
                                //lay.addView(tx1);
                                chlayout.addView(tx1);


//                                //итератор
//                                for (int i = 0; i < ordered.size(); i++) {
//                                    //и начинаем создавать сроки для каждого объекта
//                                    LinearLayout layer1 = new LinearLayout(getApplicationContext());
//                                    params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
//                                    layer1.setLayoutParams(params);
//                                    layer1.setOrientation(LinearLayout.HORIZONTAL);
//                                    layer1.setPadding(0,20,0,0);
//                                    //теперь задаем элементы (если понадобится создать элементы ниже по ширине врапконтент, то юзать следующее)
//                                    //params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
//
//                                    TextView ordtxt = new TextView(getApplicationContext());
//                                    ordtxt.setLayoutParams(params);
//                                    //эта строка видоизменена ^
//                                    final String name = ordered.get(i).name;
//                                    final CharSequence size = String.valueOf(ordered.get(i).size);
//                                    ordtxt.setText("Пицца: «"+name+"» размер: "+size);
////
////
////                                    //помещаем элементы в нужные лаяуты
////                                    //lay.addView(tx1);
////
//                                    layer1.addView(ordtxt);
////                                    //layer.addView(tx1);
//                                    lay.addView(layer1);
//                                    chlayout.addView(lay);
////
//////                                    layer.addView(nametext);
//////                                    layer.addView(comtext);
//////                                    secondstring.addView(rg);
//////                                    secondstring.addView(btn);
//////                                    layout.addView(layer);
//////                                    layout.addView(secondstring);
//                                }


                                //кнопочка ОК
                                dialog3.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });



                                dialog3.create().show();
                                //еще глубже}
                            }
                        });
                        dialog2.create().show();
                        //глубже}
                    }
                });
                //самое важное в диалоге
                dialog.create().show();
            }
        });

        //и кнопка "оплатить"
        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ordered.size()>0){
                    Toast.makeText(getApplicationContext(),"Спасибо, курьер уже выехал",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Но вы же ничего не выбрали!",Toast.LENGTH_LONG).show();
                }
            }
        });

        //далее пойдет динамически-создаваемая часть
        LinearLayout layout=(LinearLayout)findViewById(R.id.root);
        //создаем коллекцию
        final ArrayList<Pizza> list = new ArrayList<>();
        list.add(new Pizza ("Гавайская","Ананасы, курица, гавайцы, папайя.", 29));
        list.add(new Pizza ("Вздохи тлена","Тмин, тлен, тесто, соус тартар.", 15));
        list.add(new Pizza ("С колбасой","Кровянка, докторская колбаса, сыровяленая колбаса, охотничья колбаска.", 30));
        list.add(new Pizza ("Лисица","Грибы, мех, пармезан, ветчина.", 26));


        final String sizes []={"17 см", "22 см", "28 см"};
        //итератор
        for (int i = 0; i < list.size(); i++) {
            //и начинаем создавать сроки для каждого объекта
            LinearLayout layer = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
            layer.setLayoutParams(params);
            layer.setOrientation(LinearLayout.VERTICAL);
            layer.setPadding(0,20,0,0);
            //теперь задаем элементы (если понадобится создать элементы ниже по ширине врапконтент, то юзать следующее)
            //params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

            TextView nametext = new TextView(this);
            nametext.setLayoutParams(params);
            final String name = list.get(i).name;
            nametext.setText("Пицца: «"+name+"»");
            //имя текущего элемента
            TextView comtext = new TextView(this);
            comtext.setLayoutParams(params);
            final String com = list.get(i).composition;
            comtext.setText(com);
            //состав текущего элемента

            final LinearLayout secondstring = new LinearLayout(this);
            LinearLayout.LayoutParams twoparams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
            secondstring.setLayoutParams(twoparams);
            secondstring.setVisibility(View.GONE);
            secondstring.setOrientation(LinearLayout.VERTICAL);

            final RadioGroup rg = new RadioGroup(this);
            final RadioButton rb1=new RadioButton(this);
            rb1.setText("17 см");
            //rb1.setId(R.id); как прицепить айдишники?
            final RadioButton rb2=new RadioButton(this);
            rb2.setText("22 см");
            final RadioButton rb3=new RadioButton(this);
            rb3.setText("28 см");
            //засовываем в группу и переключаем на 1-ую по умолчанию
            rg.addView(rb1);
            rg.addView(rb2);
            rg.addView(rb3);

            final double ap=list.get(i).price;
            final Button btn = new Button(this);
            btn.setLayoutParams(params);
            final String str1 = list.get(i).name;
            final String str2 = list.get(i).composition;
            //подписываем кнопку в зависимости от выбранного радио
            btn.setText("Выберите размер пиццы");
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if (rb1.isChecked()){
                        final double tp=ap;
                        btn.setText("Заказать за "+tp+" руб.");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //при нажатии создаваем объект в отдельный список "корзина" и вызываем метод подсчета
                                ordered.add(new OrderedPizza (str1, str2, rb1.getText(), tp));
                                order();
                            }
                        });
                    }
                    if (rb2.isChecked()){
                        final double tp=ap+4;
                        btn.setText("Заказать за "+tp+" руб.");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ordered.add(new OrderedPizza (str1, str2, rb2.getText(), tp));
                                order();
                            }
                        });
                    }
                    if (rb3.isChecked()){
                        final double tp=ap+9;
                        btn.setText("Заказать за "+tp+" руб.");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ordered.add(new OrderedPizza (str1, str2, rb3.getText(), tp));
                                order();
                            }
                        });
                    }
                }
            });

            //кликалка на целый лайаут. При нажатии показывает или скрывает баттоны
            layer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (secondstring.getVisibility()==View.GONE){
                        secondstring.setVisibility(View.VISIBLE);
                    } else{
                        secondstring.setVisibility(View.GONE);
                    }
                }
            });

            //помещаем элементы в нужные лаяуты
            layer.addView(nametext);
            layer.addView(comtext);
            secondstring.addView(rg);
            secondstring.addView(btn);
            layout.addView(layer);
            layout.addView(secondstring);
        }
        //конец итератора


    }
}
