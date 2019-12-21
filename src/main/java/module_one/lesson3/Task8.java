package module_one.lesson3;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int digit = n - 1;

        for (int i = 1; i <= n; i++) {
            String result = "";

            for (int j = 1; j <= n; j++) {
                result += digit + "";
            }

            digit += 2;
            System.out.println(result);
        }
    }
}
