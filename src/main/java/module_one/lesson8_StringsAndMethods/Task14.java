package module_one.lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;

        do {
            System.out.println("Enter positive number:");
            num = sc.nextInt();
        } while (num < 0);

        System.out.println(num + "! = " + calcFactorial(num));
    }

    private static long calcFactorial(int num) {
        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
