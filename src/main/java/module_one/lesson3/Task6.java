package module_one.lesson3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert a number:");
        int num = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= num ; i++) {
            sum += i;
        }

        System.out.println("Sum = " + sum);
    }
}
