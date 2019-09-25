package lesson7_practice;

public class Task14 {
    public static void main(String[] args) {

        /*
        1 8 9 16 17
        2 7 10 15 18
        3 6 11 14 19
        4 5 12 13 20
         */

        int n = 4;
        int m = 5;

        int[][] matrix = new int[n][m];
        int count = 1;

        for (int i = 0; i < matrix[0].length; i++) {
            if (i % 2 == 0){
                int j = 0;
                while (j < matrix.length){
                    matrix[j][i] = count++;
                    j++;
                }
            } else {
                int j = matrix.length - 1;
                while (j >= 0){
                    matrix[j][i] = count++;
                    j--;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
