package Moba;

public class Hero {

    String type;
    String name;
    int hp;
    int damage;
    int cure;

    public Hero(String name) {
        this.name = name;
    }

    void setDamage(Hero hero, int damage) {
        hero.hp -= damage;
    }

    void cure(Hero hero) {
    }
}
