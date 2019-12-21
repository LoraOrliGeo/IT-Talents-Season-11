package module_three.files;

import java.io.File;

public class FindFile {

    public static void main(String[] args) {

        String fileName = "test.txt";
        boolean isFound = search(new File("C:\\Users\\Lori\\Desktop"), fileName);
        System.out.println(isFound);
    }

    private static boolean search(File file, String fileName) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File dir : files) {
                    boolean search = search(dir, fileName);
                    if (search) {
                        return true;
                    }
                }
            }
        } else {
            return file.getName().equals(fileName);
        }
        return false;
    }
}
