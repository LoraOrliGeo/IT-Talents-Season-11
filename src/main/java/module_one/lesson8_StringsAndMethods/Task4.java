package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.println("Enter two names:");
            input = sc.nextLine();
        } while (!validateInput(input));

        int maxNameSum = 0;
        String maxName = "";

        String[] names = input.split(", ");

        for (String name : names) {
            int nameSum = 0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    nameSum += name.charAt(i);
                }
            }

            if (nameSum >= maxNameSum) {
                maxNameSum = nameSum;
                maxName = name;
            }
        }

        System.out.println(maxName);
    }

    public static boolean validateInput(String input) {
        String[] names = input.split(", ");
        if (names.length != 2) {
            return false;
        }
        for (String name : names) {
            if (name.split(" ").length != 3) {
                return false;
            }
        }
        return true;
    }
}
