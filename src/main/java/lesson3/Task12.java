package lesson3;

public class Task12 {
    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {
            int dec = i % 10;
            int tens = (i / 10) % 10;
            int hund = (i / 100) % 10;

            if (dec != tens && tens != hund && dec != hund){
                System.out.println(i);
            }
        }
    }
}