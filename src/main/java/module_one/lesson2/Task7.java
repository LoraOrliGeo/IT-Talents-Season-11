package module_one.lesson2;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt(); // it's not necessary
        double money = sc.nextDouble();
        boolean isHealthy = sc.nextBoolean();

        if (!isHealthy) {
            if (money > 0){
                System.out.println("I will buy some medicines :(");
            } else {
                System.out.println("No money - I'll stay at home and I'll drink tea");
            }
        } else {
            if (0 < money && money < 10) {
                System.out.println("I'm going to cafe");
            } else {
                System.out.println("I'm going to the cinema with friends");
            }
        }
    }
}
