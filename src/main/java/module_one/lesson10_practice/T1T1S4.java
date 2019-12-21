package module_one.lesson10_practice;

import java.util.Arrays;
import java.util.Scanner;

public class T1T1S4 {
    public static void main(String[] args) {

        // 6.a)
//        sixA();

        // 6.b)
//        System.out.println(sixB()); // -> infinite loop

        // 6.c)
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        sixC(num);

        // 7
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        System.out.println(power(x, y));

        // 8
        String[] words = sc.nextLine().split(" ");
        printFrame(words);
    }

    private static void sixA() {
        int[] arr = {10, 22, 43, 64, 21};

        for (int i = 4; i >= 0; i--) {
            if (arr[i] > 21) {
                arr[i] = (arr[i] + 1) % (i + 1);
                i++;
            } else {
                arr[i] = arr[i] * 2;
                i--;
            }
            if (i >= 0) {
                System.out.println(arr[i]);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static int sixB() {
        int balance = 10;
        int times = 0;
        while (balance >= 1) {
            times++;
            if (balance < 9) {
                continue;
            }
            balance = balance - 9;
        }
        return times;
    }

    private static void sixC(int num) {
        boolean isCube = false;
        int n = 1;
        for (int i = 1; i < num; i++) {
            if (i * i * i == num) {
                isCube = true;
                n = i;
                break;
            }
        }

        if (isCube) {
            System.out.println(num + " is a cube of " + n);
        } else {
            System.out.println(num + " is not a cube");
        }
    }

    private static int power(int x, int y) {
        if (y == 0) {
            return 1;
        }

        return x * power(x, y - 1);
    }

    private static void printFrame(String[] words) {
        // number of words = cols
        int maxLength = words[0].length();
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            if (currWord.length() > maxLength) {
                maxLength = currWord.length();
            }
        }
        int cols = maxLength + 2;
        //print top line
        for (int i = 0; i < cols; i++) {
            System.out.print("*");
        }
        System.out.println();
        // print inside frame
        for (int i = 0; i < words.length; i++) {
            System.out.print("*" + words[i]);
            // print n spaces
            for (int j = 0; j < maxLength - words[i].length(); j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        //print bottom line
        for (int i = 0; i < cols; i++) {
            System.out.print("*");
        }
    }
}
