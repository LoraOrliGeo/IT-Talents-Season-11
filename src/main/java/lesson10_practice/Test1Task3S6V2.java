package lesson10_practice;

public class Test1Task3S6V2 {
    public static void main(String[] args) {

        int[] arr = {-5, 2, 3, 5, 6, -3};

        System.out.println(calculateSumDivisibleByThree(arr, 0));
    }

    private static int calculateSumDivisibleByThree(int[] arr, int i) {
        if (i == arr.length) {
            return 0;
        }
        if (arr[i] % 3 == 0) {
            return arr[i] + calculateSumDivisibleByThree(arr, i + 1);
        }
        return calculateSumDivisibleByThree(arr, i + 1);
    }
}
