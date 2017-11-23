package com.example.sarked.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView ab = (TextView)findViewById(R.id.second_view);

//        //извлечение данных и вставка
//        Bundle data=getIntent().getExtras();
//        //извлечение из бандла по ключу
//        String txt = data.getString("AC");
//        ab.setText(txt);



        Button okbtn=(Button)findViewById(R.id.ok);
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fname = (EditText)findViewById(R.id.f);
                EditText lname = (EditText)findViewById(R.id.l);
                EditText fathername = (EditText)findViewById(R.id.fn);

                String fio=(fname.getText()+" "+lname.getText()+" "+fathername.getText());
                Intent intent = new Intent ();
                intent.putExtra("name",fio);
                setResult(0,intent);
                finish();

            }
        });
    }
}
