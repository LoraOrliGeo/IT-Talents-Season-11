package module_one.lesson3;

import java.util.Scanner;

public class Task19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int prev = sc.nextInt();

        while (prev != 1) {
            if (prev % 2 == 0) {
                prev = (int) (0.5 * prev);
            } else {
                prev = 3 * prev + 1;
            }
            System.out.print(prev + " ");
        }
    }
}
