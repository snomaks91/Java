package Lesson_3;

import java.util.Scanner;

public class Calc2 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Калькулятор 2");
        System.out.println("Введи выражение в формате: a + b - c");
        calc2();
    }

    public static double action(String[] line, double rez1, double rez2, int k) {
        switch (line[k]) {
            case "+":
                rez1 += rez2;
                break;
            case "-":
                rez1 -= rez2;
                break;
            case "*":
                rez1 *= rez2;
                break;
            case "/":
                rez1 /= rez2;
                break;
        }
        return rez1;
    }

    public static void calc2() {
        String[] line = sc.nextLine().split(" ");
        sc.close();
        double finalRez = Integer.parseInt(line[0]);
        for (int i = 1; i < line.length; i++) {
            if (line[i].equals("*") || line[i].equals("/")) {
                finalRez = action(line, finalRez, Integer.parseInt(line[i + 1]), i);
                i++;
            } else {
                int j = i;
                double rez = Integer.parseInt(line[j + 1]);
                while (true) {
                    if (j + 2 >= line.length || line[j + 2].equals("+") || line[j + 2].equals("-")) {
                        break;
                    }
                    if (line[j + 2].equals("*") || line[j + 2].equals("/")) {
                        rez = action(line, rez, Integer.parseInt(line[j + 3]), j + 2);
                    } else {
                        rez = action(line, rez, Integer.parseInt(line[j + 3]), i);
                        break;
                    }
                    j += 2;
                }
                finalRez = action(line, finalRez, rez, i);
                i = j + 1;
            }
        }
        System.out.println("= " + finalRez);
    }
}

