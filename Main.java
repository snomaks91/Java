package Lesson_6;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Cat1");
        cat1.info();
        cat1.run(100);
        cat1.swim(5);
        cat1.jump(2);

        Dog dog1 = new Dog("Dog1");
        dog1.info();
        dog1.run(500);
        dog1.swim(5);
        dog1.jump(2);
    }
}
