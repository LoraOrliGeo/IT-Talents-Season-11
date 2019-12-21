package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter a number:");
        int number = sc.nextInt();

        int[] arr = new int[10];

        arr[0] = number;
        arr[1] = number;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.print("The result array is: [");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
