package module_one.lesson3_practice;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Number is prime!");
        } else {
            System.out.println("Number is not prime!");
        }

//        System.out.println(isPrime ? "The number is prime" : "The number is not prime");
    }
}
