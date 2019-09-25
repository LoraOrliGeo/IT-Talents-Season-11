package lesson7_practice;

public class Task4 {
    public static void main(String[] args) {

        int[] arr = {0,1,0,0,1,1,0,1,0,1};

        int countOfZeroes = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                countOfZeroes++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < countOfZeroes){
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        System.out.print("The sorted array is [");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
