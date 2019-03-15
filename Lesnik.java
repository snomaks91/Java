package Lesson_5;

import java.util.Arrays;
import java.util.Scanner;

public class Lesnik {

    public static Scanner sc = new Scanner(System.in);

    public static int[] checkMas () {

        // Данные вводятся в строку, при копировании из доп.дз. читает только первую строку

        String arr[] = sc.nextLine().split(" ");
        sc.close();
        int[] mas = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mas[i] = Integer.parseInt(arr[i]);
        }
        return mas;
    }

    public static void countEqual (int[] mas) {
        int k = 1;
        int count = 0;
        int[] rez = new int[20];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 20) {
                continue;
            }
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[j] > 20) {
                    continue;
                }
                if (mas[j] == mas[i]) {
                    k++;
                    mas[j] = 100;
                }
            }
            rez[count] = k;
            k = 1;
            count++;
        }
        System.out.print(Arrays.toString(rez));
    }

    public static void main(String[] args) {
        countEqual(checkMas());
    }
}
