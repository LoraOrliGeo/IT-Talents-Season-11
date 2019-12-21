package module_one.lesson10_practice;

import java.util.Scanner;

public class Test1Task2S6V2 {
    public static void main(String[] args) {

        /*
        Write a method that takes 3 String variables that hold some text.
        The program must output the longest word tat appears in all 3 texts.
        The words are separated with space

        Ex:
        Simple sentence that is first.
        Another one that is second.
        Third sentence that is last.

        -> that
         */

        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();
        String third = sc.nextLine();

        System.out.println(longestWordInThreeSentence(first, second, third));
    }

    private static String longestWordInThreeSentence(String first, String second, String third) {
        String[] firstWords = first.split(" ");
        String resultWord = "";
        int maxLength = 0;
        for (int i = 0; i < firstWords.length; i++) {
            String word = firstWords[i];
            if (second.contains(word) && third.contains(word)) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    resultWord = word;
                }
            }
        }
        return resultWord;
    }
}
