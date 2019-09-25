package lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input a sentence:");
        String[] words = sc.nextLine().split(" ");

        for (int i = 0; i < words.length; i++) {
            String modifiedWord = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            System.out.print(modifiedWord + " ");
        }
    }
}
