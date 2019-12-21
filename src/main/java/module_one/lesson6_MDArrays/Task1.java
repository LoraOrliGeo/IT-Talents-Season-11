package module_one.lesson6_MDArrays;

public class Task1 {
    public static void main(String[] args) {

        int[][] matrix = {
                {48, 72, -15, 14, 15},
                {21, 22, 53, 24, 75},
                {31, 57, 33, 34, 35},
                {41, 165, 43, 44, 45},
                {59, 52, 53, 54, 55},
                {61, 69, 63, 64, 65},
        };

        int minValue = matrix[0][0];
        int maxValue = matrix[0][0];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int curr = matrix[row][col];

                if (curr <= minValue){
                    minValue = curr;
                } else if (curr >= maxValue){
                    maxValue = curr;
                }
            }
        }

        System.out.println("Element with min value: " + minValue);
        System.out.println("Element with max value: " + maxValue);

    }
}
