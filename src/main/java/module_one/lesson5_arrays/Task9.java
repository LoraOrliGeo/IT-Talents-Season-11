package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter VALID size of the array:");
            size = sc.nextInt();
        } while (size <= 0);

        int[] arr = new int[size];

        int[] oppositeArr = new int[size];

        System.out.println("Enter elements for the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            oppositeArr[oppositeArr.length - i - 1 ] = arr[i];
        }

        System.out.print("The result array is: [");
        for (int i = 0; i < oppositeArr.length; i++){
            if (i == oppositeArr.length - 1){
                System.out.print(oppositeArr[i] + "]");
            } else {
                System.out.print(oppositeArr[i] + ", ");
            }
        }
    }
}
