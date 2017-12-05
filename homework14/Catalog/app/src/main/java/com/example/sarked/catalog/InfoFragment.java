package com.example.sarked.catalog;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class InfoFragment extends Fragment {
    private View view;

    public InfoFragment() {
    }

    //переопределяем методы для работы с фрагментами
    @Override
    public void onCreate (Bundle bundle){
        super.onCreate(bundle);
    }
    //возвращает построенный в методе виджет, он будет использоватсья в качестве View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.fragment_info, parent, false);
        TextView a=(TextView)view.findViewById(R.id.info);
        ((GoodsList)getContext()).setFont(a);
        this.view=view;
        return view;
    }


    public void openInfo (Goods good, ArrayList<Goods> arrayList){
        TextView a=(TextView)view.findViewById(R.id.info);
        //элемент по позиции из коллекции collection
        String b="ошибка";
        if (good.quality.equals("bad")) {
            b="плохого качества. Лучше им не пользоваться, а однажды используя следует сразу выбросить или продать торговцу, с которым больше никогда не встретитесь. Товар подводит своего владельца не только качеством, но и морально: источает неприятные запахи и довольно отвратен на вид.";
        }
        if (good.quality.equals("norm")) {
            b="обычного качества. Он верно прослужит в боях и скитаниях, но ничем особым вас не удивит. Такую вещицу не жалко потерять и скорей всего вы найдете что-то получше даже в куче медвежьего навоза в ближайшем лесу.";
        }
        if (good.quality.equals("rare")) {
            b="редкого качества. Вам придется потрудиться, чтобы найти аналог этому сокровищу. Приятно иметь такую вещь в коллекции, да и в боях предмет служит гораздло лучше того, чем вы обычно пользуетесь.";
        }
        if (good.quality.equals("epic")) {
            b="эпического качества. Дорогая, инкрустированная брилиантами вещь. Она повидала множество приключений, а теперь покотися перед вами на прилавке. Где-то есть засечки от прошлых хозяев, где-то застывшие капли крови. У предмета по истине есть история.";
        }
        if (good.quality.equals("legend")) {
            b="легендарного качества. О нем сложено не мало легенд и вы наверняка читали пару героических сказаний о ней. Этот предмет верно служит своему хозяину и, казалось бы, имеет личность. С вещицей не страшен даже сам Дьявол... Или ангелы, смотря за какую сторону вы сражаетесь...";
        }
        String c=(good.title+" - это товар "+b);
        a.setText(c);
        ((GoodsList)getContext()).setFont(a);


        //здесь поработаем над пейжвью, чтоб свапать товары
        //в методе онкреейт активности будем сохранять товар для главной

        //Если ориентация портретная - запустить вторую активость и передать туда текст новости
        //возможно надо передавать ещё и список для пейджвью
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Toast.makeText((GoodsList)getContext(),c,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(((GoodsList)getContext()), InfoActivity.class);
            //intent.putExtra("1",Data.articles.get(position).content);

            intent.putExtra("item", (Serializable) good);
            intent.putExtra("collection", (Serializable) arrayList);
            intent.putExtra("descr", c);
            startActivity(intent);
        }
    }


}
