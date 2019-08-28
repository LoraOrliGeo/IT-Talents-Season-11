package lesson3;

import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int startValue = 1;
        int factorial = 1;

        if (number >= 0) {
            do {
                factorial *= startValue;
                startValue++;
                number--;
            } while (number > 0);

            System.out.println(factorial);
        } else {
            System.out.println("Negative numbers do not have factorial!");
        }
    }
}
