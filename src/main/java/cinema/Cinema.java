package cinema;

import java.util.Scanner;

public class Cinema {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {

        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }

        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();

        System.out.println("Total income:");
        if(rows * seats <= 60) {
            System.out.println("$" + (rows * seats * 10));
        } else {
            int frontRows = rows / 2;
            System.out.println("$" + ((frontRows * seats * 10) + ((rows - frontRows) * seats * 8)));
        }
    }
}
