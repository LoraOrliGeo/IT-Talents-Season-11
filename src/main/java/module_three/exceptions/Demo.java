package module_three.exceptions;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Code executed before try-finally.");
        Scanner sc = new Scanner(System.in);

        try {
            String str = sc.nextLine();
            Integer.parseInt(str);
            System.out.println("Parsing was successful.");
            return; // the finally block will be executed always!
            // System.exit(0); -> in this case finally won't be executed
        } catch (NumberFormatException ex) {
            System.out.println("Parsing failed!");
        } finally {
            System.out.println("This cleanup code is always executed.");
        }

        System.out.println("This code is after the try-finally block.");
    }
}
