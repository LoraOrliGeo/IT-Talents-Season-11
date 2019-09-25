package lesson7_practice;

public class Task7 {
    public static void main(String[] args) {

        int[][] matrix = {
                {5,2,16,4,3},
                {2,3,16,3,9},
                {1,1,18,3,1},
                {2,1,1,8,10},
                {1,1,1,1,9}
        };

        int res = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                res *= matrix[row][col];
            }
        }

        System.out.println("The product of multiplying " +
                "all elements below main diagonal is: " + res);

    }
}
