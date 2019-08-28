package lesson3;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int sumToCheck = sc.nextInt();

        while (sumToCheck < 2 || sumToCheck > 27) {
            System.out.println("The entered number must be in interval [2...27]!");
            sumToCheck = sc.nextInt();
        }

        for (int i = 100; i < 1000; i++) {
            int dec = i % 10;
            int tens = (i / 10) % 10;
            int hund = (i / 100) % 10;

            if (dec + tens + hund == sumToCheck) {
                System.out.println(i);
            }
        }

    }
}
