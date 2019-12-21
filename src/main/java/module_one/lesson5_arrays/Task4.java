package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter a valid size of the array:");
            size = sc.nextInt();
        } while (size <= 0);

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isMirror = true;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                isMirror = false;
                break;
            }
        }

        if (isMirror) {
            System.out.println("The array is mirror");
        } else {
            System.out.println("The array is not mirror");
        }
    }
}
