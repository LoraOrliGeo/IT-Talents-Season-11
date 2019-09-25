package lesson10_practice;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {

        // infinite throws of a coin
        // possible inputs: heads or tails
        // stop when 5 CONSECUTIVE times heads are read

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            String coin = sc.nextLine();

            if (!coin.equals("heads") && !coin.equals("tails")){
                System.out.println("Invalid input");
                continue;
            }

            if (coin.equals("heads")) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == 5) {
                break;
            }
        }
    }
}
