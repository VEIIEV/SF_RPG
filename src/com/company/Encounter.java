package com.company;

public class Encounter extends Thread {
    World world;
    Hero hero;
    Creatures enemy;

    public Encounter(Hero hero, Creatures enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    @Override
    public void run() {
        System.out.println("your enemy is "+ enemy.name);

        if(fight(hero.dexterity > enemy.dexterity)){
            System.out.println("Hero win " +enemy.name);
            hero.getExp(enemy.experience);
            hero.getGold(enemy.gold);
            World.logResult(hero);
        }
        else{
            System.out.println("Hero has been slain by "+enemy.name);
            World.logResult(hero);
        }
    }

    //return true if hero win
    private boolean fight(boolean fightOrder) {
        if ((fightOrder)) {
            System.out.println("you attack first");
        } else {
            System.out.println(enemy.name + " attack first");
        }
        while (true) {
            //first attack person with better dexterity
            if (fightOrder) {
                hero.attack(enemy);
                System.out.println("you attacked enemy. His current HP is "+enemy.health);
                if (enemy.isDead()) return true;
                else enemy.attack(hero);
                System.out.println("enemy attacked you. You current HP is "+hero.health);
            } else {
                enemy.attack(hero);
                System.out.println("enemy attacked you. You current HP is "+hero.health);
                if (hero.isDead()) return false;
                else hero.attack(enemy);
                System.out.println("you attacked enemy. His current HP is "+enemy.health);
            }
            if(hero.isDead()) return false;

        }
    }
}
