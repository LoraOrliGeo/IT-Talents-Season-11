package lesson3_practice;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        long res = 0;
        long pow = 1;

        while (num != 0) {
            int remainder = num % 2;
            res += remainder * pow;
            pow *= 10;
            num /= 2;
        }

        System.out.println(res);
    }
}
