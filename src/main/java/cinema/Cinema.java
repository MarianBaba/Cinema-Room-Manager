package cinema;

import java.util.Scanner;

public class Cinema {

    private final static Scanner scanner = new Scanner(System.in);

    public static void kConsecutives() {

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] inp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                inp[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();
        boolean found = false;
        int count = 0;
        int row = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!found){
                    if(inp[i][j]==0)count++;
                    else count = 0;
                    if(k==count){
                        found = true;
                        row = i+1;
                    }
                }
            }
            count = 0;
        }
        System.out.println(row);


    }


    public static void main(String... args) {

//        kConsecutives();

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row::");
        int seats = scanner.nextInt();

        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 0; i < seats; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Enter a row number:");
        int desiredRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int desiredColumn = scanner.nextInt();

        if (rows * seats <= 60) {
            System.out.println("Ticket price: $10");
        } else {
            if (desiredRow <= rows/2) {
                System.out.println("Ticket price: $10");
            } else {
                System.out.println("Ticket price: $8");
            }
        }

        System.out.println("Cinema:");

        System.out.print("  ");
        for (int i = 0; i < seats; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                if (i == desiredRow - 1 && j == desiredColumn - 1) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }



        /*
        System.out.println("Total income:");
        if(rows * seats <= 60) {
            System.out.println("$" + (rows * seats * 10));
        } else {
            int frontRows = rows / 2;
            System.out.println("$" + ((frontRows * seats * 10) + ((rows - frontRows) * seats * 8)));
        }
        */
    }
}
