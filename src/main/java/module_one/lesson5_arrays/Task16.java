package module_one.lesson5_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] arr = new double[10];

        System.out.println("Enter elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }

        System.out.print("The initial values of the array are: ");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < -0.231){
                arr[i] = (i + 1.0) * (i + 1.0) + 41.25;
            } else {
                arr[i] = arr[i] * (i + 1.0);
            }
        }

        System.out.print("The new value of the array are: {");
        for (int i = 0; i < arr.length; i++) {
            if (i == 9){
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
