package module_one.lesson9_Recursion;

public class Task2 {
    public static void main(String[] args) {

        // print numbers from -20 to 50
        // O(N)

        printNumbers(-20, 50);

    }

    private static void printNumbers(int start, int end) {
        if (start > end){
            return;
        }
        System.out.println(start++);
        printNumbers(start, end);
    }
}
