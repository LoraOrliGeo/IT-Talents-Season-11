package module_two.collections;

import java.util.*;

public class MostCommonLetters {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please Enter some text: ");
        String text = sc.nextLine().toUpperCase();

        Map<Character, Integer> letterOccurrence = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (Character.isAlphabetic(character)) {
                letterOccurrence.putIfAbsent(character, 0);
                letterOccurrence.put(character, letterOccurrence.get(character) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(letterOccurrence.entrySet());

        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        System.out.println("Most common letters:");

        int max = entries.get(0).getValue();
        int symbolMax = 20;

        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.print(String.format("%c: %d ", entry.getKey(), entry.getValue()));
            long times = Math.round((entry.getValue() * symbolMax) * 1.0 / max);
            for (int i = 0; i < times; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
