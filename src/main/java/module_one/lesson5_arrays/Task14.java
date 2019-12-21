package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter valid size of the array:");
            size = sc.nextInt();
        } while (size <= 0);

        double[] arr = new double[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }

        int resSize = 0;

        for (int i = 0; i < arr.length; i++) {
            if (-2.99 <= arr[i] && arr[i] <= 2.99) {
                resSize++;
            }
        }

        double[] resArr = new double[resSize];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (-2.99 <= arr[i] && arr[i] <= 2.99) {
                resArr[index] = arr[i];

                if (index == resArr.length - 1) {
                    System.out.print(resArr[index]);
                } else {
                    System.out.print(resArr[index] + "; ");
                }

                index++;
            }
        }
    }
}
