package lesson2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert А:");
        double a = sc.nextDouble();

        System.out.println("Insert В:");
        double b = sc.nextDouble();

        System.out.println("Insert C:");
        double c = sc.nextDouble();

        if (inRange(a, b, c)) {
            System.out.println("The number " + c + " is between " + a + " and " + b);
        } else {
            System.out.println("The number " + c + " is not between " + a + " and " + b);
        }
    }

    private static boolean inRange(double a, double b, double c) {
        return a <= c && c <= b;
    }
}