package Lesson_6;

import java.util.Random;

public class Cat extends Animals {
    Random random = new Random();
    int maxJump = random.nextInt(3);
    int maxRun = random.nextInt(500);
    int maxSwim = random.nextInt(10);

    public Cat(String name) {
        super(name);

    }
    void jump(int hJump) {
        if (hJump <= maxJump) {
            System.out.println(name + " Прыжок на " + hJump);
        } else {
            System.out.println(name + " не прыгает так высоко");
        }
    }
    void run (int lRun) {
        if (lRun <= maxRun) {
            System.out.println(name + " Бежит " + lRun);
        } else {
            System.out.println(name + " не может столько бежать");
        }
    }

    void swim (int lSwim) {
        if (lSwim <= maxSwim) {
            System.out.println(name + " Плывет " + lSwim);
        } else {
            System.out.println(name + " не может столько плыть");
        }
    }

    void info () {
        System.out.println("Максимальное расстояние бега " + name + " = " + maxRun);
        System.out.println("Максимальное расстояние плавания " + name + " = " + maxSwim);
        System.out.println("Максимальная высота прыжка " + name + " = " + maxJump);
    }
}
