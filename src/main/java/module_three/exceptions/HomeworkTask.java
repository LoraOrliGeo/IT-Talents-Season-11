package module_three.exceptions;

import java.util.Arrays;

public class HomeworkTask {
    public static void main(String[] args) {

        int[] a1 = {8, 3, 10, 24, 0, 4, 7, 4};
        int[] a2 = {4, 0, 5, 3, 9, 4};

        System.out.println(Arrays.toString(divideArrays(a1, a2)));
    }

    static int[] divideArrays(int[] a1, int[] a2) {
        int minLength = Math.min(a1.length, a2.length);
        int[] result = new int[minLength];

        for (int i = 0; i < minLength; i++) {
            try {
                result[i] = a1[i] / a2[i];
            } catch (ArithmeticException ae) {
                result[i] = 0;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
