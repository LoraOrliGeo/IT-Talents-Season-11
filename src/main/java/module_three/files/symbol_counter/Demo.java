package module_three.files.symbol_counter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        // count the number of commas in Lev Tolstoi's novel "War and Peace"

        File novel = new File("C:\\Users\\Lori\\Desktop\\voina_i_mir.txt");
        StringBuilder novelText = new StringBuilder();
        int commaCount = 0;

        try (Scanner sc = new Scanner(novel)) {
            while (sc.hasNextLine()) {
                novelText.append(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String text = novelText.toString();
        System.out.println(LocalDateTime.now());

        List<String> parts = partition(text, 2);

        for (int i = 0; i < parts.size(); i++) {
            Counter c = new Counter(parts.get(i), ',');
            c.start();
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            commaCount += c.getCurrentCount();
        }

        System.out.println(LocalDateTime.now());
        System.out.println("Number of commas: " + commaCount);
    }

    private static List<String> partition(String text, int numberOfPartitions) {
        int part = text.length() / numberOfPartitions;
        List<String> parts = new ArrayList<>();
        int start = 0;
        int end = part;
        for (int i = 0; i < numberOfPartitions; i++) {
            parts.add(text.substring(start, end));
            start += part;
            end += part;
        }
        return parts;
    }
}
