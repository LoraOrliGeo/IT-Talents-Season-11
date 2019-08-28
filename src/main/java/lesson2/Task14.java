package lesson2;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstRow = sc.nextInt();
        int firstCol = sc.nextInt();

        int secondRow = sc.nextInt();
        int secondCol = sc.nextInt();

        // if the row is a odd number (1,3,5,7) -> the black cells are those with odd col position
        // if the row is an even number (2,4,6,8) -> the black cells are those with even col position

        if (areBothEvenOrOdd(firstRow, secondRow)) {
            if (areBothEvenOrOdd(firstCol, secondCol)) {
                printSameColorMessage();
            } else {
                printDifferentColorMessage();
            }
        } else {
            if (!areBothEvenOrOdd(firstCol, secondCol)) {
                printSameColorMessage();
            } else {
                printDifferentColorMessage();
            }
        }
    }

    private static boolean areBothEvenOrOdd(int firstCol, int secondCol) {
        return (!isEven(firstCol) && !isEven(secondCol)) || (isEven(firstCol) && isEven(secondCol));
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printSameColorMessage() {
        System.out.println("The positions are with same color!");
    }

    private static void printDifferentColorMessage() {
        System.out.println("The positions are with different color!");
    }
}
