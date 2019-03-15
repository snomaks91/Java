package Lesson_5;

public class Main {
    public static void main(String[] args) {
        Person[] pers = new Person[5];
        pers[0] = new Person("Andei", "ingener", "anr@mail.ru", 8996658745L, 20000, 20);
        pers[1] = new Person("Ivan", "direktor", "ivan@mail.ru", 89966365221L, 50000, 50);
        pers[2] = new Person("Olga", "secretar", "olga@mail.ru", 89545621254L, 30000, 30);
        pers[3] = new Person("Maks", "ingener", "maks@mail.ru", 89698985256L, 40000, 45);
        pers[4] = new Person("Kate", "manager", "kate@mail.ru", 89655699874L, 30000, 25);
        for (int i = 0; i < pers.length; i++) {
            if (pers[i].age >= 40) {
                pers[i].display();
            }
        }
    }
}
