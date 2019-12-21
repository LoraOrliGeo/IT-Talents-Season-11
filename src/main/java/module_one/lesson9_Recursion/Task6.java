package module_one.lesson9_Recursion;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        //enter a number, find sum of all numbers from 1 to this number

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert a number:");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println(calcSum(num, 1, 0));
        } else {
            System.out.println(calcSum(1, num, 0));
        }

    }

    private static int calcSum(int start, int end, int sum) {
        if (start > end) {
            return sum;
        }

        sum += start++;
        return calcSum(start, end, sum);
    }
}
