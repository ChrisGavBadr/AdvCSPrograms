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
        String a = promptWord(dict);
        System.out.print("\tWord 2: ");
        String b = promptWord(dict);
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

    private static String promptWord(List<String> dict) {
        Scanner s = new Scanner(System.in);
        String word = s.next().toLowerCase();

        while (!dict.contains(word)) {
            System.out.print("\"" + word + "\"" + " not found in dictionary. Continue? [1] Yes | [0] No: ");

            if (s.nextInt() == 0) {
                System.out.print("\tWord: ");
                word = s.next().toLowerCase();
            } else
                return word;
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
        int idxA = dict.contains(a) ? dict.indexOf(a) : getTheoreticalIndex(dict, a);
        int idxB = dict.contains(b) ? dict.indexOf(b) : getTheoreticalIndex(dict, b);

        return Math.abs(idxA - idxB) + (!dict.contains(a) && !dict.contains(b) ? 1 : 0);
    }

    private static int getTheoreticalIndex(List<String> s, String target) {
        return getTheoreticalIndex(s, target, 0, s.size() - 1);
    }

    private static int getTheoreticalIndex(List<String> s, String target, int min, int max) {
        int mid =  (max + min) / 2;

        if (min > max)
            return mid + 1;
        else if (target.compareTo(s.get(mid)) < 0)
            return getTheoreticalIndex(s, target, min, mid - 1);
        else
            return getTheoreticalIndex(s, target, mid + 1, max);
    }
}
