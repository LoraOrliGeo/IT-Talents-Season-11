package module_one.lesson3;

import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        int index = 0;

        boolean isPalindrome = true;

        do {
            if (number.charAt(index) != number.charAt(number.length() - index - 1)) {
                isPalindrome = false;
                break;
            }

            index++;
        } while (index < number.length() / 2);

        if (isPalindrome) {
            System.out.println("The number is palindrome");
        } else {
            System.out.println("The number is not palindrome");
        }
    }
}
