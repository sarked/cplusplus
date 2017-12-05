package com.example.sarked.catalog;

import android.content.res.Resources;
import android.media.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Category {
    String title;
    Collection goods;
    int res;

    Category(String t, Collection g){
        title=t;
        goods=g;
        res=R.drawable.coin_01;
    }
    Category(String t, Collection g, int r){
        title=t;
        goods=g;
        res=r;
    }

    public static Collection <Goods> getBooks(){
        ArrayList<Goods> books = new ArrayList<Goods>();
        books.add(new Goods("книга","fem",R.drawable.book1));
        books.add(new Goods("книга","fem",R.drawable.book2));
        books.add(new Goods("фолиант","male",R.drawable.book7));
        books.add(new Goods("книга","fem",R.drawable.book4));
        books.add(new Goods("фолиант","male",R.drawable.book5));
        books.add(new Goods("книга","fem",R.drawable.book6));
        books.add(new Goods("книга","fem",R.drawable.book3));
        books.add(new Goods("книга","fem",R.drawable.book8));
        return books;
    }
    public static Collection <Goods> getBows(){
        ArrayList<Goods> bows = new ArrayList<Goods>();
        bows.add(new Goods("лук","male",R.drawable.bow1));
        bows.add(new Goods("лук","male",R.drawable.bow2));
        bows.add(new Goods("лук","male",R.drawable.bow3));
        bows.add(new Goods("лук","male",R.drawable.bow4));
        bows.add(new Goods("лук","male",R.drawable.bow5));
        bows.add(new Goods("лук","male",R.drawable.bow6));
        bows.add(new Goods("лук","male",R.drawable.bow7));
        bows.add(new Goods("арбалет","male",R.drawable.bow8));
        bows.add(new Goods("арбалет","male",R.drawable.bow9));
        return bows;
    }
    public static Collection <Goods> getAxes(){
        ArrayList<Goods> axes = new ArrayList<Goods>();
        axes.add(new Goods("топор","male",R.drawable.axe1));
        axes.add(new Goods("топор","male",R.drawable.axe2));
        axes.add(new Goods("топор","male",R.drawable.axe3));
        axes.add(new Goods("топор","male",R.drawable.axe4));
        axes.add(new Goods("топор","male",R.drawable.axe5));
        axes.add(new Goods("топор","male",R.drawable.axe6));
        axes.add(new Goods("топор","male",R.drawable.axe7));
        axes.add(new Goods("алебарда","fem",R.drawable.axe8));
        axes.add(new Goods("алебарда","fem",R.drawable.axe9));
        axes.add(new Goods("алебарда","fem",R.drawable.axe10));
        return axes;
    }
    public static Collection <Goods> getArmors(){
        ArrayList<Goods> armor = new ArrayList<Goods>();
        armor.add(new Goods("кольчуга","fem",R.drawable.armor1));
        armor.add(new Goods("мантия","fem",R.drawable.armor2));
        armor.add(new Goods("мантия","fem",R.drawable.armor3));
        armor.add(new Goods("броня","fem",R.drawable.armor4));
        armor.add(new Goods("кираса","fem",R.drawable.armor5));
        armor.add(new Goods("кираса","fem",R.drawable.armor6));
        armor.add(new Goods("шлем","male",R.drawable.armor7));
        armor.add(new Goods("забрало","other",R.drawable.armor8));
        armor.add(new Goods("броня","fem",R.drawable.armor9));
        armor.add(new Goods("наплечник","male",R.drawable.armor10));
        return armor;
    }
    public static Collection <Goods> getMaces(){
        ArrayList<Goods> maces = new ArrayList<Goods>();
        maces.add(new Goods("булава","fem",R.drawable.mace1));
        maces.add(new Goods("булава","fem",R.drawable.mace2));
        maces.add(new Goods("булава","fem",R.drawable.mace3));
        maces.add(new Goods("булава","fem",R.drawable.mace4));
        maces.add(new Goods("булава","fem",R.drawable.mace5));
        maces.add(new Goods("драконья булава","fem",R.drawable.mace6));
        maces.add(new Goods("булава","fem",R.drawable.mace7));
        maces.add(new Goods("кувалда","fem",R.drawable.mace8));
        maces.add(new Goods("булава","fem",R.drawable.mace9));
        return maces;
    }
    public static Collection <Goods> getPoisons(){
        ArrayList<Goods> poisons = new ArrayList<Goods>();
        poisons.add(new Goods("отвар","male",R.drawable.poison1));
        poisons.add(new Goods("зелье","other",R.drawable.poison2));
        poisons.add(new Goods("зелье","other",R.drawable.poison3));
        poisons.add(new Goods("зелье","other",R.drawable.poison4));
        poisons.add(new Goods("припарка","fem",R.drawable.poison5));
        poisons.add(new Goods("отвар","male",R.drawable.poison6));
        poisons.add(new Goods("зелье","other",R.drawable.poison7));
        poisons.add(new Goods("отвар","male",R.drawable.poison8));
        poisons.add(new Goods("отвар","male",R.drawable.poison9));
        poisons.add(new Goods("припарка","fem",R.drawable.poison10));
        poisons.add(new Goods("отвар","male",R.drawable.poison11));
        poisons.add(new Goods("отвар","male",R.drawable.poison12));
        poisons.add(new Goods("припарка","fem",R.drawable.poison13));
        return poisons;
    }
    public static Collection <Goods> getStaffs(){
        ArrayList<Goods> staffs = new ArrayList<Goods>();
        staffs.add(new Goods("жезл","male",R.drawable.staff1));
        staffs.add(new Goods("посох","male",R.drawable.staff2));
        staffs.add(new Goods("жезл","male",R.drawable.staff3));
        staffs.add(new Goods("волшебная палочка","fem",R.drawable.staff4));
        staffs.add(new Goods("жезл","male",R.drawable.staff5));
        staffs.add(new Goods("жезл","male",R.drawable.staff6));
        staffs.add(new Goods("жезл","male",R.drawable.staff7));
        staffs.add(new Goods("посох","male",R.drawable.staff8));
        staffs.add(new Goods("посох","male",R.drawable.staff9));
        staffs.add(new Goods("волшебная палочка","fem",R.drawable.staff10));
        return staffs;
    }
    public static Collection <Goods> getSwords(){
        ArrayList<Goods> swords = new ArrayList<Goods>();
        swords.add(new Goods("меч","male",R.drawable.sword1));
        swords.add(new Goods("сабля","fem",R.drawable.sword2));
        swords.add(new Goods("меч","male",R.drawable.sword3));
        swords.add(new Goods("клинок","male",R.drawable.sword4));
        swords.add(new Goods("двуручный меч","male",R.drawable.sword5));
        swords.add(new Goods("нож","male",R.drawable.sword6));
        swords.add(new Goods("кинжал","male",R.drawable.sword7));
        swords.add(new Goods("меч","male",R.drawable.sword8));
        swords.add(new Goods("меч","male",R.drawable.sword9));
        swords.add(new Goods("рубило","other",R.drawable.sword10));
        swords.add(new Goods("меч","male",R.drawable.sword11));
        swords.add(new Goods("меч","male",R.drawable.sword12));
        return swords;
    }
}
