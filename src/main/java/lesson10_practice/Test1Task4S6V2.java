package lesson10_practice;

public class Test1Task4S6V2 {
    public static void main(String[] args) {

        /*
        Write a method that by given 2D labyrinth represented as matrix filled with
        'W' for walls and ' ' (space) for empty cell, returns the number of steps to exit the
        labyrinth. You cannot pass through walls and you can move only up, down, left or
        right. If there is no way to escape the labyrinth, then -1 should be returned as a result.
         */

        String[][] matrix = {
                {" ", "S", " ", "W", " "},
                {"W", " ", " ", "W", " "},
                {" ", "W", " ", " ", "W"},
                {" ", " ", "W", "E", " "},
        };

//        String[][] matrix = {
//                {"W", "S", "W", " ", " "},
//                {" ", "W", " ", " ", " "},
//                {" ", " ", " ", " ", " "},
//                {" ", " ", " ", "E", " "},
//        };
        //returns -1

        if (!validateCoordinates(3, 3, matrix)) {
            System.out.println("Invalid coordinates of end!");
            return;
        }
        System.out.println(findNumberOfStepsFromStartToEnd(matrix, 0, 1, 3, 3));
    }

    private static int findNumberOfStepsFromStartToEnd(String[][] matrix, int sI, int sJ, int eI, int eJ) {
        if (!validateCoordinates(sI, sJ, matrix) || matrix[sI][sJ].equals("W")) {
            return -1;
        }

        if (sI == eI && sJ == eJ) {
            return 0;
        }

        matrix[sI][sJ] = "W";
        int first = findNumberOfStepsFromStartToEnd(matrix, sI - 1, sJ, eI, eJ);

        if (first != - 1){
            return  first + 1;
        }

        int second = findNumberOfStepsFromStartToEnd(matrix, sI, sJ + 1, eI, eJ);

        if (second != -1){
            return  second + 1;
        }

        int third = findNumberOfStepsFromStartToEnd(matrix, sI + 1, sJ, eI, eJ);

        if (third != -1){
            return  third + 1;
        }

        int fourth = findNumberOfStepsFromStartToEnd(matrix, sI, sJ - 1, eI, eJ);

        if (fourth != -1){
            return fourth + 1;
        }

        return  -1;
    }

    private static boolean validateCoordinates(int i, int j, String[][] matrix) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
