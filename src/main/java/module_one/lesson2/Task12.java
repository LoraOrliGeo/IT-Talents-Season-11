package module_one.lesson2;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Day:");
        int day = sc.nextInt();
        System.out.println("Month:");
        int month = sc.nextInt();
        System.out.println("Year");
        int year = sc.nextInt();

        printNextDate(day, month, year);
    }

    private static void printNextDate(int day, int month, int year) {
        int[] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonths[1] = 29;
        }

        if (day < daysInMonths[month - 1]) {
            day++;
        } else {
            day = 1;

            if (month < 12) {
                month++;
            } else {
                month = 1;
                year++;
            }
        }

        System.out.println(String.format("Next date is: %d, %d, %d", day, month, year));
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
