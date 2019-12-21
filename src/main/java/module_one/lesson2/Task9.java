package module_one.lesson2;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int res = a * b;
        System.out.println("Res = " + res);

        int lastDigit = res % 10;

        if (lastDigit % 2 == 0){
            System.out.println(lastDigit + " even");
        } else {
            System.out.println(lastDigit + " odd");
        }

    }
}
