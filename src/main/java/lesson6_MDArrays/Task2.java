package lesson6_MDArrays;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter size of the square 2D array:");
            size = sc.nextInt();
        } while (size <= 0);

        int[][] matrix = new int[size][size];

        System.out.println("Enter elements:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        System.out.println("Elements on main diagonal:"); // row = col
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }

        System.out.println();
        System.out.println("Elements on secondary diagonal:"); // row + col = matrix.length -1
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row + col == matrix.length - 1){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }
}
