package module_one.lesson5_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task18 {
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

        System.out.println("Enter elements for the first array:");
        for (int i = 0; i < firstArr.length; i++) {
            firstArr[i] = sc.nextInt();
        }

        System.out.println("Enter elements for the second array:");
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = sc.nextInt();
        }

        int end = firstArr.length;

        if (secondArr.length < firstArr.length){
            end = secondArr.length;
        }

        int[] resultArr = new int[end];

        for (int i = 0; i < end; i++) {
            if (firstArr[i] >= secondArr[i]){
                resultArr[i] = firstArr[i];
            } else {
                resultArr[i] = secondArr[i];
            }
        }

        System.out.println("First array: " + Arrays.toString(firstArr));
        System.out.println("Second array: " + Arrays.toString(secondArr));

        System.out.print("Result Array: [");
        for (int i = 0; i < resultArr.length; i++) {
            if (i == resultArr.length - 1){
                System.out.print(resultArr[i] + "]");
            } else {
                System.out.print(resultArr[i] + ", ");
            }
        }
    }
}
