package com.example.sarked.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArticleListFragment extends Fragment{

    public ArticleListFragment (){

    }

    //переопределяем методы для работы с фрагментами
    @Override
    public void onCreate (Bundle bundle){
        super.onCreate(bundle);
    }
    //возвращает построенный в методе виджет, он будет использоватсья в качестве View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.list, parent, false);
        TitleAdapter adapter = new TitleAdapter(getActivity(),Data.articles);

        ListView list = (android.widget.ListView) view.findViewById(R.id.listview);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ссылка на метод в мейнактивити
                MainActivity.self.openArticle(position);
            }
        });
        list.setAdapter(adapter);
        return view;
    }

}
