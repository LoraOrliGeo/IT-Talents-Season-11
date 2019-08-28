package lesson2;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int temperature = sc.nextInt();

        if (temperature >= 25) {
            System.out.println("hot!");
        } else if (temperature >= 15) {
            System.out.println("warm ^^");
        } else if (temperature >= 0) {
            System.out.println("chill");
        } else if (temperature >= -20) {
            System.out.println("cold");
        } else {
            System.out.println("sooo cold - winter is coming!");
        }
    }
}
