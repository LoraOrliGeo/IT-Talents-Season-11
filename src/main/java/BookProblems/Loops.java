package BookProblems;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1
//        int first = sc.nextInt();
//        int second = sc.nextInt();
//        task1PrintNumsFromSmallestToBiggest(first, second);

        //2
//        int x;
//        do {
//            x = sc.nextInt();
//        } while (x <= 0);
//        task2PrintFirstXNumDivByThree(x);

        //3
//        int num;
//        do {
//            System.out.println("Enter 4-digit number:");
//            num = sc.nextInt();
//        } while (num < 1000 || num > 9999);
//        System.out.println(task3CheckIfTheNumIsPalindrome(num));

        //4
//        int num = sc.nextInt();
//        if (num < 0) {
//            num *= -1;
//        }
//        for (int i = 1; i <= num; i++) {
//            if (num % i == 0) {
//                System.out.println(i + " ");
//            }
//        }

        //5
//        int num1, num2;
//        do {
//            System.out.println("Enter to positive numbers:");
//            num1 = sc.nextInt();
//            num2 = sc.nextInt();
//        } while (num1 <= 0 || num2 <= 0);
//        System.out.println(task5SumFactorialsOfTwoNums(num1, num2));

        //7
//        int num;
//        do {
//            System.out.println("Enter natural number:");
//            num = sc.nextInt();
//        } while (num < 0);
//        task7Solve(num);

        //8
//        int side;
//        do {
//            System.out.println("Enter value for square's side:");
//            side = Integer.parseInt(sc.nextLine());
//        } while (side <= 0);
//        System.out.println("Enter a symbol for filling:");
//        String symbol = sc.nextLine();
//        task8PrintFilledSquare(side, symbol);

        //9
//        int height;
//        do {
//            System.out.println("Enter height of triangle:");
//            height = sc.nextInt();
//        } while (height <= 0);
//        task9PrintTriangle(height);

        //10
        int num;
        do {
            System.out.println("Enter a number from interval [1...51]:");
            num = sc.nextInt();
        } while (num < 1 || num > 52);
        task10ListOfCards(num);
    }

    private static void task1PrintNumsFromSmallestToBiggest(int first, int second) {
        int min = first;
        int max = second;

        if (second < first) {
            min = second;
            max = first;
        }

        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }
    }

    private static void task2PrintFirstXNumDivByThree(int x) {
        int num = 3;
        for (int i = 1; i <= x; i++) {
            System.out.print(num + " ");
            num += 3;
        }
    }

    private static boolean task3CheckIfTheNumIsPalindrome(int num) {
        int thousands = num / 1000;
        num %= 1000;
        int hundreds = num / 100;
        num %= 100;
        int tens = num / 10;
        int ones = num % 10;
        return thousands == ones && hundreds == tens;
    }

    private static int task5SumFactorialsOfTwoNums(int num1, int num2) {
        return factorial(num1) + factorial(num2);
    }

    private static int factorial(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static void task7Solve(int num) {
        int count = 0;

        while (count < 10) {
            num += 1;
            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                count++;
                if (count == 10) {
                    System.out.print(count + ":" + num);
                } else {
                    System.out.print(count + ":" + num + "; ");
                }
            }
        }
    }

    private static void task8PrintFilledSquare(int side, String symbol) {
        //print first row
        printFirstLastRow(side);
        System.out.println();
        //print the inside
        for (int i = 0; i < side - 2; i++) {
            System.out.print('*');
            for (int j = 0; j < side - 2; j++) {
                System.out.print(symbol);
            }
            System.out.println('*');
        }
        //print last row
        printFirstLastRow(side);
    }

    private static void printFirstLastRow(int side) {
        for (int i = 0; i < side; i++) {
            System.out.print('*');
        }
    }

    private static void task9PrintTriangle(int n) {
        int spaces = n - 1;
        int stars = 1;
        for (int i = 0; i < n; i++) {
            //spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            spaces--;
            stars += 2;
            System.out.println();
        }
    }

    private static void task10ListOfCards(int num) {
        String[] cardValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] cardColors = {"clubs", "diamonds", "hearts", "spades"};
        String value = cardValues[num / 4];

        for (int i = (num - 1) % 4; i < cardColors.length; i++) {
            System.out.println(value + " " + cardColors[i]);
        }

        for (int i = num / 4 + 1; i < cardValues.length; i++) {
            for (String cardColor : cardColors) {
                System.out.println(cardValues[i] + " " + cardColor);
            }
        }
    }
}
