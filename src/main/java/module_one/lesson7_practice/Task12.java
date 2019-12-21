package module_one.lesson7_practice;

public class Task12 {
    public static void main(String[] args) {

        /*
        1 5 9 13 17
        2 6 10 14 18
        3 7 11 15 19
        4 8 12 16 20
         */

        int n = 4;
        int m = 5;

        int[][] matrix = new int[n][m];
        int count = 1;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = count++;
            }
        }

        //another way:
//        int firstRowEl = 1;
//        for (int i = 0; i < matrix.length; i++) {
//            int firstColEl = firstRowEl;
//            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = firstColEl;
//                firstColEl += n;
//            }
//            firstRowEl++;
//        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
