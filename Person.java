package Lesson_5;

public class Person {
    String fio;
    String position;
    String email;
    long phone;
    int zp;
    int age;

    void display () {
        System.out.println(fio + " " + position + " " + email + " " + phone + " " + zp + " " + age);
    }

    public Person(String fio, String position, String email, long phone, int zp, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this. phone = phone;
        this. zp = zp;
        this. age = age;
    }
}

