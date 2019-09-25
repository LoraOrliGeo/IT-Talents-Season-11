package lesson7_practice;

public class Task6 {
    public static void main(String[] args) {

        char[][] matrix = {
                {'a', 'D', '3', '?', 'W'},
                {'!', '8', 'X', 'b', 'o'},
                {'y', '#', ';', '+', 'l'},
                {'Q', 'D', '3', '*', 'r'},
                {'u', 'N', '-', '?', '>'},
        };

        System.out.println("Elements on the main diagonal are: ");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }

        //another faster way:

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.print(matrix[i][i] + " ");
//        }
    }
}
