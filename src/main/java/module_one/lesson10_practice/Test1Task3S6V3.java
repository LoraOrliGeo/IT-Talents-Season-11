package module_one.lesson10_practice;

import java.util.Scanner;

public class Test1Task3S6V3 {
    public static void main(String[] args) {

        /*
        Write a method that by given array of integers, and a positive number X,
        returns the product of all odd elements that are greater than X. Use recursion!
         */

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, -2, 3, 9, -4, 5};
        int num;

        do {
            System.out.println("Enter positive number:");
            num = sc.nextInt();
        } while (num <= 0);

        System.out.println(getProduct(arr, 0, num));

//        System.out.println(fibb(6));
    }

    private static int getProduct(int[] arr, int i, int num) {
        if (i == arr.length) {
            return 1;
        }

        if (arr[i] % 2 != 0 && arr[i] > num) {
            return arr[i] * getProduct(arr, i + 1, num);
        }

        return getProduct(arr, i + 1, num);
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int fibb(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibb(n - 1) + fibb(n - 2);
    }
}
