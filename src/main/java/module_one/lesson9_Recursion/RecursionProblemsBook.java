package module_one.lesson9_Recursion;

public class RecursionProblemsBook {
    public static void main(String[] args) {

        //1
//        System.out.println(factorial(5));

        //2 - min element of array
//        int[] arr = {2, -9, 5, 3, 1, 4};
//        System.out.println(getMinElement(arr, 0));

        //3 - monotonic growing
//        int[] arr1 = {1, 2, 1, 1, 6, 19};
//        System.out.println(isMonGrowing(arr1, 0));

        //4
//        int[] arr2 = {1,2,3,6,5,4,8,9,16,18,25,19,35,44,-1,-15};
//        System.out.println(hasRepeatingNums(arr2, 0));

        //5
//        int[] arr3 = {2, 15, -2, 3, 19, 25, -5};
//        System.out.println(getIndexOfMaxElement(arr3, 0));

        //6
//        String num = "321";
//        System.out.println(reverseNumber(num));

        //7
//        printPattern(1,6,1);

        //8
//        System.out.println(isPrime(1,2));

        //9
//        System.out.println(calcProduct(5,0));

        //10
        System.out.println(calcPower(2,3));
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    private static int getMinElement(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        int next = getMinElement(arr, i + 1);
        if (arr[i] < next) {
            return arr[i];
        }
        return next;

        // return Math.min(arr[i], getMinElement(arr, i+1)
    }

    private static boolean isMonGrowing(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        return arr[i] <= arr[i + 1] && isMonGrowing(arr, i + 1);
    }

    private static boolean hasRepeatingNums(int[] arr, int i) {
        if (i == arr.length - 1) {
            return false;
        }
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] == arr[i]) {
                return true;
            }
        }
        return hasRepeatingNums(arr, i + 1);
    }

    private static int getIndexOfMaxElement(int[] arr, int i) {
        if (i == arr.length - 1) {
            return i;
        }
        int maxIdx = getIndexOfMaxElement(arr, i + 1);
        if (arr[i] > arr[maxIdx]) {
            return i;
        }
        return maxIdx;
    }

    private static String reverseNumber(String number){
        if (number.length() == 1){
            return number;
        }
        return reverseNumber(number.substring(1)) + number.charAt(0);
    }

    private static String reverseNumber(String number, int i){
        if (i == number.length() - 1){
            return number.charAt(i) + "";
        }
        return reverseNumber(number, i + 1) + number.charAt(i);
    }

    private static void printPattern(int start, int end, int times){
        if (times > end){
            return;
        }
        for (int i = start; i <= times; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        printPattern(start, end, times + 1);
    }

    private static boolean isPrime(int number, int divisor){
        if (divisor >= number){
            return true;
        }
        if (number % divisor == 0){
            return false;
        }
        return isPrime(number, divisor + 1);
    }

    private static int calcProduct(int x, int y){
        if (y == 0){
            return 0;
        }
        if (y == 1){
            return x;
        }
        return x + calcProduct(x, y - 1);
    }

    private static int calcPower(int number, int pow){
        if (pow == 0){
            return 1;
        }
        if (pow == 1){
            return number;
        }
        return calcProduct(number, calcPower(number, pow - 1));
    }
}
