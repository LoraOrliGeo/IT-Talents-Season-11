package module_one.lesson7_practice;

public class Task9 {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, -5, 2, 13, -2},
                {0, 2, 3, 15, -1},
                {-3, 0, 7, 9, 5}
        };

        int maxSum = Integer.MIN_VALUE; // = matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1]
        int indexI = 0;
        int indexJ = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (currSum >= maxSum){
                    maxSum = currSum;
                    indexI = i;
                    indexJ = j;
                }
            }
        }

        System.out.println("Max submatrix 2x2 is:");
        System.out.println(matrix[indexI][indexJ] + " " + matrix[indexI][indexJ + 1]);
        System.out.println(matrix[indexI + 1][indexJ] + " " + matrix[indexI + 1][indexJ + 1]);
    }
}
