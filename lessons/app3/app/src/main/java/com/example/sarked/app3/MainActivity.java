package com.example.sarked.app3;

import android.animation.Animator;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int percent=0;
    void abc (int t){
        int a=t;
        double b=a/100.0*percent;
        String tax_new=getResources().getString(R.string.tax);
        String total_new=getResources().getString(R.string.total);
        //округление b до двух знаков
        b=Math.round(b*100)/100.0;
        TextView tax=(TextView)findViewById(R.id.tax);




        TextView total=(TextView)findViewById(R.id.total);
        double c=b+a;
        //если процент нулевой, то элементы исчезают, если есть - возвращается
        if(percent==0){
            tax.setVisibility(View.INVISIBLE);
            total.setVisibility(View.INVISIBLE);
        }else {
            tax.setVisibility(View.VISIBLE);
            total.setVisibility(View.VISIBLE);

            tax.setText(tax_new + b);
            total.setText(total_new + c);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        Button anibtn = (Button) findViewById(R.id.anibutton);
        final EditText input=(EditText)findViewById(R.id.number);
        final SeekBar xseek=(SeekBar)findViewById(R.id.seek);
        final TextView xresult=(TextView)findViewById(R.id.result);
        final TextView tax=(TextView)findViewById(R.id.tax);
        final TextView total=(TextView)findViewById(R.id.total);
        input.setText("0");
        xseek.setMax(100);

        anibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate()
                        //непрозрачность от 0 до 1(1=прозрачность)
                    .alpha(0)
                    .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(),"THIS IS THE END",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       callDialog();
                                   }
                               });

        AssetManager am=getAssets();
        Typeface font= Typeface.createFromAsset(am,"fonts/armalite.ttf");
        btn.setTypeface(font);

        //мы тут пытаемся вывести множество котов
        for(int i=0; i<=10;i++){
            String cats = getResources().getQuantityString(R.plurals.cats, i);
            Toast.makeText(this, i + " " + cats, Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(getApplicationContext(),"Hello!",Toast.LENGTH_LONG).show();
        //создали анонимный класс
        xseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                xresult.setText(progress+"%");
                percent=progress;

                String t = input.getText().toString();
                int a=Integer.parseInt(t);
                abc(a);
//              вынесли код в мейн, чтобы не повторялся
//                double b=a/100.0*progress;
//                //округление b до двух знаков
//                b=Math.round(b*100)/100.0;
//
//                tax.setText("Tax:"+b);
//
//                double c=b+a;
 //               total.setText("Total:"+c);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String t = input.getText().toString();
                if(t.equals("")){
                    return;
                }
                int a=Integer.parseInt(t);
                abc(a);
//                double b=a/100.0*percent;
//                //округление b до двух знаков
//                b=Math.round(b*100)/100.0;
//
//                tax.setText("Tax:"+b);
//
//                double c=b+a;
//                total.setText("Total:"+c);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    public void  callDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        final String []arr=getResources().getStringArray(R.array.massive);
        dialog.setItems(arr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), arr[which], Toast.LENGTH_SHORT).show();
            }

        });
        dialog.create().show();
    }

}
