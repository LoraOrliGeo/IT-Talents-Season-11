package lesson10_practice;

public class Test1Task3S6V1 {
    public static void main(String[] args) {

        // write a method that by given array of integers verifies whether all
        // of the elements are positive numbers. The method returns boolean
        // use recursion!

        int[] arr = {1, 5, -3, 2, 3, 16};

        boolean hasNegative = hasNegativeNumber(arr);
        System.out.println(hasNegative);

        boolean hasNegativeRec = hasNegativeNumberRec(arr,0);
        System.out.println(hasNegativeRec);
    }

    private static boolean hasNegativeNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0){
                return true;
            }
        }
        return false;
    }

    private static boolean hasNegativeNumberRec(int[] arr, int i) {
        // base case
        if (i == arr.length){
            return false;
        }
        //body
        if (arr[i] < 0){
            return true;
        }
        // step
        return hasNegativeNumberRec(arr, i + 1);
    }
}
