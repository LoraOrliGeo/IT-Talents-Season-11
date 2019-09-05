package lesson5_arrays;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[7];

        int count = 0;

        System.out.println("Enter elements of the array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] > 5 && arr[i] % 5 == 0) {
                count++;
            }
        }

        int[] numbers = new int[count];

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5 && arr[i] % 5 == 0) {
                numbers[index] = arr[i];
                index++;
            }

            if (index == numbers.length) {
                break;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ",");
            }
        }

        System.out.println(" - " + count + " numbers");
    }
}
