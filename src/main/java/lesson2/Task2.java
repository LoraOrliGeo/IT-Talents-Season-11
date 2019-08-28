package lesson2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // integer numbers:

        System.out.println("Insert A:");
        int a = sc.nextInt();

        System.out.println("Insert B:");
        int b = sc.nextInt();

        int sum = a + b;
        System.out.println("Sum: " + sum);

        int subtraction = a - b;
        System.out.println("The difference between a and b is: " + Math.abs(subtraction));

        int product = a * b;
        System.out.println("The product of multiplication is: " + product);

        if (b != 0) {
            int reminder = a % b;
            System.out.println("The reminder of module division is: " + reminder);

            double quotient = a / (b * 1.0);
            System.out.println("The quotient is: " + quotient);
        } else {
            System.out.println("You can not divide be zero!");
        }

        // floating-point numbers:

        System.out.println("Insert C:");
        double c = sc.nextDouble();

        System.out.println("Insert D:");
        double d = sc.nextDouble();

        double doubleSum = c + d;
        System.out.println("Sum: " + doubleSum);

        double subtract = c - d;
        System.out.println("The difference between c and d is: " + Math.abs(subtract));

        double prod = c * d;
        System.out.println("The product of multiplication is: " + prod);

        if (d != 0) {
            double reminder = c % d;
            System.out.println("The reminder of module division is: " + reminder);

            double quotient = c / d;
            System.out.println("The quotient is: " + quotient);
        } else {
            System.out.println("You can not divide be zero!");
        }
    }
}