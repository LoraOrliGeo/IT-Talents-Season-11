package main.java.lesson2;

import java.util.Scanner;

public class PrimitiveTypesAndVariables {
    public static void main(String[] args) {

        //1
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(String.format("%.0f",Math.pow(i, 2)));
//        }

        //2
        Scanner sc = new Scanner(System.in);

//        int radius = Integer.parseInt(sc.nextLine());
//        double circleArea = Math.PI * Math.pow(radius, 2);
//        System.out.println("Area of circle:" + circleArea);

        //3
//        int a = Integer.parseInt(sc.nextLine());
//        int b = Integer.parseInt(sc.nextLine());
//
//        System.out.println("Area of rectangular: " + a * b);

        //4
//        int a = Integer.parseInt(sc.nextLine());
//        int b = Integer.parseInt(sc.nextLine());
//        int c = Integer.parseInt(sc.nextLine());
//
//        if (a < b + c && b < a + c && c < a + b){
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

        //5
//        int a = Integer.parseInt(sc.nextLine());
//
//        if (a % 7 == 0){
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

        //decimal to binary
        int dec = Integer.parseInt(sc.nextLine());
        String bin = "";

        while(dec != 0){
            int remainder = dec % 2;
            dec /= 2;
            bin += remainder;
        }

        for (int i = bin.length() - 1; i >=0 ; i--) {
            System.out.print(bin.charAt(i));
        }

        //tricky way :D
        String binary = Integer.toBinaryString(dec);
        System.out.println(binary);
    }
}
