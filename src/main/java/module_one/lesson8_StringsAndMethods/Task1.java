package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        String first = readWord();
        String second = readWord();

        printWord(first);
        printWord(second);
    }

    public static String readWord() {
        Scanner sc = new Scanner(System.in);

        String word;

        do {
            System.out.println("Enter word with length less than or 40 symbols:");
            word = sc.nextLine();
        } while (word.length() > 40);

        return word;
    }

    public static void printWord(String word) {
        System.out.println(String.format("%s %s", word.toUpperCase(), word.toLowerCase()));
    }
}
