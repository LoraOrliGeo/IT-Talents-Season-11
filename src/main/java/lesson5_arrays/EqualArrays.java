package lesson5_arrays;

public class EqualArrays {
    public static void main(String[] args) {

        //check if two arrays are equal

        //two arrays are equal if they have same length and the elements of the same indices are equal

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(arr1 == arr2);
        // false - although they have same length and elements, they're pointing to two different addresses in the heap

        arr1 = arr2;
        // the first reference is pointing to the second array in the heap
        // and arr1, and arr2 are pointing to the second {1,2,3,4,5}

        int[] arr3 = {1, 2, 3, 4, 10};
        int[] arr4 = {1, 3, 2, 4};

        boolean areEqual = true;

        if (arr3.length == arr4.length) {
            for (int i = 0; i < arr3.length; i++) {
                if (arr3[i] != arr4[i]) {
                    areEqual = false;
                    break;
                }
            }
        } else {
            areEqual = false;
        }

        if (areEqual) {
            System.out.println("The two arrays are equal!");
        } else {
            System.out.println("The two arrays are NOT equal!");
        }
    }
}
