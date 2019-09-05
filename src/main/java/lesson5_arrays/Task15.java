package lesson5_arrays;

import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size;

        do {
            System.out.println("Enter valid size of the array:");
            size = sc.nextInt();
        } while (size < 3);

        double[] arr = new double[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double absFirst = arr[i] >= 0 ? arr[i] : arr[i] * -1;
                double absSecond = arr[j] >= 0 ? arr[j] : arr[j] * -1;

                if (absFirst < absSecond){
                    double temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        double first = arr[0];
        double second = 0;
        double third = 0;

        boolean haveThreeDiff = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != first && second == 0){
                second = arr[i];
            }

            if (arr[i] != second && second != 0){
                third = arr[i];
                haveThreeDiff = true;
                break;
            }
        }

        if (haveThreeDiff) {
            System.out.println(third + "; " + second + "; " + first);
        } else {
            System.out.println("There aren't three different elements");
        }
    }
}
