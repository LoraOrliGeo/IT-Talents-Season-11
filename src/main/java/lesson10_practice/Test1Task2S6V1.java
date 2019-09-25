package lesson10_practice;

import java.util.Scanner;

public class Test1Task2S6V1 {
    public static void main(String[] args) {

        /*
        write a function that takes a String variable that hold some text
        the program must output the length of the longest sentence in a text
        and the number of sentences
        it's given that each sentence starts with a capital letter and
        there are not other capital letter word in each sentence

        Ex: Today is a good day for test. Sun is shining. The students are happy.
        The birds are blue.

        29 (Today is a good day for test.)
        4 sentences in text
         */

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] sentences = text.split("[ ][A-Z]");

        System.out.println("Longest sentence length is " + getLengthLongestSentence(sentences));
        System.out.println(sentences.length + " sentences in the text.");
    }

    private static int getLengthLongestSentence(String[] sentences){
        int maxLength = sentences[0].length() - 1;
        for (int i = 1; i < sentences.length; i++) {
            int currLength = sentences[i].length();
            if (currLength > maxLength){
                maxLength = currLength;
            }
        }
        return maxLength + 1;
    }
}
