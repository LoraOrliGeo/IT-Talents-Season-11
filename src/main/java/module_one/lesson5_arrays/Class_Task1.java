package module_one.lesson5_arrays;

import java.util.Scanner;

public class Class_Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] workersNames = new String[10];

        for (int i = 0; i < workersNames.length; i++) {
            workersNames[i] = sc.nextLine();
        }

        System.out.println("Names in order of input:");
        for (int i = 0; i < workersNames.length; i++) {
            System.out.print(workersNames[i] + " ");
        }

        System.out.println();
        System.out.println("Names in opposite order of input:");
        for (int i = workersNames.length - 1; i >= 0 ; i--) {
            System.out.print(workersNames[i] + " ");
        }
    }
}
