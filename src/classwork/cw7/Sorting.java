package classwork.cw7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sorting {

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

    public static File promptFile() {
        Scanner s = new Scanner(System.in);
        File file = new File("src\\text\\" + s.nextLine());

        while (!file.exists()) {
            System.out.print("File does not exist. Try again: ");
            file = new File("src\\text\\" + s.nextLine());
        }

        return file;
    }

    public static String promptWordInDict(List<String> dict) {
        Scanner s = new Scanner(System.in);
        String word = s.next().toLowerCase();

        while (!dict.contains(word)) {
            System.out.print(word + " not found in dictionary. Enter another word: ");
            word = s.next();
        }

        return word;
    }

    public static List<String> readTextFile(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        List<String> text = new ArrayList<String>();

        while (s.hasNextLine())
            text.add(s.nextLine());

        return text;
    }

    public static int getWordDistance(List<String> dict, String a, String b) {
        return Math.abs(dict.indexOf(a) - dict.indexOf(b));
    }

    public static List<Comparable> bogoSort(List<Comparable> a) {
        int bigO = 0;

        while (!isSorted(a)) {
            Collections.shuffle(a);
            bigO++;
        }

        System.out.println("Bogo Sort: "+ bigO + " iterations.");

        return a;
    }

    public static boolean isSorted(List<Comparable> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).compareTo(a.get(i + 1)) < 0) {
                return false;
            }
        }

        return true;
    }
}
