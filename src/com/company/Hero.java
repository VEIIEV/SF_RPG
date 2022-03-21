package com.company;

public  class Hero extends Creatures {
    int lvl = 1;
    int maxHealth;
    //constructor
    static public  Hero createHero(String name, int dexterity, int strength, int health){
        return new Hero(name, dexterity, strength, health);
    }
    private Hero(String name, int dexterity, int strength, int health) {
        super(name, dexterity, strength, health);
        super.experience=0;
        super.gold=0;
        this.maxHealth= health;
    }

    @Override
    public void attack(Creatures enemy) {
//При этом, если наша ловкость, умноженная на 3-ловкость противника, больше, чем случайное значение (от 0 до 100), то мы атакуем в размере нашей силы
        int ratio = super.dexterity * 3 - enemy.dexterity;
        if (ratio >= Math.random()*100) {
            if (crit()) enemy.getDetriment(super.strength * 2);
            else enemy.getDetriment(super.strength);
        }
        System.out.println(super.name+" missed");
    }


//need to realise
    @Override
    public boolean crit() {
        //if ()
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

    public void getExp(int exp) {
        super.experience+=exp;
        if(isLvlUp()) System.out.println("LVL UP"+ this.lvl);
    }

    //perform check for lvl up  in the end of every skirmish
    //in Class encounter
    public boolean isLvlUp() {
        if (super.experience >= 100) {
            super.experience -= 100;
            lvl++;
            maxHealth+=20;
            health=maxHealth;
            dexterity+=5;
            strength+=5;
            isLvlUp();
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", dexterity=" + dexterity +
                ", strength=" + strength +
                ", experience=" + experience +
                ", gold=" + gold +
                ", health=" + health +
                ", lvl=" + lvl +
                '}';
    }

    public void getGold(int gold) {
        super.gold+=gold;
    }
}
