package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class var2 {
    static int SIZE_X = 5;
    static int SIZE_Y = 5;

    static char[][] field = new char[SIZE_Y][SIZE_X];

    static char PLAYER_DOT = 'X';
    static char AI_DOT = 'O';
    static char EMPTY_DOT = '.';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // заполнить поле
    private static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // метод для вывода на консоль поля
    private static void printField() {
        System.out.print("  ");
        for (int j = 0; j < SIZE_X; j++) {
            System.out.print(j+1 + "|");
        }
        System.out.println();
        System.out.println(" -----------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(i+1);
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }

    // метод для установки символа
    private static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    // проверка валидности ячейки
    private static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    // ход человека
    private static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X Y (1 - 3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y,x));
        setSym(y, x, PLAYER_DOT);
    }

    // ход ПК
    private static void aiStep() {
        int x;
        int y;
        boolean flag = false;
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, PLAYER_DOT);
                    if (checkWin(PLAYER_DOT)) {
                        setSym(i, j, AI_DOT);
                        flag = true;
                        break;
                    } else {
                        setSym(i, j, AI_DOT);
                        if (checkWin(AI_DOT)) {
                            flag = true;
                            break;
                        } else {
                            setSym(i, j, EMPTY_DOT);
                        }
                    }
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag == false) {
            do {
                x = random.nextInt(SIZE_X);
                y = random.nextInt(SIZE_Y);
            }
            while (!isCellValid(y, x));
            setSym(y, x, AI_DOT);
        }
    }

    /*
     * если не встретили пустую ячейку
     * это значит что все поле заполнено
     * */
    private static boolean isDraw() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char sym) {
        int k = 0;
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (field[i][j] == sym) {
                    k++;
                } else {
                    if (k >= 4) {
                        return true;
                    } else {
                        k = 0;
                        continue;
                    }
                }
            }
            if (k >= 4) {
                return true;
            } else {
                k = 0;
            }
        }
        k = 0;
        for (int j = 0; j < SIZE_Y; j++) {
            for (int i = 0; i < SIZE_X; i++) {
                if (field[i][j] == sym) {
                    k++;
                } else {
                    if (k >= 4) {
                        return true;
                    } else {
                        k = 0;
                        continue;
                    }
                }
            }
            if (k >= 4) {
                return true;
            } else {
                k = 0;
            }
        }

        k = 0;
        for (int i = 0; i < SIZE_X; i++) {
            if (field[i][i] == sym) {
                k++;
            } else {
               continue;
            }
        }
        if (k >= 4) {
            return true;
        }
        k = 0;
        for (int i = 0; i+1 < SIZE_X; i++) {
            if (field[i+1][i] == sym) {
                k++;
            } else {
                break;
            }
        }
        if (k == 4) {
            return true;
        }
        k = 0;
        for (int i = 0; i+1 < SIZE_X; i++) {
            if (field[i][i+1] == sym) {
                k++;
            } else {
                break;
            }
        }
        if (k == 4) {
            return true;
        }
        k = 0;
        for (int i = SIZE_X - 1; i >= 0; i--) {
            if (field[i-1][i] == sym) {
                k++;
            } else {
                break;
            }
        }
        if (k == 4) {
            return true;
        }
        k = 0;
        for (int i = SIZE_X - 1, j = 0; i-1 >= 0; i--, j ++) {
            if (field[i-1][j] == sym) {
                k++;
            } else {
                break;
            }
        }
        if (k == 4) {
            return true;
        }
        k = 0;
        for (int i = SIZE_X - 1, j = 0; j+1 < SIZE_Y; i--, j ++) {
            if (field[i][j+1] == sym) {
                k++;
            } else {
                break;
            }
        }
        if (k == 4) {
            return true;
        }
        k = 0;
        for (int j = 0, i = SIZE_X - 1; j < SIZE_Y; i--, j++) {
            if (field[i][j] == sym) {
                k++;
            } else {
                k = 0;
                continue;
            }
        }
        if (k >= 4) {
            return true;
        }



//        if (field[0][0] == sym && field[0][1] == sym && field[0][2] == sym) {
//            return true;
//        }
//        if (field[1][0] == sym && field[1][1] == sym && field[1][2] == sym) {
//            return true;
//        }
//        if (field[2][0] == sym && field[2][1] == sym && field[2][2] == sym) {
//            return true;
//        }
//
//        if (field[0][0] == sym && field[1][0] == sym && field[2][0] == sym) {
//            return true;
//        }
//        if (field[0][1] == sym && field[1][1] == sym && field[2][1] == sym) {
//            return true;
//        }
//        if (field[0][2] == sym && field[1][2] == sym && field[2][2] == sym) {
//            return true;
//        }
//
//        if (field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) {
//            return true;
//        }
//        if (field[2][0] == sym && field[1][1] == sym && field[0][2] == sym) {
//            return true;
//        }

        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();
            if(checkWin(PLAYER_DOT)) {
                System.out.println("Player WIN!");
                break;
            }
            if(isDraw()) {
                System.out.println("DRAW");
                break;
            }

            aiStep();
            printField();
            if(checkWin(AI_DOT)) {
                System.out.println("SKYNET WIN!");
                break;
            }
            if(isDraw()) {
                System.out.println("DRAW");
                break;
            }
        }
    }


}

