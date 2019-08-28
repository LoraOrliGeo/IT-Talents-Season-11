package lesson3_practice;

public class Task2 {
    public static void main(String[] args) {

        System.out.println("Odd numbers between 0 and 50:");

        for (int i = 1; i <= 50; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Even numbers between 51 and 100:");

        for (int i = 52; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

    }
}
