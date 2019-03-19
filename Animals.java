package Lesson_6;

public class Animals {
    String name;

    void jump(int hJump) {
        System.out.println(name + " Прыжок на " + hJump);
    }

    void run (int lRun) {
        System.out.println(name + " Бежит " + lRun);
    }

    void swim (int lSwim) {
        System.out.println(name + " Плывет " + lSwim);
    }

    public Animals(String name) {
        this.name = name;
    }
}
