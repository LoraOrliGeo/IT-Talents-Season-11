package module_one.lesson5_arrays;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int copyOfNum = num;
        int countDivision = 0;

        while (num > 0) {
            num /= 2;
            countDivision++;
        }

        int[] binary = new int[countDivision];

        for (int i = binary.length - 1; i >= 0; i--) {
            binary[i] = copyOfNum % 2;
            copyOfNum /= 2;
        }

        for (int i = 0; i < binary.length; i++) {
            System.out.print(binary[i]);
        }
    }
}
