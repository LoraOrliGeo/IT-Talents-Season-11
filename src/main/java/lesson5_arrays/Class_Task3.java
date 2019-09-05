package lesson5_arrays;

import java.util.Scanner;

public class Class_Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of days in month:");
        int days = sc.nextInt();

        int[] month = new int[days];

        int sumOfTemperatures = 0;

        System.out.println("Enter temperatures:");
        for (int i = 0; i < month.length; i++) {
            month[i] = sc.nextInt();
            sumOfTemperatures += month[i];
        }

        double avgTemp = sumOfTemperatures * 1.0 / days;
        System.out.println("Average temperature for the month is " + avgTemp);

        int maxSequenceColdDays = 0;
        int coldDays = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < month.length; i++) {
            int curr = month[i];

            if (curr < avgTemp) {
                coldDays++;
                if (coldDays > maxSequenceColdDays) {
                    maxSequenceColdDays = coldDays;
                    endIndex = i;
                }
            } else {
                coldDays = 0;
            }
        }

        startIndex = endIndex - maxSequenceColdDays + 1;

        System.out.println("Longest sequence of days with temperature below average:");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(month[i] + " ");
        }

        System.out.println();

        int longestPeriodCooling = 0;
        int daysOfCooling = 0;
        int start = 0;
        int end = 0;

        System.out.println("Longest period of cooling:");

    }
}
