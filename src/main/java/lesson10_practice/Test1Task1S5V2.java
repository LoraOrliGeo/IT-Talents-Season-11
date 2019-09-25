package lesson10_practice;

import java.util.Scanner;

public class Test1Task1S5V2 {
    public static void main(String[] args) {

        /*
        Write a program that asks you to roll two dice and checks the sum of their
        values. The program asks you to throw the dice until you achieve seven consecutive
        sums of value '7'. After that the program must tell you how many total tries you have
        done to achieve this result.

        Do we count when we have invalid dice value?
         */

        Scanner sc = new Scanner(System.in);

        int counter = 0;
        int countSumSeven = 0;

        while (true) {
            int dice1;
            int dice2;

            do {
                System.out.println("Row the two dice:");
                dice1 = sc.nextInt();
                dice2 = sc.nextInt();
            } while (!diceInRange(dice1) || !diceInRange(dice2));

            counter++;

            if (dice1 + dice2 == 7) {
                countSumSeven++;
            } else {
                countSumSeven = 0;
            }

            if (countSumSeven == 7) {
                break;
            }
        }

        System.out.println(counter);
    }

    public static boolean diceInRange(int dice) {
        return dice >= 1 && dice <= 6;
    }
}
