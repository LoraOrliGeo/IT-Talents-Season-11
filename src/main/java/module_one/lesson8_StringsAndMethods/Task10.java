package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter word. please:");
        String input = sc.nextLine();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            result += (char)(input.charAt(i) + 5);
        }

        System.out.println(result);
    }
}
