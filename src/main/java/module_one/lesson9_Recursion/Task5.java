package module_one.lesson9_Recursion;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert first number:");
        int a = sc.nextInt();

        System.out.println("Insert second number:");
        int b = sc.nextInt();

        int start = a;
        int end = b;

        if (a > b){
            start = b;
            end = a;
        }

        printNumbers(start, end);

    }

    private static void printNumbers(int start, int end) {
        if (start > end){
            return;
        }
        System.out.print(start + " ");
        printNumbers(++start, end);
    }
}
