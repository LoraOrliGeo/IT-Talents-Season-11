package module_one.lesson9_Recursion;

public class Task3 {
    public static void main(String[] args) {

        //print all odd numbers from -10 to 10
        //O(N)

        printOddNumbers(-10, 10);
    }

    private static void printOddNumbers(int start, int end) {
        if (start > end) {
            return;
        }
        if (start % 2 != 0) {
            System.out.println(start++);
        }
        printOddNumbers(start, end);
    }
}
