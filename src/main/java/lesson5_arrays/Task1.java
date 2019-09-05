package lesson5_arrays;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter number of cells in the array:");
            size = sc.nextInt();
        } while (size <= 0);

        int[] arr = new int[size];

        int minNumDivisibleBy3 = Integer.MAX_VALUE;
        boolean hasNumDivByThree = false;

        System.out.println("Enter values for each cell:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] % 3 == 0 && arr[i] < minNumDivisibleBy3) {
                minNumDivisibleBy3 = arr[i];
                hasNumDivByThree = true;
            }
        }

        if (hasNumDivByThree) {
            System.out.println("The smallest number divisible by 3 is " + minNumDivisibleBy3);
        } else {
            System.out.println("None of the numbers in the array is divisible by 3");
        }
    }
}
