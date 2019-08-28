package lesson3;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert first number:");
        int a = sc.nextInt();

        System.out.println("Insert second number:");
        int b = sc.nextInt();

        int start = a;
        int end = b;

        if (a > b){
            start = b;
            end = a;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
    }
}
