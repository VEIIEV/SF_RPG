package com.company;

public class Skeleton extends Creatures{
    //constructor
    public Skeleton() {
        super("skeleton", 10, 8, 35);
        super.experience=20;
        super.gold=20;
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
