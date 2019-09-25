package lesson10_practice;

public class Test1Task4S6V3 {
    public static void main(String[] args) {

        /*
        Write a method that finds whether there is path between two given cells in
        2D labyrinth. The method takes 5 parameters – the coordinates of the two cells and the
        labyrinth itself. The labyrinth has walls marked with symbol 'W', that you cannot pass
        through. The other cells are marked with ' '. The method must return true or false
        depending on whether there is a path between start and end cells.
         */

        String[][] matrix = {
                {" ", "S", " ", "W", " "},
                {"W", " ", " ", "W", " "},
                {" ", "W", " ", " ", "W"},
                {" ", " ", "W", "E", " "},
        };
        // result true

//        String[][] matrix = {
//                {" ", "S", " ", " ", " "},
//                {" ", " ", "W", " ", " "},
//                {"W", " ", " ", " ", " "},
//                {" ", " ", "W", "W", "W"},
//                {" ", "W", " ", "E", " "}
//        };
        // result false

        int sI = 0;
        int sJ = 1;
        int eI = 3;
        int eJ = 3;

        if (!validateCoordinates(matrix, sI, sJ) || !validateCoordinates(matrix, eI, eJ)) {
            System.out.println("Invalid coordinates!");
            return;
        }

        System.out.println(canFindPathBetweenStartAndEnd(matrix, sI, sJ, eI, eJ));
    }

    private static boolean canFindPathBetweenStartAndEnd(String[][] matrix, int sI, int sJ, int eI, int eJ) {
        // for the current cell check to where you can move
        //if the cell is out of bounds -> return false
        //if it's valid cell -> check if it's wall/end
        // if the cell is not a wall and it's not end
        // mark your current position as visited
        // move to the new cell -> return same function for the new coordinates (recursion)
        // if the cell is wall -> return false
        // if new coordinates are "E" -> return true;

//        int[] moveOne = {sI - 1, sJ};
//        int[] moveTwo = {sI, sJ + 1};
//        int[] moveThree = {sI + 1, sJ};
//        int[] moveFour = {sI, sJ - 1};

        if (startEqualsEnd(sI, sJ, eI, eJ)) {
            System.out.println(String.format("[%d, %d]", eI, eJ));
            return true;
        }

        matrix[sI][sJ] = "W";

        if (validateCoordinates(matrix, sI - 1, sJ) &&
                !matrix[sI - 1][sJ].equals("W") &&
                canFindPathBetweenStartAndEnd(matrix, sI - 1, sJ, eI, eJ)) {
            System.out.println(String.format("[%d, %d]", sI, sJ));
            return true;
        }

        if (validateCoordinates(matrix, sI, sJ + 1) &&
                !matrix[sI][sJ + 1].equals("W") &&
                canFindPathBetweenStartAndEnd(matrix, sI, sJ + 1, eI, eJ)) {
            System.out.println(String.format("[%d, %d]", sI, sJ));
            return true;
        }

        if (validateCoordinates(matrix, sI + 1, sJ) &&
                !matrix[sI + 1][sJ].equals("W") &&
                canFindPathBetweenStartAndEnd(matrix, sI + 1, sJ, eI, eJ)) {
            System.out.println(String.format("[%d, %d]", sI, sJ));
            return true;
        }

        if (validateCoordinates(matrix, sI, sJ - 1) &&
                !matrix[sI][sJ - 1].equals("W") &&
                canFindPathBetweenStartAndEnd(matrix, sI, sJ - 1, eI, eJ)) {
            System.out.println(String.format("[%d, %d]", sI, sJ));
            return true;
        }

        return false;
    }

    public static boolean validateCoordinates(String[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    public static boolean startEqualsEnd(int sI, int sJ, int eI, int eJ) {
        return sI == eI && sJ == eJ;
    }
}
