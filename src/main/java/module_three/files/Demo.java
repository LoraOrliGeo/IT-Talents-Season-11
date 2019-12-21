package module_three.files;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir")); // local git repository

        File f = new File("C:\\Users\\Lori\\Desktop\\createFile.txt");
        if (!f.exists()) {
            try {
                f.createNewFile(); // empty
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String path = "C:\\Users\\Lori\\Desktop\\test.txt";

        //reading a file
        try (FileInputStream is = new FileInputStream(path)) {
            int a = is.read();
            while (a != -1) {
                System.out.print((char) a);
                a = is.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // writing in file
        File file = new File("C:\\Users\\Lori\\Desktop\\output.txt");
        try (PrintStream ps = new PrintStream(new FileOutputStream(file, true))) {
            ps.append("I'm appending lines 8-)" + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
