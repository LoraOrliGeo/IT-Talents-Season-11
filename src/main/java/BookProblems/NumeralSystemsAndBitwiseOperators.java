package BookProblems;

import java.util.Scanner;

public class NumeralSystemsAndBitwiseOperators {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1
//        System.out.println(6 & 4);
        // 6 = 110; 4 = 100 -> 110 & 100 = 100

        //2
//        int num;
//        do {
//            System.out.println("Enter a number between 0 and 50");
//        num = sc.nextInt();
//        } while (num < 0 || num > 50);
//        System.out.println(task2ConvertNumToBinary(num));

        //3 - which number is bigger using arithmetical and bitwise operators only!
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(task3FindBiggerNumWithoutComparision(a, b));

        //5
//        int a, b, c;
//        do {
//            System.out.println("Enter three numbers (positive or 0):");
//            a = sc.nextInt();
//            b = sc.nextInt();
//            c = sc.nextInt();
//        } while (a < 0 || b < 0 || c < 0);
//        int num = 0;
//        System.out.println(task5InvertBitsOfNum(num, a, b, c));

        //6
//        System.out.println("Enter a number:");
//        int a = sc.nextInt();
//        int b, c;
//        do {
//            System.out.println("Which bits of " + a + " you want to invert?");
//            b = sc.nextInt();
//            c = sc.nextInt();
//        } while (b < 0 || c < 0);
//        a = a ^ (1 << b);
//        a = a ^ (1 << c);
//        System.out.println(a);

        //8
        System.out.println("Enter e byte number:");
        byte num = sc.nextByte();
        System.out.println((num >> 7 & 1) > 0);
    }

    private static String task2ConvertNumToBinary(int num) {
        String res = "";
        while (num != 0) {
            int remainder = num % 2;
            res += remainder;
            num /= 2;
        }
        String binary = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            binary += res.charAt(i);
        }
        return binary;
    }

    private static int task3FindBiggerNumWithoutComparision(int a, int b) {
        // find difference between a and b
        int diff = a - b;
        /* check if the diff is positive or negative number
         the first bit of the int number is for sign -> 0(+), 1(-)
         shift right that first bit 31 times -> 32 bit
         make logical AND with 1
         the result is a multiplier k
        */
        int k = (diff >> 31) & 1;
        int max = a - k * diff;
        return max;
    }

    private static int task5InvertBitsOfNum(int num, int a, int b, int c) {
        num = num ^ (1 << a);
        num = num ^ (1 << b);
        num = num ^ (1 << c);
        return num;
    }
}
