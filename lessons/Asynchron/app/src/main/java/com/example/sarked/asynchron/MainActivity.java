package com.example.sarked.asynchron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        self=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et =(EditText)findViewById(R.id.edit_txt);
        CheckBox cb =(CheckBox)findViewById(R.id.check_box);


        MyTask task=new MyTask();
        task.execute(1500,15);



    }

    void showProgress(Double a){
        Toast.makeText(getApplicationContext(), String.valueOf(a), Toast.LENGTH_SHORT).show();


    }

    void onResult(String a){
        Toast.makeText(getApplicationContext(), "Готово: "+a, Toast.LENGTH_SHORT).show();


    }

}
