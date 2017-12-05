package com.example.sarked.catalog;

import java.io.Serializable;
import java.util.Collection;
import java.util.Random;

public class Goods implements Serializable   {
    String title;
    int icon;
    String quality;

    Random random = new Random();
    String[] quant = {"bad","bad","norm","norm","norm","norm","norm","rare","epic","legend"};

    Goods(String t, String sex) {
        title = getName(t,sex);
        icon = R.drawable.coin_01;
        quality = quant[random.nextInt(quant.length)];

    }
    Goods(String t, String sex, int i) {
        title = getName(t,sex);
        icon = i;
        quality = quant[random.nextInt(quant.length)];
    }

    String[] firstName = {"Превосходн","Стремительн","Кровопролитн","Глянцев","Восхитительн","Неообычн","Божественн","Пестр","Радужн","Говорящ","Яр","Сказочн","Волшебн","Алмазн","Болезненн","Тяжел","Тленн","Непонят","Непонятн","Секретн","Тайн","Местн","Гол","Горд","Ушл","Лев","Алчн","Бегл","Бедн","Личн","Мятн","Мудр","Костн","Кисл","Тепл","Блудн","Бобов","Змеин","Влажн","Сочн","Варен", "Праздничн","Курьезн"
    };
    String[] lastName = {"чумы","демона","некроманта","учителя магии","бесконечности","войны","любви","разлуки","красоты","страсти","агонии","похоти","тлена","смерти","стаха","разложения","отчаяния","бедствий","воды","огня","магии","тьмы","света","Екатерины Петрововны","технологии","увядания","гнили","эпичности","столбняка","нефрита","робота","табака","царствия","музыки","луны","здоровья","реинкарнации","молчания", "энергии", "из плоти", "волка", "медведя", "совы", "крысы", "Санты"
    };

    public String getName(String n, String sex){


        String fn=firstName[random.nextInt(firstName.length)];
        String ln=lastName[random.nextInt(lastName.length)];
        String itemName="ошибка";
        if (sex.equals("male")) {
            itemName=fn+"ый "+n+" "+ln;
        }
        if (sex.equals("fem")) {
            itemName=fn+"ая "+n+" "+ln;
        }
        if (sex.equals("other")) {
            itemName=fn+"ое "+n+" "+ln;
        }

        return itemName;
    }
}
