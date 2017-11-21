package com.example.sarked.a4in1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BankAct extends AppCompatActivity {

    public Button val1;
    public Button val2;
    //метод пересчета в классе Bank, метод аbc - построение и вывод списка
    void abc(double qa, final String QE){
        final LinearLayout layout=(LinearLayout)findViewById(R.id.mainlyaout);
        //Создаем банки и задаем текущие курсы
        final ArrayList<Bank> banks = new ArrayList<>();
        Bank prior = new Bank ("Приорбанк");
        prior.setCourse(2, 2.5, 0.5, 1.25, 0.4, 0.8);
        banks.add(prior);
        Bank mtb = new Bank ("МТБанк");
        mtb.setCourse(2.1, 2.6, 0.6, 1.27, 0.5, 0.9);
        banks.add(mtb);
        Bank bgpb = new Bank ("Белгазпромбанк");
        bgpb.setCourse(2, 2.4, 0.5, 1.30, 0.4, 0.7);
        banks.add(bgpb);
        Bank alpha = new Bank ("Альфа-Банк");
        alpha.setCourse(1.9, 2.4, 0.7, 1.29, 0.55, 0.9);
        banks.add(alpha);
        Bank mmb = new Bank ("Банк Москва-Минск");
        mmb.setCourse(1.95, 2.55, 0.7, 1.40, 0.45, 0.75);
        banks.add(mmb);
        //строим список

        //Collections.sort(banks,Collections.reverseOrder());
        //Collections.sort(banks,)

        Iterator<Bank>iter=banks.iterator();
        while(iter.hasNext()){
            final Bank i=iter.next();
            //Collections.sort(banks,i.getSort(QE));
            LinearLayout layer = new LinearLayout(BankAct.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layer.setLayoutParams(params);
            layer.setOrientation(LinearLayout.HORIZONTAL);

            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextView text = new TextView(BankAct.this);
            text.setLayoutParams(params);
            //поменять на вывод результата
            //text.setText(iter.next().show());

            text.setText(String.valueOf(i.name+" вам даст "+i.getCourse(qa,QE)));
            final String ni=i.name;
            final String QE1=QE;

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(BankAct.this);
                    dialog.setTitle (ni);
                    dialog.setView(R.layout.bank_dialog);


                    final EditText bdinp = (EditText) findViewById(R.id.bdinp);
                    final TextView bdtxt = (TextView) findViewById(R.id.bdout);
                    final Button bdbtn = (Button) findViewById(R.id.bd_btn);

                    //Attempt to invoke virtual method 'void android.widget.Button.setOnClickListener(android.view.View$OnClickListener)' on a null object reference
                    //????
                    bdbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast .makeText(BankAct.this, "ААААА!",Toast.LENGTH_LONG).show();
                        }
                    });

//                    dialog.setPositiveButton("Перевести", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast .makeText(MainActivity.this, "ААААА!",Toast.LENGTH_LONG).show();
                    //ошибка тут V
////                            double bdinp1=Double.parseDouble(bdinp.getText().toString());
////                            bdtxt.setText(String.valueOf(i.name+" вам даст "+i.getCourse(bdinp1,QE1))+" денег");
//                        }
//                    });

                    //null
//                    bdinp.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                        @Override
//                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                            double bdinp1=Double.parseDouble(bdinp.getText().toString());
//
//                            bdtxt.setText(String.valueOf(i.name+" вам даст "+i.getCourse(bdinp1,QE1))+" денег");
//                            return false;
//                        }
//                    });
                    dialog.create().show();
                }
            });


            layer.addView(text);
            layout.addView(layer);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        //final LinearLayout layout=(LinearLayout)findViewById(R.id.mainlyaout);

//        final ArrayList<Bank> banks = new ArrayList<>();
//        //Создаем банки и задаем текущие курсы
//        Bank prior = new Bank ("Приорбанк");
//        prior.setCourse(2, 2.5, 0.5, 1.25, 0.4, 0.8);
//        banks.add(prior);
//        Bank mtb = new Bank ("МТБанк");
//        mtb.setCourse(2.1, 2.6, 0.6, 1.27, 0.5, 0.9);
//        banks.add(mtb);
//        Bank bgpb = new Bank ("Белгазпромбанк");
//        bgpb.setCourse(2, 2.4, 0.5, 1.30, 0.4, 0.7);
//        banks.add(bgpb);
//        Bank alpha = new Bank ("Альфа-Банк");
//        alpha.setCourse(1.9, 2.4, 0.7, 1.29, 0.55, 0.9);
//        banks.add(alpha);
//        Bank mmb = new Bank ("Банк Москва-Минск");
//        mmb.setCourse(1.95, 2.55, 0.6, 1.40, 0.45, 0.75);
//        banks.add(mtb);

        val1 = (Button) findViewById(R.id.btn_from);
        final Button ft = (Button) findViewById(R.id.from_to);
        val2 = (Button) findViewById(R.id.btn_to);
        final String items []={"BYN", "USD", "EUR"};
        val1.setText("Валюта А");
        val2.setText("Валюта Б");

        //эти строки лучше хранить в ресурсах или как статистическое поле в классе банк, оно относится к банкам и лучше хранить ближе к ним.

        ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btntxt=String.valueOf(ft.getText());
                if (btntxt.contains(">")){
                    ft.setText("<");
                }else{
                    ft.setText(">");
                }
            }
        });

        //кнопки выбора валюты
        val1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(BankAct.this);
                dialog.setTitle ("Выберите валюту");

                dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    //обработчик событий выполняет действие при нажатии на элемент, а не закрытии окна диалога
                    public void onClick(DialogInterface dialog, int which) {
                        val1.setText(items[which]);
                    }
                });
                dialog.create().show();
            }
        });
        val2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(BankAct.this);
                dialog.setTitle ("Выберите валюту");

                dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    //обработчик событий выполняет действие при нажатии на элемент, а не закрытии окна диалога
                    public void onClick(DialogInterface dialog, int which) {
                        val2.setText(items[which]);
                    }
                });
                dialog.create().show();
            }
        });

        //проверка
        //Toast .makeText(this, val1.getText(),Toast.LENGTH_LONG).show();
        final EditText input = (EditText) findViewById(R.id.input);
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String vala=val1.getText().toString();
                String valb=val2.getText().toString();
                if (ft.getText().toString()=="<"){
                    valb=val1.getText().toString();
                    vala=val2.getText().toString();
                }
                if (input.getText().toString().equals("")) {
                    //понастраивать валидации на 00000.2 и проч неадекватные числа
                    Toast .makeText(BankAct.this, "Да введите же что-нибудь!",Toast.LENGTH_LONG).show();
                }else{
                    double inp=Double.parseDouble(input.getText().toString());
                    //double q=0;
//                    Iterator<Bank>iter=banks.iterator();
                    //for (int i = 0; i < mCatNames.size(); i++)

                    //Toast .makeText(MainActivity.this, input.getText(),Toast.LENGTH_LONG).show();
                    if(val1.getText()==val2.getText()||val1.getText()=="Валюта А"||val2.getText()=="Валюта Б"){
                        Toast .makeText(BankAct.this, "Выберите разные валюты",Toast.LENGTH_LONG).show();
                    }else{
                        switch (vala){
                            //вытаскиваем нужные коофициент из объектов банков
                            case "BYN":
                                if(valb=="USD"){
                                    abc(inp,"AB");
                                }
                                if(valb=="EUR"){
                                    abc(inp,"AC");
                                }
                                break;
                            case "USD":
                                if(valb=="BYN"){
                                    abc(inp,"BA");
                                }
                                if(valb=="EUR"){
                                    abc(inp,"BC");
                                }
                                break;
                            case "EUR":
                                if(valb=="BYN"){
                                    abc(inp,"CA");
                                }
                                if(valb=="USD"){
                                    abc(inp,"CB");
                                }
                                break;
                        }

                        //дальнейший код поместить в метод, который будет принимать коофициент и вводимое число и на основе их делать расчеты
                        //строим список (надо еще всю эту радость отсортировать по убыванию .sort??? arraylist sort java
                        //banks.sort(bank.getCourse());

                        //Iterator<Bank>iter=banks.iterator();
//                        while(iter.hasNext()){
//                            LinearLayout layer = new LinearLayout(MainActivity.this);
//                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                            layer.setLayoutParams(params);
//                            layer.setOrientation(LinearLayout.HORIZONTAL);
//
//                            params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                            TextView text = new TextView(MainActivity.this);
//                            text.setLayoutParams(params);
//                            //поменять на вывод результата
//                            text.setText(iter.next().show());
//
//                            layer.addView(text);
//                            layout.addView(layer);
//                        }
                    }
                }



                return false;
            }
        });


    }
}
