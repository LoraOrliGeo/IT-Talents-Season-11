package module_one.lesson7_practice;

public class Task2 {
    public static void main(String[] args) {

        int[] arr = {2,5,3,4,1};

        boolean isZigZag = true;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i - 1] && arr[i] >= arr[i + 1]){
                isZigZag = false;
                break;
            } else if (arr[i] >= arr[i - 1] && arr[i] <= arr[i + 1]){
                isZigZag = false;
                break;
            }
        }

        System.out.println(isZigZag ? "It's zig-zag" : "It's not zig-zag");
    }
}
