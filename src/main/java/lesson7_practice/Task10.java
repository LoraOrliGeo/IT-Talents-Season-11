package lesson7_practice;

public class Task10 {
    public static void main(String[] args) {

        int[] arr = {1,5,6,2,3,5,5,1,4,6,3,2,2,3,4,6,6,1,2,5,3,4,2,5,6,6,6,6,6,6};

        int maxTimesMet = 0;
        int maxElMet = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int currEl = arr[i];
            int currTimesMet = 0;

            for (int j = i; j < arr.length; j++) {
                if (currEl == arr[j]){
                    currTimesMet ++;
                }
            }

            if (currTimesMet >= maxTimesMet){
                maxTimesMet = currTimesMet;
                maxElMet = currEl;
            }
        }

        System.out.println("The most common element is " + maxElMet + " -> " + maxTimesMet + " times");
    }
}
