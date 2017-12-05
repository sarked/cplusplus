package com.example.sarked.catalog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class PageFragment extends Fragment {
    private View view;

    //переопределяем методы для работы с фрагментами
    @Override
    public void onCreate (Bundle bundle){
        super.onCreate(bundle);
    }
    //возвращает построенный в методе виджет, он будет использоватсья в качестве View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.fragment_page, parent, false);
        TextView title = (TextView) view.findViewById(R.id.info_name);
        TextView descr = (TextView) view.findViewById(R.id.info_description);
        ImageView img = (ImageView) view.findViewById(R.id.info_img);
//эти должны быть в ИнфоАктивити
//        Bundle data = getIntent().getExtras();
//        Goods good = (Goods) getIntent().getSerializableExtra("item");
//        Collection collection = (Collection) getIntent().getSerializableExtra("collection");
//        title.setText(good.title);
        //descr.setText(data.getString("descr"));
//        img.setImageResource(good.icon);

        this.view=view;
        return view;
    }
    public void swapPage (Goods good, Bundle data){
        TextView title = (TextView) view.findViewById(R.id.info_name);
        TextView descr = (TextView) view.findViewById(R.id.info_description);
        ImageView img = (ImageView) view.findViewById(R.id.info_img);
        title.setText(good.title);
        descr.setText(data.getString("descr"));
        img.setImageResource(good.icon);

    }
}

