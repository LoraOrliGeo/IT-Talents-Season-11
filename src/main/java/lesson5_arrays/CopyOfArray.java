package lesson5_arrays;

import java.util.Arrays;

public class CopyOfArray {
    public static void main(String[] args) {

        int[] original = {1, 2, 3, 4, 5, 6};
        int[] copy;

        copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(copy));
    }
}
