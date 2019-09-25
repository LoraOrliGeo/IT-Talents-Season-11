package lesson8_StringsAndMethods;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input:");
        String input = sc.nextLine();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (isDigit(symbol) || isDash(symbol)) {


                int num;
                if (isDash(symbol)) {
                    num = 0;
                } else {
                    num = symbol - '0';
                }

                boolean digitExistsAfterDash = false;

                for (int j = i + 1; j < input.length(); j++) {
                    char sym = input.charAt(j);
                    if (isDigit(sym)) {
                        digitExistsAfterDash = true;
                        num *= 10;
                        num += sym - '0';
                        i++;
                    } else {
                        break;
                    }
                }

                if (!digitExistsAfterDash){
                    continue;
                }

                if (isDash(symbol)) {
                    num = num * -1;
                }

                sum += num;
                System.out.println(num);
            }
        }

        System.out.println("Sum = " + sum);
    }

    public static boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    public static boolean isDash(char symbol) {
        return symbol == '-';
    }
}
