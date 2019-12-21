package module_three.exceptions;

public class ClassTask {
    public static void main(String[] args) {

        try {
            throw new LoriException("Lori is angry!");
        } catch (LoriException e) {
            e.printStackTrace();
        }

        int[] arr = {1, 2, 3, 4};
        printArrayInfo(arr);
    }

    static void printArrayInfo(int[] array) {
        try {
            System.out.println(array.length);
            System.out.println(array[3]);
            System.out.println("Some text here...");
        } catch (NullPointerException e) {
            System.out.println("The array is null");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
    }
}
