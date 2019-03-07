package Lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Random rand = new Random();
        System.out.println("Угадай число");
        int b;
        do {
            int zagChislo = rand.nextInt(10);
//            System.out.println(zagChislo);
            int a = getNumber("Угадайте число  от 0 до 9 ", 0, 9);
            for (int i = 0; i < 2; i++) {
                if (a > zagChislo) {
                    System.out.println("Загаданное число меньше");
                    a = getNumber("Попробуй еще", 0, 9);
                } else {
                    if (a < zagChislo) {
                        System.out.println("Загаданное число больше");
                        a = getNumber("Попробуй еще", 0, 9);
                    }
                }
                if (a == zagChislo) {
                    System.out.println("Угадал");
                    break;
                }
                if (i == 1) {
                    System.out.println("Не угадал");
                }
            }
            b = getNumber("Повторить игру еще раз? 1 - да; 0 - нет.", 0, 2);
        } while (b == 1);
        System.out.println("Игра окончана");
        System.out.println();

        System.out.println("Угадай слово");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int numElem = rand.nextInt(words.length);
        String otvet;
        char [] c = new char[15];
//        System.out.println(words[numElem]);
        do {
        otvet = getOtvet("Угадай слово из списка", words);
        if (otvet.equals(words[numElem])) {
            System.out.println("Угадал");
            break;
        } else {
            if (otvet.length() <= words[numElem].length()) {
                for (int i = 0; i < otvet.length(); i++) {
                    if (otvet.charAt(i) == words[numElem].charAt(i)) {
                        c[i] = otvet.charAt(i);
                    } else {
                        c[i] = '#';
                    }
                }
                for (int i = otvet.length(); i < 15; i++) {
                    c[i] = '#';
                }
            } else {
                for (int i = 0; i < words[numElem].length(); i++) {
                    if (otvet.charAt(i) == words[numElem].charAt(i)) {
                        c[i] = otvet.charAt(i);
                    } else {
                        c[i] = '#';
                    }
                }
                for (int i = words[numElem].length(); i < 15; i++) {
                    c[i] = '#';
                }
            }
            System.out.println("Не угадал");
            System.out.println(c);
        }
        } while (true);
        sc.close();
    }

    public static String getOtvet(String text, String[] slova) {
        String a;
        System.out.println(text);
        System.out.println(Arrays.toString(slova));
        a = sc.next();
        return a;
    }

    public static int getNumber (String zadanie, int min, int max) {
        int x;
        System.out.println(zadanie);
        do {
            x = sc.nextInt();
            if (x < min || x > max) {
                System.out.println("Введи число в заданных пределах");
            }
        } while (x < min || x > max);
        return x;
    }
}
