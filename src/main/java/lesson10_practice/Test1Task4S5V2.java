package lesson10_practice;

import java.util.Arrays;
import java.util.Scanner;

public class Test1Task4S5V2 {
    public static void main(String[] args) {

        /*
        Write a method that fills the matrix of the game “Minesweeper” with the
        proper values in each cell. The method takes a matrix of pixels N*N that is filled with
        character “*” on random coordinates. The method must fill all cells of the matrix with
        numbers corresponding to the number of mines that exist right next to each cell. Write
        a program that creates the array, prompts the user to input the coordinates of 10 different mines,
        inserts them in the array (put the symbol '*' in the cell that has a mine), then
        uses the method to fill the array with the proper numbers and then prints the array in
        the console in a readable and understandable way.

1 1
1 7
2 7
3 3
3 4
3 7
5 5
5 7
6 4
7 5
         */

        // read int number N - size of the “Minesweeper” -> >= 4 (it should fit 10 mines)
        // read coordinates of 10 different mines
        // insert the mines in the matrix -> put '*'
        // call method to fill the matrix with numbers corresponding to the number of mines
        // that exist right next to each cell

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter size of the playing filed");
            size = sc.nextInt();
        } while (size < 4);

        char[][] field = new char[size][size];

        System.out.println("Enter coordinates of 10 mines - each " +
                "coordinates should be on single line, separated with single space");

        for (int i = 0; i < 10; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            field[row][col] = '*';
        }

        fillNumbers(field);
        print(field);
    }

    private static void fillNumbers(char[][] field) {
        //look for mine
        //check every cell next to it -> validate indices
        // if it's not mine -> 1
        // if it's number -> ++

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '*') {
                    if (cellExists(field, i - 1, j) && field[i - 1][j] != '*') {
                        if (field[i - 1][j] == '\u0000') {
                            field[i - 1][j] = '1';
                        } else {
                            int num = (int) (field[i - 1][j]);
                            num++;
                            field[i - 1][j] = (char) num;
                        }
                    }

                    if (cellExists(field, i - 1, j + 1) && field[i - 1][j + 1] != '*') {
                        if (field[i - 1][j + 1] == '\u0000') {
                            field[i - 1][j + 1] = '1';
                        } else {
                            int num = (int) (field[i - 1][j + 1]);
                            num++;
                            field[i - 1][j + 1] = (char) num;
                        }
                    }

                    if (cellExists(field, i, j + 1) && field[i][j + 1] != '*') {
                        if (field[i][j + 1] == '\u0000') {
                            field[i][j + 1] = '1';
                        } else {
                            int num = (int) (field[i][j + 1]);
                            num++;
                            field[i][j + 1] = (char) num;
                        }
                    }

                    if (cellExists(field, i + 1, j + 1) && field[i + 1][j + 1] != '*') {
                        if (field[i + 1][j + 1] == '\u0000') {
                            field[i + 1][j + 1] = '1';
                        } else {
                            int num = (int) (field[i + 1][j + 1]);
                            num++;
                            field[i + 1][j + 1] = (char) num;
                        }
                    }

                    if (cellExists(field, i + 1, j) && field[i + 1][j] != '*') {
                        if (field[i + 1][j] == '\u0000') {
                            field[i + 1][j] = '1';
                        } else {
                            int num = (int) (field[i + 1][j]);
                            num++;
                            field[i + 1][j] = (char) num;
                        }
                    }

                    if (cellExists(field, i + 1, j - 1) && field[i + 1][j - 1] != '*') {
                        if (field[i + 1][j - 1] == '\u0000') {
                            field[i + 1][j - 1] = '1';
                        } else {
                            int num = (int) (field[i + 1][j - 1]);
                            num++;
                            field[i + 1][j - 1] = (char) num;
                        }
                    }

                    if (cellExists(field, i, j - 1) && field[i][j - 1] != '*') {
                        if (field[i][j - 1] == '\u0000') {
                            field[i][j - 1] = '1';
                        } else {
                            int num = (int) (field[i][j - 1]);
                            num++;
                            field[i][j - 1] = (char) num;
                        }
                    }

                    if (cellExists(field, i - 1, j - 1) && field[i - 1][j - 1] != '*') {
                        if (field[i - 1][j - 1] == '\u0000') {
                            field[i - 1][j - 1] = '1';
                        } else {
                            int num = (int) (field[i - 1][j - 1]);
                            num++;
                            field[i - 1][j - 1] = (char) num;
                        }
                    }
                }
            }
        }
    }

    private static boolean cellExists(char[][] field, int i, int j) {
        return i >= 0 && i < field.length && j >= 0 && j < field.length;
    }

    private static void print(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '\u0000') {
                    System.out.print(" ");
                } else {
                    System.out.print(field[i][j]);
                }
            }
            System.out.println();
        }
    }
}
