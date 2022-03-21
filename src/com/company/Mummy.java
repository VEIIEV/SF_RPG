package com.company;

public class Mummy extends Creatures{
    //constructor
    public Mummy() {
        super("mummy", 20, 15, 100);
        super.experience=50;
        super.gold=50;
    }

    @Override
    public void attack(Creatures enemy) {
        int ratio = super.dexterity * 3 - enemy.dexterity;
        if (ratio >= Math.random()*100) {
            if (crit()) enemy.getDetriment(super.strength * 2);
            else enemy.getDetriment(super.strength);
        }
        System.out.println(super.name+" missed");
    }


    //need to monster never crits
    public boolean crit() {
        return false;
    }

    //return true if hero is dead
    //check in encounter after any hit
    @Override
    public boolean getDetriment(int damage) {
        super.health -= damage;
        return isDead();
    }

    @Override
    public boolean isDead() {

        return super.health<= 0;
    }

}
