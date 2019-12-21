package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter number of cells in both arrays:");
            size = sc.nextInt();
        } while (size <= 0);

        int[] firstArray = new int[size];
        int[] secondArray = new int[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = sc.nextInt();
        }

        for (int i = 0; i < firstArray.length/2; i++) {
                secondArray[i] = firstArray[i];
        }

        int secondArrInd = firstArray.length/2;

        for (int i = firstArray.length - 1; i >= firstArray.length/2 ; i--) {
            secondArray[secondArrInd] = firstArray[i];
            secondArrInd++;
        }

        System.out.println("The new array is: ");
        for (int i = 0; i < secondArray.length; i++) {
            System.out.print(secondArray[i] + " ");
        }
    }
}
