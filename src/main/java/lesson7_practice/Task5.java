package lesson7_practice;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows, cols;

        do {
            System.out.println("Enter number of rows and cols:");
            rows = sc.nextInt();
            cols = sc.nextInt();
        } while (rows <= 0 || cols <= 0);

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter elements:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int maxSum = 0;
        int rowWithMaxSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            int sumCurrRow = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                sumCurrRow += matrix[i][j];
            }

            // i == 0 -> if there are negative numbers -> first maxSum will be the sum for the first row
            if (sumCurrRow >= maxSum || i == 0){
                maxSum = sumCurrRow;
                rowWithMaxSum = i;
            }
        }

        System.out.println("Row with max sum is " + rowWithMaxSum + " -> " + maxSum);
    }
}
