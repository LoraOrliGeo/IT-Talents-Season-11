package BookProblems;

import java.util.Scanner;

public class VariablesAndDataTypes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1
//        System.out.println("Enter two numbers:");
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        task1(x, y);

        //2
//        System.out.println("Enter three numbers:");
//        int a1 = sc.nextInt();
//        int a2 = sc.nextInt();
//        int a3 = sc.nextInt();
//        task2SwapAndPrint(a1, a2, a3);

        //3
//        System.out.println("Enter a number with three digits:");
//        int num = sc.nextInt();
//        System.out.println(task3mirrorNum(num));

        //4
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        task4SwapTwoNums(x, y);

        //5
//        System.out.println("Enter two boolean values:");
//        boolean first = sc.nextBoolean();
//        boolean second = sc.nextBoolean();
//        task5BooleanOperations(first, second);

        //6
//        int x;
//        do {
//            System.out.println("Enter four-digit number:");
//            x = sc.nextInt();
//        } while (Math.abs(x) / 1000 <= 0);
//        task6PrintPlaceValuesOfNum(x);

        //7
//        System.out.print("x = ");
//        int x = sc.nextInt();
//        System.out.print("y = ");
//        int y = sc.nextInt();
//        task7SwapTwoNumsUsingArithmOps(x, y);

        //8
//        int a, b, c;
//        do {
//            System.out.println("Enter three sides of triangle:");
//            a = sc.nextInt();
//            b = sc.nextInt();
//            c = sc.nextInt();
//        } while (a <= 0 || b <= 0 || c <= 0);
//        task8CalculateAndPrintAreaAndPerimeterOfTriangle(a, b, c);

        //9
//        System.out.println("Enter a number");
//        int num = sc.nextInt();
//        System.out.println(task9IsNumDivisibleByTwo(num));

        //10
//        System.out.println("Enter five booleans:");
//        boolean a1 = sc.nextBoolean();
//        boolean a2 = sc.nextBoolean();
//        boolean a3 = sc.nextBoolean();
//        boolean a4 = sc.nextBoolean();
//        boolean a5 = sc.nextBoolean();
//        System.out.println("Are all true: " + (a1 && a2 && a3 && a4 && a5));


    }

    private static void task1(int x, int y) {
        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));

        if (y != 0) {
            System.out.println("x / y = " + (x * 1.0 / y));
            System.out.println("x % y = " + (x % y));
        } else {
            System.out.println("Cannot divide by 0!");
        }
    }

    private static void task2SwapAndPrint(int a1, int a2, int a3) {
        int temp = a1;
        a1 = a2;
        a2 = a3;
        a3 = temp;
        System.out.printf("Swapped numbers: %d, %d, %d%n", a1, a2, a3);
    }

    private static int task3mirrorNum(int num) {
        int mirrorNum = 0;
        int newUnits = num / 100;
        num = num % 100;
        int newTens = num / 10;
        int newHundreds = num % 10;
        mirrorNum += newUnits + newTens * 10 + newHundreds * 100;
        return mirrorNum;
    }

    private static void task4SwapTwoNums(int x, int y) {
        System.out.println("Before the swap:\nx is = " + x + "\ny is = " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("After the swap:\nx is = " + x + "\ny is = " + y);
    }

    private static void task5BooleanOperations(boolean first, boolean second) {
        System.out.println(String.format("%b & %b = %b", first, second, (first & second)));
        System.out.println(String.format("%b | %b = %b", first, second, (first | second)));
        System.out.println(String.format("%b ^ %b = %b", first, second, (first ^ second)));
    }

    private static void task6PrintPlaceValuesOfNum(int x) {
        x = Math.abs(x);
        int thousands = x / 1000;
        System.out.println("Digit of thousands = " + thousands);
        x %= 1000;
        int hundreds = x / 100;
        System.out.println("Digit of hundreds = " + hundreds);
        x %= 100;
        int tens = x / 10;
        System.out.println("Digit of tens = " + tens);
        int ones = x % 10;
        System.out.println("Digit of ones = " + ones);

    }

    private static void task7SwapTwoNumsUsingArithmOps(int x, int y) {
        x = x * y;
        y = x / y;
        x = x / y;
        System.out.println("Swapped values:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    private static void task8CalculateAndPrintAreaAndPerimeterOfTriangle(int a, int b, int c) {
        double area = calculateTriangleArea(a, b, c);
        System.out.printf("Area of triangle = %.0f%n", area);
        System.out.println("Perimeter of triangle = " + (a + b + c));
    }

    private static double calculateTriangleArea(int a, int b, int c) {
        double p = (a + b + c) / 2.0; // half perimeter
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static boolean task9IsNumDivisibleByTwo(int num) {
        return num % 2 == 0;
    }
}

