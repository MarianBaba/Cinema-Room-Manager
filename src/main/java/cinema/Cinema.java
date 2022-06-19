package cinema;

import java.util.Scanner;

public class Cinema {
    private final static Scanner scanner = new Scanner(System.in);
    private static int rows;
    private static int seats;
    private static char[][] cinema;
    private static boolean isFinished = false;

    private static int purchasedTickets = 0;
    private static float percentage = 0.0f;
    private static int currentIncome = 0;

    private static void showMenu() {
        System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
        int decision = scanner.nextInt();
        switch (decision) {
            case 0: {
                isFinished = true;
                break;
            }
            case 1: {
                showSeats();
                break;
            }
            case 2: {
                buyTicket();
                break;
            }
            case 3: {
                showStats();
                break;
            }
            default: {
                System.out.println("Select an action");
                break;
            }
        }
    }

    private static void showSeats() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seats; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void buyTicket() {

        boolean isValid = false;
        int desiredRow = Integer.MIN_VALUE;
        int desiredColumn;

        while(!isValid) {
            System.out.println("Enter a row number:");
            desiredRow = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            desiredColumn = scanner.nextInt() - 1;

            if ((desiredRow >= 0 && desiredRow <= rows - 1) && (desiredColumn >= 0 && desiredColumn <= seats - 1)) {
                if (cinema[desiredRow][desiredColumn] == 'B') {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    isValid = true;
                    cinema[desiredRow][desiredColumn] = 'B';
                    purchasedTickets++;
                }
            } else {
                System.out.println("Wrong input!");
            }
        }

        System.out.println(desiredRow);

        if (rows * seats <= 60) {
            System.out.println("Ticket price: $10");
            currentIncome += 10;
        } else {
            if (desiredRow + 1 <= rows/2) {
                System.out.println("Ticket price: $10");
                currentIncome += 10;
            } else {
                System.out.println("Ticket price: $8");
                currentIncome += 8;
            }
        }
    }

    private static void showStats() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);

        percentage = ((float) purchasedTickets / (float) (rows * seats)) * 100.0f;
        System.out.printf("Percentage: %.2f", percentage);
        System.out.print("%");
        System.out.println();

        System.out.println("Current income: $" + currentIncome);

        int totalIncome = totalIncome(rows, seats);
        System.out.println("Total income: $" + totalIncome);
    }

    private static int totalIncome(int rows, int seats) {

        int res = 0;

        if (rows * seats <= 60) {
            res = rows * seats * 10;
        } else {
            int front = rows / 2;
            int back = rows - front;
            res = (front * seats * 10) + (back * seats * 8);
        }

        return res;
    }

    /*public static void kConsecutives() {

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
    */

    public static void main(String... args) {

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row::");
        seats = scanner.nextInt();

        cinema = new char[rows][seats];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < seats; j++) {
                cinema[i][j] = 'S';
            }
        }

        while (!isFinished) {
            showMenu();
        }
    }
}
