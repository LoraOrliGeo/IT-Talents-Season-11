package lesson8_StringsAndMethods;

import java.util.Arrays;

public class Task13 {
    public static void main(String[] args) {

        int[] first = {1, 5, 3, -2, 0, 15, -9};
        int[] second = {9, 13, -4, 6, 18};

        int[] result = createThirdArray(first, second);
        System.out.println(Arrays.toString(result));
    }

    private static int[] createThirdArray(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];

        for (int i = 0; i < first.length; i++) {
            result[i] = first[i];
        }

        int index = 0;
        for (int i = first.length; i < result.length; i++) {
            result[i] = second[index++];
        }

        return result;
    }
}
