package module_one.lesson3_practice;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int spaces = n - 1;
        int stars = 1;

        for (int i = 0; i < n; i++) {
            //spaces at the begging of each row
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            //if the row is first or last
            if (i == 0 || i == n - 1) {
                //print a single star (first row) or (n - 1) stars (last row)
                for (int j = 0; j < stars; j++) {
                    System.out.print("*");
                }

                System.out.println();
            } else {
                //print a star at the begging
                System.out.print("*");

                //print spaces inside the triangle:
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print(" ");
                }

                //print star at the end
                System.out.println("*");

            }

            spaces--;
            stars += 2;
        }
    }
}
