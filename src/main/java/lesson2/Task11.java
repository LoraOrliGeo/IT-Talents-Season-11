package lesson2;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if (numberIsDivisibleByItsDigits(number)) {
            System.out.println("The number is divisible by its three digits");
        } else {
            System.out.println("The number is NOT divisible by its three digits");
        }
    }

    private static boolean numberIsDivisibleByItsDigits(int number) {
        int decimals = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = (number / 100) % 10;
        return number % decimals == 0 && number % tens == 0 && number % hundreds == 0;
    }
}
