package module_one.lesson7_practice;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] arr = {'a', 'c', 'f', 'D', '6', 'R', '?'};

        System.out.println("Enter a character:");
        char find = sc.next().charAt(0);

        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) {
                index = i;
                break;
            }
        }

        System.out.println(index != -1 ? "index of " + find + " is " + index : "there's not such element - index " + index);

    }
}
