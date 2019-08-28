package lesson2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert A:");
        int a = sc.nextInt();

        System.out.println("Insert B:");
        int b = sc.nextInt();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("New value of A: " + a);
        System.out.println("New vale of B: " + b);

    }
}