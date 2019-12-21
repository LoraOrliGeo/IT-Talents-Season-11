package module_one.lesson3_practice;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int spaces = n - 1;
        int stars = 1;

        for (int i = 0; i < n; i++) {
            //spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            spaces--;
            stars += 2;
            System.out.println();
        }

    }
}
