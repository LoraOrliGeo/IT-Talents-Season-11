package module_three.files;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {

        String path = "C:\\Users\\Lori\\Desktop\\javaTest\\iotest";
        File dir = new File(path);
        boolean folder = dir.mkdirs();

        if (folder) {
            System.out.println("Folder created!");
        }

        File file = new File(path + "\\test.txt");
        File secondFile = new File(path + "\\secondFile.txt");
        if (!file.exists() || !secondFile.exists()) {
            try {
                file.createNewFile();
                secondFile.createNewFile();
                System.out.println("File created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (File f : dir.listFiles()) {
            System.out.println(f.getName());

            if (f.getName().startsWith("t")) {
                f.delete();
                System.out.println("File starting with \"t\" was deleted!");
            }
        }

    }
}
