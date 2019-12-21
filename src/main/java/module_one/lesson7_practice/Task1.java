package module_one.lesson7_practice;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter size of the array:");
            size = sc.nextInt();
        } while (size <= 0);

        int[] arr = new int[size];

        boolean hasNegativeNumber = false;

        System.out.println("Enter elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] < 0){
                hasNegativeNumber = true;
            }
        }

        if (!hasNegativeNumber){
            System.out.println("The array doesn't have negative elements!");
        } else {
            System.out.println("The array has negative elements!");
        }

    }
}
