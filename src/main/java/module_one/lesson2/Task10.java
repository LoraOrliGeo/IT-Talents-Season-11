package module_one.lesson2;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert volume, l:");
        int volume = sc.nextInt();

        int equalTwoNThree = volume / 5;

        int equalBucketsFull = equalTwoNThree * 2 + equalTwoNThree * 3;

        int remain = volume - equalBucketsFull;

        if (remain != 0) {
            if (remain == 1) {
                equalTwoNThree--;
                System.out.println(equalTwoNThree + " times per 2 liters");
                System.out.println(equalTwoNThree + " times per 3 liters");
                System.out.printf("Additional %d bucket/s of 3 liters%n", remain + 1);
            } else if (remain % 2 == 0) {
                System.out.println(equalTwoNThree + " times per 2 liters");
                System.out.println(equalTwoNThree + " times per 3 liters");
                System.out.printf("Additional %d bucket/s of 2 liters%n", remain / 2);
            }
        } else {
            System.out.println(equalTwoNThree + " times per 2 liters");
            System.out.println(equalTwoNThree + " times per 3 liters");
        }
    }
}
