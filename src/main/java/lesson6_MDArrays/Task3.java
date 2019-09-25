package lesson6_MDArrays;

public class Task3 {
    public static void main(String[] args) {

        int[][] matrix = {
                {5,-5,10,26,0},
                {35,7,-7,9},
                {-4,-6,55,18,4},
                {3,15,9,-3,26},
        };

        int sum = 0;
        int totalElements = 0;

        /* int totalElements = matrix.length * matrix[0].length ->
        it won't be working if the matrix is not rectangular
        */

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
                totalElements++;
            }
        }

        System.out.println("Sum of all elements: " + sum);

        double avg = sum * 1.0 / totalElements;

        System.out.println("Average value: " + avg);
    }
}
