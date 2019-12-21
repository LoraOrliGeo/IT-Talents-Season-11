package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        String firstWord = readWordWithoutSpace();
        String secondWord = readWordWithoutSpace();

        System.out.println(firstWord.length() == secondWord.length() ?
                "The words have same length." : "The words have different length");

        findDifferences(firstWord, secondWord);

    }

    public static String readWordWithoutSpace() {
        Scanner sc = new Scanner(System.in);
        String word;

        do {
            System.out.println("Enter word without space:");
            word = sc.nextLine();
        } while (word.contains(" "));

        return word;
    }

    public static void findDifferences(String firstWord, String secondWord) {
        int shorterLength = getShorterWord(firstWord, secondWord);

        boolean firstDiff = true;
        for (int i = 0; i < shorterLength; i++) {
            char firstChar = firstWord.charAt(i);
            char secondChar = secondWord.charAt(i);
            if (firstChar != secondChar) {
                if (firstDiff) {
                    System.out.println("Difference by positions:");
                    firstDiff = false;
                }
                System.out.printf("%d %c-%c%n", i + 1, firstChar, secondChar);
            }
        }
    }

    public static int getShorterWord(String firstWord, String secondWord) {
        return firstWord.length() < secondWord.length() ? firstWord.length() : secondWord.length();
    }
}
