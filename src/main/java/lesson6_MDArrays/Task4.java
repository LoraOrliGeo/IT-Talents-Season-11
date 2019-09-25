package lesson6_MDArrays;

public class Task4 {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] rotated = new int[matrix.length][matrix[0].length];
        int index = 0;

        for (int i = matrix.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                rotated[j][index] = matrix[i][j];
            }
            index++;
        }

        System.out.println("The matrix rotated +90° is:");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }
}
