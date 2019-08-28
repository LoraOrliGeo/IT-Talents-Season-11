package lesson3;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert A:");
        int a = sc.nextInt();

        System.out.println("Insert B:");
        int b = sc.nextInt();

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int sum = 0;

        while (a <= b && sum <= 200) {
            if (a % 3 == 0) {
                if (a == b || sum >= 200) {
                    System.out.print("skip 3");
                } else {
                    System.out.print("skip 3,");
                }
            } else {
                int pow = a * a;
                sum += pow;

                if (a == b || sum >= 200) {
                    System.out.print(pow);
                } else {
                    System.out.print(pow + ",");
                }
            }

            a++;
        }
    }
}
