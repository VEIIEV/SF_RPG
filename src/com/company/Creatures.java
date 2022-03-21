package com.company;
public abstract class Creatures {
   
    //ИМЯ	ЛОВКОСТЬ
    //ЗДОРОВЬЕ (ЕДИНИЦЫ ЖИЗНИ)	ОПЫТ
    //ЗОЛОТО	СИЛА
    protected String name;
    protected int dexterity;
    protected int strength;
    protected int experience;
    protected int gold;
    protected int health;
    //add gold and exp in the monster constructor

    public Creatures(String name, int dexterity, int strength, int health) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.health = health;
    }

    abstract public boolean crit();
    abstract public boolean getDetriment(int damage);
    abstract public void attack(Creatures enemy);
    abstract  public boolean isDead();
}
