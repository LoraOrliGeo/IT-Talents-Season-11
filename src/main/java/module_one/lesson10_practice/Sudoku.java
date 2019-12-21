package module_one.lesson10_practice;

public class Sudoku {

    private static int[][] sudoku = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    public static void main(String[] args) {

        // check if a currNum [1...9] could be placed in cell - it should not be
        // in currRow, currCol and curSubgrid (3x3)
        // if the number is already in a row/col/subgrid -> check the next number
        // else -> place the number in the cell

        if (isSolved()) {
            printSudoku();
        } else {
            System.out.println("No solution!");
        }
    }

    public static boolean isSolved() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // empty cell
                if (sudoku[row][col] == 0) {
                    // check every digit from 1 to 9
                    for (int number = 1; number <= 9; number++) {
                        // check row/col/subgrid
                        if (isSafeToPutANum(row, col, number)) {
                            sudoku[row][col] = number;

                            // recursion here ?
                            // for each empty cell -> check the numbers 1...9 again
                            // if all the cells are not empty and
                            // the solution is correct -> return true
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean isSafeToPutANum(int row, int col, int number) {
        // check the row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
                return false;
            }
        }

        // check the col
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == number) {
                return false;
            }
        }

        // check 3x3 subgrid
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i <= r + 2; i++) {
            for (int j = c; j <= c + 2; j++) {
                if (sudoku[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
