package module_one.lesson5_arrays;

public class Task5 {
    public static void main(String[] args) {

        int[] arr = new int[10];

        System.out.print("The result array is: [");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;

            if (i == arr.length - 1){
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }

    }
}
