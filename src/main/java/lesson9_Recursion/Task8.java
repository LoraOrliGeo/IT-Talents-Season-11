package lesson9_Recursion;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {

        /*
         По зададено число n, да се изведе на екрана таблица по
        следния начин:
        Въведете n:
        2
        11
        33
        Въведете n:
        3
        222
        444
        666
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int n = sc.nextInt();

        int digit = n - 1;

        printTable(n, digit, 0);

    }

    public static void printTable(int times, int digit, int rowCount) {
        if (rowCount == times) { // base case
            return;
        }

        String row = printRow(digit, times); // do what it has to do

        rowCount++;
        System.out.println(row);
        printTable(times, digit + 2, rowCount); // step
    }

    public static String printRow(int digit, int times){
        String row = "";
        for (int j = 1; j <= times; j++) {
            row += digit + "";
        }
        return row;
    }
}
