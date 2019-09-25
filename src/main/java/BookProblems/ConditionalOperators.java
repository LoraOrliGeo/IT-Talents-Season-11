package BookProblems;

import java.util.Scanner;

public class ConditionalOperators {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1
//        int num;
//        do {
//            System.out.println("Enter 3-digit number:");
//            num = sc.nextInt();
//        } while (num < 100 || num > 999);
//        task1CheckIfNumIsDivisibleByItsDigits(num);

        //2
//        System.out.println("Enter three numbers:");
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        System.out.print("Numbers in descending order: ");
//        task2PrintNumbersInDescendingOrder(a, b, c);

        //3
//        System.out.println("Enter degrees in Celsius:");
//        int degrees = sc.nextInt();
//        System.out.println(task3GetMessageAccordingToDegrees(degrees));

        //4
//        int num;
//        do {
//            System.out.println("Enter 3-digit number:");
//            num = sc.nextInt();
//        } while (num < 100 || num > 999);
//        task4(num);

        //5
//        System.out.println("Enter coordinates of 2 fields:");
//        int x1 = sc.nextInt();
//        int y1 = sc.nextInt();
//        int x2 = sc.nextInt();
//        int y2 = sc.nextInt();
//        if (!validateCoordinates(x1, y1) || validateCoordinates(x2, y2)) {
//            System.out.println("You've entered invalid coordinates!");
//        } else {
//            System.out.println(task5CheckTwoFieldsColor(x1, y1, x2, y2));
//        }

        //6
//        int num;
////        do {
////            System.out.println("Enter 4-digit number:");
////            num = sc.nextInt();
////        } while (num < 1000 || num > 9999);
////        System.out.println(task6CheckIfNumberContainsZero(num));

        //7
//        System.out.println("Enter day, month and year:");
//        int day = sc.nextInt();
//        int month = sc.nextInt();
//        int year = sc.nextInt();
//        if (!validateDate(day, month, year)) {
//            System.out.println("You've entered invalid date!");
//        } else {
//            System.out.println(task7NumberOfDays(day, month, year));
//        }

        //8 -> цистерна + кофи 2 и 3 литра

        //9
//        int hour;
//        do {
//            System.out.println("Enter an hour [0...24]");
//            hour = sc.nextInt();
//        } while (hour < 0 || hour > 24);
//
//        if (hour >= 18 || hour <= 4){
//            System.out.println("Good evening!");
//        } else if (hour <= 9){
//            System.out.println("Good morning!");
//        } else {
//            System.out.println("Good day!");
//        }5
    }

    private static void task1CheckIfNumIsDivisibleByItsDigits(int num) {
        int numInitValue = num;
        int hundreds = num / 100;
        num %= 100;
        int tens = num / 10;
        int ones = num % 10;

        if (hundreds == 0 || tens == 0 || ones == 0) {
            System.out.println("The number contains 0!");
        } else {
            if (numInitValue % hundreds == 0 && numInitValue % tens == 0 && numInitValue % ones == 0) {
                System.out.println("The number is divisible by its 3 digits :)");
            } else {
                System.out.println("The number is NOT divisible by its 3 digits :(");
            }
        }
    }

    private static void task2PrintNumbersInDescendingOrder(int a, int b, int c) {
        if (a == b || a == c || b == c) {
            System.out.println("The three numbers are not different!");
            return;
        }

        if (a < b && a < c) {
            if (b < c) {
                print(c, b, a);
            } else {
                print(b, c, a);
            }
        } else if (b < a && b < c) {
            if (a < c) {
                print(c, a, b);
            } else {
                print(a, c, b);
            }
        } else {
            if (a < b) {
                print(b, a, c);
            } else {
                print(a, b, c);
            }
        }
    }

    private static void print(int first, int second, int third) {
        System.out.println(String.format("%d %d %d", first, second, third));
    }

    private static String task3GetMessageAccordingToDegrees(int degrees) {
        String output;

        if (degrees < -20) {
            output = "freezing cold";
        } else if (degrees <= -1) {
            output = "cold";
        } else if (degrees <= 14) {
            output = "cool";
        } else if (degrees <= 25) {
            output = "warm";
        } else {
            output = "hot";
        }

        return output;
    }

    private static void task4(int num) {
        int hundreds = num / 100;
        num %= 100;
        int tens = num / 10;
        int ones = num % 10;

        if (hundreds == tens && tens == ones) {
            System.out.println("The digits are equal.");
        } else if (hundreds > tens && tens > ones) {
            System.out.println("The digits are in ascending order.");
        } else if (hundreds < tens && tens < ones) {
            System.out.println("The digits are in descending order.");
        } else {
            System.out.println("The digits are unordered.");
        }
    }

    private static String task5CheckTwoFieldsColor(int x1, int y1, int x2, int y2) {

        int firstCoordinatesSum = x1 + y1;
        int secondCoordinatesSum = x2 + y2;

        if ((firstCoordinatesSum % 2 == 0 && secondCoordinatesSum % 2 != 0) ||
                (firstCoordinatesSum % 2 != 0 && secondCoordinatesSum % 2 == 0)) {
            return "The two fields are with different color!";
        }

        return "The two fields are with same color!";
    }

    private static boolean validateCoordinates(int x, int y) {
        return x >= 0 && x < 8 || y >= 0 && y < 8;
    }

    private static boolean task6CheckIfNumberContainsZero(int num) {
        return (num + "").contains("0");
    }

    private static int task7NumberOfDays(int day, int month, int year) {
        int countDays = 0;

        int[] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonths[1] = 29;
        }

        countDays += day;

        for (int i = 0; i < month - 1; i++) {
            countDays += daysInMonths[i];
        }

        return countDays;
    }

    private static boolean validateDate(int day, int month, int year) {
        int[] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year) && month == 2) {
            return day <= 29;
        } else {
            if (month >= 1 && month <= 12) {
                return day < daysInMonths[month - 1];
            }
        }
        return false;
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
