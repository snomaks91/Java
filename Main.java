package Lesson_1;

public class Main {


    public static void main(String[] args) {
        byte e = 100;
        short r = 1000;
        int a = 2, b = 10, c = 2100, d = 300;
        long l = 200L;
        float x = 10.5f;
        double w = 12.154;
        String q = "Maks";
        boolean m = true;
        System.out.println(rez(a, b, c, d));
        System.out.println(prov(a, b));
        znak(a);
        System.out.println(znakmin(a));
        name (q);
        god(c);
    }


    public static int rez(int a, int b, int c, int d) {
        return a * (b + c / d);
    }


    public static boolean prov(int a, int b) {
        boolean c;
        if ((a + b) >= 10 && (a + b) <= 20) {
            c = true;
            return c;
        } else {
            c = false;
            return c;
        }
    }

    public static void znak(int a) {
        if (a >= 0) {
            System.out.println("а - Положиельное");
        } else {
            System.out.println("a - Отрицательное");
        }
    }

    public static boolean znakmin(int a) {
        boolean o = false;
        if (a < 0) o = true;
        return o;
    }

    public static void name (String a) {
        System.out.println("Hello " + a);
    }

    public static void god (int a) {
        if (((a%4) == 0) || ((a%400) == 0)) {
            if (((a%100) == 0) && (a%400 == 0)){
                System.out.println("DA");
            } else {
                if (((a%4) == 0) && ((a%100) != 0)) {
                    System.out.println("Da");
                } else System.out.println("NET");
            }
        }
        else System.out.println("NET");
    }
}

