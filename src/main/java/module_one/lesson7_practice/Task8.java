package module_one.lesson7_practice;

public class Task8 {
    public static void main(String[] args) {

        boolean[][] matrix = {
                {false, false, false, true},
                {true, false, true, false},
                {false, true, true, false},
                {false, true, true, false},
        };

        boolean hasTrue = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {
                if (matrix[i][j]){
                    hasTrue = true;
                    break;
                }
            }
        }

        System.out.println(hasTrue ? "There's \"true\"" : "There's not \"true\"");
    }
}
