package module_one.lesson10_practice;

import java.util.Scanner;

public class Test1Task2S5V2 {
    public static void main(String[] args) {

        /*
         Write a method that takes a String variable that holds some text. The method
         must return the ratio between all upper case letters and all lower case letters in the text.
         For example if there are 75 lower case letters and 25 upper case letters, the ratio is 3:1.

         umbers corresponding to the number of mines that exist right next to each cell lk kj kj hgfh
         AWHF JSH J H LOKDJ J HHHL K KDHJY -> 3:1
         */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ratio = findRatioBetweenUpperAndLowerCaseLetter(input);
        System.out.println(ratio);
    }

    private static String findRatioBetweenUpperAndLowerCaseLetter(String input) {
        String ratio;

        int countUpper = 0;
        int countLower = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (letter >= 'A' && letter <= 'Z') {
                // upper
                countUpper++;
            }

            if (letter >= 'a' && letter <= 'z') {
                countLower++;
            }
        }

        int unit = countLower;
        int bigger = countUpper;

        if (countUpper < countLower) {
            unit = countUpper;
            bigger = countLower;
        }

        double rat = bigger * 1.0 / unit;
        ratio = rat + ":1";
        return ratio;
    }
}
