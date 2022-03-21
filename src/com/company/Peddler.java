package com.company;

public class Peddler {
    static int gold=0;
    static int potion=50;
    static final int POTION_COST=100;
    public static void sellPotion(Hero hero){
        potion--;
        gold+=POTION_COST;
        hero.health=100;
        hero.gold-=POTION_COST;
        System.out.println(hero.name+"'s health has been restored");
    }
}
