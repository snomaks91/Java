package Moba;

public class Doctor extends Hero {

    public Doctor(String name) {
        super(name);
        this.type = "Doctor";
        this.hp = 100;
        this.damage = 5;
        this.cure = 50;

    }
    @Override
    void cure(Hero hero) {
        hero.hp += cure;
    }
}
