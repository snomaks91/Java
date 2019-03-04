package Lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 2;
        System.out.println("Задание 1:");
        zamena();
        System.out.println();
        System.out.println();
        System.out.println("Задание 2:");
        zapolnenie();
        System.out.println();
        System.out.println();
        System.out.println("Задание 3:");
        umnojenie();
        System.out.println();
        System.out.println();
        System.out.println("Задание 4:");
        zapolnDiag();
        System.out.println();
        System.out.println("Задание 5:");
        minMax();
        System.out.println();
        System.out.println("Задание 6:");
        System.out.println(sravnSumm(arr));
        System.out.println();
        System.out.println("Задание 7:");
        smest(arr, n);
        System.out.println();
        System.out.println("Доп. задание 1:");
        nechet();
        System.out.println();
        System.out.println();
        System.out.println("Доп. задание 2:");
        kollChetn();
        System.out.println();
        System.out.println("Доп. задание 3:");
        srAr();
    }

    public static void zamena() {
        int arr[] = {0, 1, 1, 0, 1, 0, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void zapolnenie() {
        int arr[] = new int[8];
        int a = 0;
        for (int i = 0; i < 8; i++) {
            arr[i] = a;
            a += 3;
            System.out.print(arr[i] + " ");
        }
    }

    public static void umnojenie() {
        int arr[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8 ,9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.print(arr[i] + " ");
        }
    }

    public static void zapolnDiag() {
        int arr[] [] = new int [5] [5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    arr[i] [j] = 1;
                } else {
                    arr[i] [j] = 0;
                }
                System.out.print(arr[i] [j] + " ");
            }
            System.out.println();
        }
    }

    public static void minMax() {
        int arr[] = {5, 2, 0, 8 ,15 ,65, -11, 7 ,9};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("min= " + min);
        System.out.println("max= " + max);
    }

    public static boolean sravnSumm(int arr[]) {
        boolean rez;
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            for (int j = i +1; j < arr.length; j++) {
                sum2 += arr[j];
            }
            if (sum == sum2) {
                rez = true;
                return rez;
            }
            sum2=0;
        }
        rez = false;
        return rez;
    }

    public static void smest (int arr[], int n) {

        int l = arr.length;
        int m, sch1 = 0, sch2 = 0;
        int o = 0;
        int j = 0;
        if (n == 0) {
            System.out.println(Arrays.toString(arr));
        } else {
            if (n >= l) {
                System.out.println("Дальше элементов нет");
            } else {
                if (n < 0) {
                    n *= -1;
                }
                for (int i = n; i < l; i += n) {
                    while (j < n) {
                        if (i >= l) {
                            break;
                        }
                        m = arr[i];
                        arr[i] = arr[j];
                        arr[j] = m;
                        j++;
                        i++;
                    }
                    i -= j;
                    o = j - 1;
                    j = 0;
                }
//       Круговой массив с переносом элементов, но пока работает немного некорректно (закончились идеи)
//                if (o != n - 1) {
//                    for (int i = 0; i <= o; i++) {
//                        sch1 += 1;
//                    }
//                    for (int i = o + 1; i < n; i++) {
//                        sch2 += 1;
//                    }
//                    j = o + 1;
//                    if (sch1 > sch2) {
//                        for (int i = 0; i < n - 1; i++) {
//                            if (i - j == sch1 - sch2) {
//                                break;
//                            }
//                            if (i > j) {
//                                for (j = i; j < n - 1; j++) {
//                                    m = arr[j];
//                                    arr[j] = arr[j + 1];
//                                    arr[j + 1] = m;
//                                }
//                                break;
//                            }
//                            while (j < n) {
//                                m = arr[i];
//                                arr[i] = arr[j];
//                                arr[j] = m;
//                                j++;
//                                i++;
//                                if (i >= n) {
//                                    break;
//                                }
//                            }
//                            i--;
//                            j = o + 1;
//                        }
//                    } else {
//                        j = 0;
//                            for (int i = o + 1; i < n; i++) {
//                                m = arr[i];
//                                arr[i] = arr[j];
//                                arr[j] = m;
//                                if (i == n - 1) {
//                                    if (sch2 % sch1 == 0) {
//                                        break;
//                                    }
//                                    i = n - 3;
//                                    if (i == j) {
//                                        if (i % 2 != 0) {
//                                            break;
//                                        }
//                                        i++;
//                                        m = arr[i];
//                                        arr[i] = arr[i + 1];
//                                        arr[i + 1] = m;
//                                        break;
//                                    }
//                                    if (sch1 == sch2) {
//                                        break;
//                                    }
//                                }
//                                j++;
//                                if (j == n - 1) {
//                                    break;
//                                }
//                             }
//                    }
                for (int i = 0; i < n; i++) {   // Заполнение нулями
                    arr[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void nechet() {
        int arr[] = new int[50];
        for (int i = 0, j = 1; j < 100; i++, j+=2) {
            arr[i] = j;
            System.out.print(arr[i] + " ");
        }
    }

    public static void kollChetn() {
        int arr[] = new int[15];
        int chetn = 0;
        for (int i = 0; i < 15; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.print(arr[i] + " ");
            if (arr[i] % 2 == 0) {
                chetn++;
            }
        }
        System.out.println();
        System.out.println("Количество четных элементов = " + chetn);
    }

    public static void srAr() {
        int arr1[] = new int[5];
        int arr2[] = new int[5];
        float srAr1 = 0;
        float srAr2 = 0;
        for (int i = 0; i < 5; i++) {
            arr1[i] = (int) (Math.random() * 6);
            arr2[i] = (int) (Math.random() * 6);
            srAr1 += arr1[i];
            srAr2 += arr2[i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        srAr1 /= 5;
        srAr2 /= 5;
        System.out.println("Среднее арифметическое первого массива = " + srAr1);
        System.out.println("Среднее арифметическое второго массива = " + srAr2);
        if (srAr1 > srAr2) {
            System.out.println("Первое больше");
        } else {
            if (srAr1 < srAr2) {
                System.out.println("Второе больше");
            } else {
                System.out.println("Равны");
            }
        }

    }
}
