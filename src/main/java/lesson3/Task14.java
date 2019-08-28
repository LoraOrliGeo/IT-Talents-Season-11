package lesson3;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter a number:");
        int n = sc.nextInt();

        while (n < 10 || n > 200){
            System.out.println("The entered number must be in interval [10...200]!");
            n = sc.nextInt();
        }

        for (int i = n - 1; i > 0 ; i--) {
            if(i % 7 == 0){
                System.out.print(i + " ");
            }
        }
    }
}
