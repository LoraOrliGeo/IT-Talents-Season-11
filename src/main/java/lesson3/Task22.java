package lesson3;

import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int count = 0;

        while (count < 10) {
            num += 1;

            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                count++;
                if (count == 10){
                    System.out.print(count + ":" + num);
                } else {
                    System.out.print(count + ":" + num + ",");
                }
            }
        }
    }
}
