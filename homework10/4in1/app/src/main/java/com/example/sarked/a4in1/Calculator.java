package com.example.sarked.a4in1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    double d2=0;
    double d1=0;
    double result=0;
    String b="";
    int oper=0;
    double mem=0.0;
    void save(){
        //перед арифметической операцией перевести число из строки в double и запомнить, b почистить
        d1=Double.parseDouble(b);
        b="";
    }
    void mcheck(){
        // если m больше не равно 0, то показывать буковку M
        TextView mtext = (TextView) findViewById(R.id.mtext);
        if(mem==0.0){
            mtext.setVisibility(View.INVISIBLE);
        }else{
            mtext.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button zero = (Button) findViewById(R.id.zero);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button point = (Button) findViewById(R.id.point);

        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button divide = (Button) findViewById(R.id.divide);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button equally = (Button) findViewById(R.id.equally);

        Button mr = (Button) findViewById(R.id.mr);
        Button mc = (Button) findViewById(R.id.mc);
        Button mplus = (Button) findViewById(R.id.mplus);
        Button mminus = (Button) findViewById(R.id.mminus);
        Button c = (Button) findViewById(R.id.c);
        Button del = (Button) findViewById(R.id.del);
        final TextView view = (TextView) findViewById(R.id.view);

        mcheck();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"1";
                view.setText(b);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"2";
                view.setText(b);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"3";
                view.setText(b);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"4";
                view.setText(b);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"5";
                view.setText(b);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"6";
                view.setText(b);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"7";
                view.setText(b);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"8";
                view.setText(b);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=b+"9";
                view.setText(b);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==""){}else{
                    b=b+"0";
                    view.setText(b);}
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b=="") {
                    b = b + "0.";
                    view.setText(b);
                }else{
                    if (b.contains(".")) {
                    } else {
                        b = b + ".";
                        view.setText(b);}
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                oper=1;
                view.setText("0");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                oper=2;
                view.setText("0");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                oper=3;
                view.setText("0");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                oper=4;
                view.setText("0");
            }
        });
        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //проверь чтоб нельзя было нажать без операци или второго числа в памяти
                if(b!=""){
                    d2=Double.parseDouble(b);}

                if(oper==1){
                    result=d1+d2;}
                if(oper==2){
                    result=d1-d2;}
                if(oper==3){
                    result=d1*d2;}
                if(oper==4){
                    if(d2==0.0){
                        view.setText("невозможно");
                        return;
                    }else {
                        result = d1/d2;
                    }
                }
                if(oper==0){
                    return;
                }
                b=Double.toString(result);
                view.setText(b);
                d2=0;
                oper=0;
            }
        });

        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=Double.toString(mem);
                view.setText(b);
            }
        });
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mem=0;
                mcheck();
            }
        });
        mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mem=mem+Double.parseDouble(b);
                b="";
                view.setText("0");
                mcheck();
            }
        });
        mminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mem=mem-Double.parseDouble(b);
                b="";
                view.setText("0");
                mcheck();
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b="";
                d2=0;
                d1=0;
                result=0;
                oper=0;
                view.setText("0");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.equals("")){
                    view.setText("0");
                }else{
                    b=b.substring(0, b.length()-1);
                    view.setText(b);}
            }
        });

        //String t = input.getText().toString();
        //int a=Integer.parseInt(t);
    }
}
