package lesson2;

import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int dec = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = number / 100;

        if (dec == tens && tens == hundreds){
            System.out.println("The digits are equal!");
        } else if (dec > tens && tens > hundreds){
            System.out.println("The digits are in decreasing order!");
        } else if (dec < tens && tens < hundreds){
            System.out.println("The digits are in increasing order!");
        } else {
            System.out.println("The digits are not in any of the described orders");
        }
    }
}
