package module_one.lesson6_MDArrays;

public class Task6 {
    public static void main(String[] args) {

        int[][] matrix = {
                {11, 12, 13, 14, 15, 16},
                {21, 22, 23, 24, 25, 26},
                {31, 32, 33, 34, 35, 36},
                {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56},
                {61, 62, 63, 64, 65, 66}
        };

        int totalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if ((i + 1) % 2 == 0) {
                int sum = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j];

                    if (j == matrix[i].length - 1){
                        System.out.print(matrix[i][j]);
                    } else {
                        System.out.print(matrix[i][j] + ", ");
                    }
                }
                totalSum += sum;
                System.out.print(" has sum of " + sum);
                System.out.println();
            }
        }

        System.out.println("Total sum of elements = " + totalSum);
    }
}
