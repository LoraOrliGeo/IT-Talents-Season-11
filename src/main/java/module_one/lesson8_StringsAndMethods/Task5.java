package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two words:");
        String firstWord = sc.nextLine();
        String secondWord = sc.nextLine();

        char[][] matrix = new char[secondWord.length()][firstWord.length()];

        boolean haveCrossingPoint = false;
        int firstWordRow = 0;
        int secondWordCol = 0;

        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 0; j < secondWord.length(); j++) {
                if (firstWord.charAt(i) == secondWord.charAt(j)) {
                    haveCrossingPoint = true;
                    firstWordRow = j;
                    secondWordCol = i;
                    break;
                }
            }
            if (haveCrossingPoint){
                break;
            }
        }

        if (haveCrossingPoint) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][secondWordCol] = secondWord.charAt(i);
            }

            matrix[firstWordRow] = firstWord.toCharArray();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == '\u0000') {
                        System.out.print(" ");
                    } else {
                        System.out.print(matrix[i][j]);
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("The words don't have crossing point");
        }
    }
}
