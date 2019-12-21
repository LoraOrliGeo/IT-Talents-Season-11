package module_three.files;

import java.io.*;
import java.util.Scanner;

public class StreamsDemo {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(new File("C:\\Users\\Lori\\Desktop\\test.txt"))) {
            int b = fis.read();
            while (b != -1) {
                System.out.print((char) b);
                b = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Lori\\Desktop\\test.txt"), true)) {
            fos.write(45); // -
            fos.write('a');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Writer writer = new FileWriter(new File("C:\\Users\\Lori\\Desktop\\test.txt"), true)) {
            writer.write("I'm writing this using file writer :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
