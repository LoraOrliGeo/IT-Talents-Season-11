package module_one.lesson9_Recursion;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        //beginning from 3, print first n numbers divisible by 3 (separate by comma)

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert a number:");
        int n = sc.nextInt();
        int num = 3;
        int count = 1;

        printNumsDivisibleByThree(num, n, count);
    }

    private static void printNumsDivisibleByThree(int num, int end, int count) {
        if (count == end) {
            System.out.println(num);
            return;
        }
        System.out.print(num + ", ");
        num += 3;
        count++;
        printNumsDivisibleByThree(num, end, count);
    }
}
