package module_one.lesson10_practice;

import java.util.Scanner;

public class Test1Task2S6V3 {
    public static void main(String[] args) {

        /*
        Write a function that takes a 2 String variables that hold some text.
        The program must output all the words that appear in the first text but not in the second one.
        The words are separated only with space
         */

        Scanner sc = new Scanner(System.in);

        String firstText = sc.nextLine();
        String secondText = sc.nextLine();
        printWords(firstText, secondText);
    }

    private static void printWords(String firstText, String secondText) {
        String[] firstWords = firstText.split(" ");
        for (int i = 0; i < firstWords.length; i++) {
            String word = firstWords[i];
            if (firstText.contains(word) && !secondText.contains(word)) {
                System.out.println(word);
            }
        }
    }
}
