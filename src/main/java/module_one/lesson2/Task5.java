package module_one.lesson2;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert different three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b || a == c || b == c) {
            System.out.println("The three numbers are not different!");
            return;
        }

        if (a < b && a < c) {
            if (b < c) {
                print(c, b, a);
            } else {
                print(b, c, a);
            }
        } else if (b < a && b < c) {
            if (a < c) {
                print(c, a, b);
            } else {
                print(a, c, b);
            }
        } else {
            if (a < b) {
                print(b, a, c);
            } else {
                print(a, b, c);
            }
        }
    }

    private static void print(int first, int second, int third) {
        System.out.println(String.format("%d %d %d", first, second, third));
    }
}
