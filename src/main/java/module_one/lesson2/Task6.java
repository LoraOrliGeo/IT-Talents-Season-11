package module_one.lesson2;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert first number:");
        int a1 = sc.nextInt();

        System.out.println("Insert second number:");
        int a2 = sc.nextInt();

        System.out.println("Insert third number:");
        int a3 = sc.nextInt();

        int temp = a1;
        a1 = a2;
        a2 = a3;
        a3 = temp;

        System.out.println("Swapped numbers:");
        System.out.println("new a1 = " + a1);
        System.out.println("new a2 = " + a2);
        System.out.println("new a3 = " + a3);
    }
}
