package module_one.lesson7_practice;

public class Task11 {
    public static void main(String[] args) {

        /*
        1 2 3 4 5
        6 7 8 9 10
        11 12 13 14 15
        16 17 18 19 20
         */

        int n = 4;
        int m = 5;

        int[][] matrix = new int[n][m];
        int count = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = count++;
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
