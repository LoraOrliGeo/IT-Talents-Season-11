package lesson2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert first number:");
        int a = sc.nextInt();

        System.out.println("Insert second number:");
        int b = sc.nextInt();

        System.out.println("The numbers in increasing order are:");
        if (a > b){
            System.out.println(b + " " + a);
        } else {
            System.out.println(a + " " + b);
        }

    }
}
