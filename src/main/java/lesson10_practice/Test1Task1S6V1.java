package lesson10_practice;

import java.util.Scanner;

public class Test1Task1S6V1 {
    public static void main(String[] args) {

        // read two symbols with a single space between them
        // check if each symbol is [2...9, T, J, Q, K A]
        // check if c1 == c2 == A
        //if yes -> print counter and break
        // if no -> counter++;

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            String input = sc.nextLine();
            if (input.length() != 3) {
                System.out.println("Invalid input!");
                continue; // we don't have to increase the counter in case of invalid input!
            }
            String[] cards = input.split(" ");
            if (cards.length != 2) {
                System.out.println("Invalid input!");
                continue;
            }
            char card1 = cards[0].charAt(0);
            char card2 = cards[1].charAt(0);
            boolean card1InRange = (card1 >= '2' && card1 <= '9')
                    || card1 == 'T' || card1 == 'J' || card1 == 'Q' || card1 == 'K' || card1 == 'A';
            boolean card2InRange = (card2 >= '2' && card2 <= '9')
                    || card2 == 'T' || card2 == 'J' || card2 == 'Q' || card2 == 'K' || card2 == 'A';
            if (!card1InRange || !card2InRange) {
                System.out.println("Invalid input!");
                continue;
            }
            counter++;
            if (card1 == 'A' && card2 == 'A') {
                System.out.println("Number of tries : " + counter);
                break;
            }
        }
    }
}
