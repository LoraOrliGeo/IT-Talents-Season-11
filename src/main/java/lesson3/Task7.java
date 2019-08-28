package lesson3;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert a number:");
        int n = sc.nextInt();
        int start = 3;

        for (int i = 1; i <= n ; i++) {
            if (i == n){
                System.out.print(start);
            } else {
                System.out.print(start + ",");
            }
            start += 3;
        }
    }
}
