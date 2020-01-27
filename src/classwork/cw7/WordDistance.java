package classwork.cw7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordDistance {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Dictionary Text File: ");
        List<String> dict = readTextFile(promptFile());
        System.out.println("Enter 2 Words from the Dictionary");
        System.out.print("\tWord 1: ");
        String a = promptWordInDict(dict);
        System.out.print("\tWord 2: ");
        String b = promptWordInDict(dict);
        int wordDist = getWordDistance(dict, a, b);
        System.out.printf("The words \"%s\" and \"%s\" are %d words apart in the dictionary.", a, b, wordDist);
    }

    private static File promptFile() {
        Scanner s = new Scanner(System.in);
        File file = new File("src\\text\\" + s.nextLine());

        while (!file.exists()) {
            System.out.print("File does not exist. Try again: ");
            file = new File("src\\text\\" + s.nextLine());
        }

        return file;
    }

    private static String promptWordInDict(List<String> dict) {
        Scanner s = new Scanner(System.in);
        String word = s.next().toLowerCase();

        while (!dict.contains(word)) {
            System.out.print(word + " not found in dictionary. Enter another word: ");
            word = s.next();
        }

        return word;
    }

    private static List<String> readTextFile(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        List<String> text = new ArrayList<String>();

        while (s.hasNextLine())
            text.add(s.nextLine());

        return text;
    }

    private static int getWordDistance(List<String> dict, String a, String b) {
        return Math.abs(dict.indexOf(a) - dict.indexOf(b));
    }
}
