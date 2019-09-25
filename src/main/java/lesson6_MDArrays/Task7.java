package lesson6_MDArrays;

public class Task7 {
    public static void main(String[] args) {

        int[][] matrix = {
                {11, 12, 13, 14, 15, 16},
                {21, 22, 23, 24, 25, 26},
                {31, 32, 33, 34, 35, 36},
                {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56},
                {61, 62, 63, 64, 65, 66}
        };

        int index;
        int totalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            if ((row + 1) % 2 == 0) {
                index = 1;
            } else {
                index = 0;
            }

            System.out.print(matrix[row][index] + " " +
                    matrix[row][index + 2] + " " + matrix[row][index + 4]);
            System.out.println(" sum or row elements: " +
                    (matrix[row][index] + matrix[row][index + 2] + matrix[row][index + 4]));
            totalSum += matrix[row][index] + matrix[row][index + 2] + matrix[row][index + 4];
        }

        System.out.println("Sum of elements: " + totalSum);
    }
}
