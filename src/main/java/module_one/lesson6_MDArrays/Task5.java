package module_one.lesson6_MDArrays;

public class Task5 {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        int maxRowSum = 0;
        int maxColSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            int currSumRow = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                currSumRow += matrix[row][col];
            }

            if (currSumRow >= maxRowSum || row == 0) {
                maxRowSum = currSumRow;
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            int currColSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                currColSum += matrix[row][col];
            }

            if (currColSum >= maxColSum) {
                maxColSum = currColSum;
            }
        }

        System.out.println("Max row sum = " + maxRowSum);
        System.out.println("Max col sum = " + maxColSum);

        if (maxRowSum > maxColSum) {
            System.out.println("Max row sum > max col sum");
        } else if (maxColSum > maxRowSum) {
            System.out.println("Max col sum > max row sum");
        } else {
            System.out.println("Max row sum = max col sum");
        }

    }
}
