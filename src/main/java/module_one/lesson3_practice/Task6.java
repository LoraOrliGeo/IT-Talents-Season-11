package module_one.lesson3_practice;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int numberOfOnes = 0;

        while (num != 0) {
            int remainder = num % 2;
            if (remainder == 1) {
                numberOfOnes++;
            }
            num /= 2;
        }

        System.out.println("Number of ones is " + numberOfOnes);
    }
}
