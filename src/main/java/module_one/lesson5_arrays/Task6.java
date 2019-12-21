package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstSize;
        int secondSize;

        do {
            System.out.println("Enter a valid size for the first and second array:");
            firstSize = sc.nextInt();
            secondSize = sc.nextInt();
        } while (firstSize <= 0 || secondSize <= 0);

        int[] firstArr = new int[firstSize];
        int[] secondArr = new int[secondSize];

        System.out.println("Enter elements for the first array");
        for (int i = 0; i < firstArr.length; i++) {
            firstArr[i] = sc.nextInt();
        }

        System.out.println("Enter elements for the second array");
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = sc.nextInt();
        }

        // two arrays are equal if they have same length and same elements on same indices
        boolean areEqual = true;

        if (firstArr.length == secondArr.length){
            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i] != secondArr[i]){
                    areEqual = false;
                    System.out.println("The arrays are not equal! Although they have same size, they have different elements");
                }
            }
        } else {
            areEqual = false;
            System.out.println("The arrays are not equal! They have different size");
        }

        if(areEqual){
            System.out.println("The arrays are equal ^_^");
        }
    }
}
