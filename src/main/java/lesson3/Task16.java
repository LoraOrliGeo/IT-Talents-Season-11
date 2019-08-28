package lesson3;

import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers from 10 to 5555:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int start = a;
        int end = b;

        if (a < b){
            start = b;
            end = a;
        }

        int countOfNumbers = (start - end) / 50;
        int count = 0;

        for (int i = start; i >= end; i--) {
            if (i % 50 == 0) {

                if (count == countOfNumbers){
                    System.out.print(i);
                } else {
                    count++;
                    System.out.print(i + ",");
                }
            }
        }
    }
}
