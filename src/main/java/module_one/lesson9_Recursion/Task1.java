package module_one.lesson9_Recursion;

public class Task1 {
    public static void main(String[] args) {

        //print the numbers from 1 to 100 and from 100 to 1
        // O(N)

        printNum(1, 100);
        printNumBackwards(100,1);
    }

    private static void printNum(int start, int end) {
        if (start > end){
            return;
        }
        System.out.println(start++);
        printNum(start, end);
    }

    private static void printNumBackwards(int start, int end) {
        if (start < end){
            return;
        }
        System.out.println(start--);
        printNumBackwards(start, end);
    }
}
