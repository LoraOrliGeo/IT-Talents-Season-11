package module_one.lesson3;

import java.util.Scanner;

public class Task21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number from interval [1...51]:");
        int n = sc.nextInt();

        String[] cardValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] cardColors = {"clubs", "diamonds", "hearts", "spades"};

        String value = cardValues[n / 4];

        for (int i = (n - 1) % 4; i < cardColors.length; i++) {
            System.out.println(value + " " + cardColors[i]);
        }

        for (int i = n / 4 + 1; i < cardValues.length; i++) {
            for (String cardColor : cardColors) {
                System.out.println(cardValues[i] + " " + cardColor);
            }
        }
    }
}
