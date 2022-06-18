package cinema;

import java.util.Scanner;


public class Calculator {

    public static int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(gcd(1, 1));

        System.out.println(gcd(1, 1));

        System.out.println(gcd(1, 1));

        System.out.println(gcd(1, 1));

    }
}
