package Moba;

public class Tank extends Hero {

    public Tank (String name) {
        super(name);
        this.type = "Tank";
        this.hp = 400;
        this.damage = 60;
    }
}
