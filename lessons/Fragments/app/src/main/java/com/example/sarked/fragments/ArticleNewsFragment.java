package com.example.sarked.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ArticleNewsFragment extends Fragment{

    private View view;
    public ArticleNewsFragment (){

    }

    //переопределяем методы для работы с фрагментами
    @Override
    public void onCreate (Bundle bundle){
        super.onCreate(bundle);
    }
    //возвращает построенный в методе виджет, он будет использоватсья в качестве View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.news, parent, false);
        this.view=view;
        return view;
    }

    public void openArticle (int position){

        TextView a=(TextView)view.findViewById(R.id.news);
        a.setText(Data.articles.get(position).content);
    }


}
