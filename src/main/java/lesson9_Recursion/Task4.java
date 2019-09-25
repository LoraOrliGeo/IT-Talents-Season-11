package lesson9_Recursion;

public class Task4 {
    public static void main(String[] args) {

        //print nums from 10 to 1 (backwards)
        //O(N)

        printNumbers(10, 1);
    }

    private static void printNumbers(int end, int start) {
        if (end < start) {
            return;
        }
        System.out.println(end--);
        printNumbers(end, start);
    }
}
