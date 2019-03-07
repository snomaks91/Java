package Lesson_3;

import java.util.Scanner;

public class Calc {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Калькулятор");
        calc();
    }

    public static void calc() {
        int a = sc.nextInt();
        double rez = a;
        String out = "=";
        String c = sc.next();
        while (true) {
            if (c.equals(out)) {
                break;
            }
            a = sc.nextInt();
            switch (c) {
                case "+":
                    rez += a;
                    break;
                case "-":
                    rez -= a;
                    break;
                case "*":
                    rez *= a;
                    break;
                case "/":
                    rez /= a;
                    break;
            }
            System.out.println("rez = " + rez);
            c = sc.next();
        }
        sc.close();
        System.out.println("rez = " + rez);
    }
}
