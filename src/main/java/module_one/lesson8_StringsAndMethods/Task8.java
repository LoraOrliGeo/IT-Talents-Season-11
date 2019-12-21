package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word:");
        String word = sc.nextLine();

        boolean isPalindrome = true;
        int middle = word.length() / 2;

        for (int i = 0; i < middle; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)){
                isPalindrome = false;
                break;
            }
        }

        System.out.println((isPalindrome ? "the word is palindrome" : "the word is not palindrome"));
    }
}
