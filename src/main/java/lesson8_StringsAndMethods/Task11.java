package lesson8_StringsAndMethods;

public class Task11 {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, -15, 9};

        printArray(array);

    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
