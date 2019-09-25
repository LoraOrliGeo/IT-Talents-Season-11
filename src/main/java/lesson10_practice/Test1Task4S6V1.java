package lesson10_practice;

public class Test1Task4S6V1 {
    public static void main(String[] args) {

        /*
        Write a method that by given chessboard filled with figures on some squares,
        coordinates of knight (horse) and king, finds whether the knight can reach the king.
        The knight can move only on "Г"-shaped moves. The method must return true/false.
        Te other figures are marked with "X" on the board and the empty squares are
        marked with " " (space).
         */

        char[][] chessboard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'H', ' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'X', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' '},
                {' ', ' ', 'X', ' ', ' ', 'K', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        int hI = 1;
        int hJ = 2;
        int kI = 6;
        int kJ = 5;

        boolean canTakeKing = canHorseTakeKing(chessboard, hI, hJ, kI, kJ);
        System.out.println(canTakeKing); // true
    }

    private static boolean canHorseTakeKing(char[][] chessboard, int hI, int hJ, int kI, int kJ) {
        // in case of index out of bounds ot "X" figure -> return false
        // in case of reaching the king -> return true

        // possible moves of the horse:
        int[] firstMove = {hI - 2, hJ - 1};
        int[] secondMove = {hI - 2, hJ + 1};
        int[] thirdMove = {hI - 1, hJ + 2};
        int[] fourthMove = {hI + 1, hJ + 2};
        int[] fifthMove = {hI + 2, hJ + 1};
        int[] sixthMove = {hI + 2, hJ - 1};
        int[] seventhMove = {hI + 1, hJ - 2};
        int[] eighthMove = {hI - 1, hJ - 1};

        // if the move is valid -> mark current cell of the horse as "X"
        // call the function with the new coordinates

        if (isInvalidCell(hI, hJ)) {
            return false;
        }

        if (chessboard[hI][hJ] == 'X') {
            return false;
        }

        if (hI == kI && hJ == kJ) {
            return true;
        }

        chessboard[hI][hJ] = 'X';
        boolean jumpFirstMove = canHorseTakeKing(chessboard, firstMove[0], firstMove[1], kI, kJ);
        boolean jumpSecondMove = canHorseTakeKing(chessboard, secondMove[0], secondMove[1], kI, kJ);
        boolean jumpThirdMove = canHorseTakeKing(chessboard, thirdMove[0], thirdMove[1], kI, kJ);
        boolean jumpFourthMove = canHorseTakeKing(chessboard, fourthMove[0], fourthMove[1], kI, kJ);
        boolean jumpFifthMove = canHorseTakeKing(chessboard, fifthMove[0], fifthMove[1], kI, kJ);
        boolean jumpSixthMove = canHorseTakeKing(chessboard, sixthMove[0], sixthMove[1], kI, kJ);
        boolean jumpSeventhMove = canHorseTakeKing(chessboard, seventhMove[0], seventhMove[1], kI, kJ);
        boolean jumpEighthMove = canHorseTakeKing(chessboard, eighthMove[0], eighthMove[1], kI, kJ);

        return jumpFirstMove || jumpSecondMove || jumpThirdMove || jumpFourthMove || jumpFifthMove ||
                jumpSixthMove || jumpSeventhMove || jumpEighthMove;
    }

    private static boolean isInvalidCell(int i, int j) {
        return i < 0 || i > 7 || j < 0 || j > 7;
    }
}
