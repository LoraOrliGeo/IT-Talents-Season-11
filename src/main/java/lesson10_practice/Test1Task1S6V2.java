package lesson10_practice;

import java.util.Scanner;

public class Test1Task1S6V2 {
    public static void main(String[] args) {

        /*
         Write a program that reads two characters separated by space – each one - the
        strength of a card. Possible inputs are from 2..9 or T, J, Q, K, A. If the input is invalid
        the program must output the following : “Invalid cards given!”. The inputs are infinite.
        The program must stop when 3 consecutive pairs of ace(A) and king(K) are given.
        Finally, the program must output the number of tries.
        (we don't count the invalid inputs!)

3 4
J 2
1 T
Invalid cards given!
A K
J A
A K
K A
A K
Number of tries : 7
         */

        Scanner sc = new Scanner(System.in);
        int countAandK = 0;
        int tries = 0;

        while (true) {
            String input = sc.nextLine();

            if (!validateInput(input)){
                System.out.println("Invalid cards given!");
                countAandK = 0;
                continue;
            }

            String[] chars = input.split(" ");
            char first = chars[0].charAt(0);
            char second = chars[1].charAt(0);

            if ((first == 'A' && second == 'K') || (first == 'K' && second == 'A')) {
                countAandK++;
            } else {
                countAandK = 0;
            }

            tries++;

            if (countAandK == 3) {
                break;
            }
        }

        System.out.println("Number of tries: " + tries);
    }

    public static boolean inRange(char card) {
        return (card >= '2' && card <= '9') || card == 'T' ||
                card == 'J' || card == 'Q' || card == 'K' || card == 'A';
    }

    private static boolean validateInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        String[] chars = input.split(" ");
        if (chars.length != 2) {
            return false;
        }

        char first = chars[0].charAt(0);
        char second = chars[1].charAt(0);
        if (!inRange(first) || !inRange(second)) {
            return false;
        }

        return true;
    }
}
