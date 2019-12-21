package module_one.lesson3_practice;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
        }
    }
}
