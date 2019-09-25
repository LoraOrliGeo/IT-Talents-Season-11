package lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        String firstWord = readWord();
        String secondWord = readWord();

        String firstOld = getFirstFiveSymbols(firstWord);
        String secondOld = getFirstFiveSymbols(secondWord);

        String firstNew = getFirstFiveSymbols(secondWord);
        String secondNew = getFirstFiveSymbols(firstWord);

        firstWord = firstWord.replace(firstOld, firstNew);
        secondWord = secondWord.replace(secondOld, secondNew);

        int maxLength = firstWord.length();

        if (secondWord.length() > firstWord.length()) {
            maxLength = secondWord.length();
        }

        System.out.println("The length of longer word is " + maxLength);
        System.out.printf("Words after replacements: %s %s", firstWord, secondWord);
    }

    public static String readWord() {
        Scanner sc = new Scanner(System.in);

        String word;

        do {
            System.out.println("Enter word with length between 10 and 20 symbols:");
            word = sc.nextLine();
        } while (!(10 <= word.length() && word.length() <= 20));

        return word;
    }

    public static String getFirstFiveSymbols(String word) {
        return String.valueOf(word.subSequence(0, 5));
    }
}
