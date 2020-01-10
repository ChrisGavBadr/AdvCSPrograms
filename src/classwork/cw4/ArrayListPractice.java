package classwork.cw4;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPractice {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("to", "be", "or", "not", "to", "be", "that", "is", "the", "question"));
        System.out.println("Initial ArrayList of Strings: " + strings);

        double avgVowel = averageVowels(strings);
        System.out.println("Average Vowel Count: " + avgVowel);
        removeInRange(strings, "free", "rich");
        System.out.println("Removed In Range List: " + strings);
        doubleList(strings);
        System.out.println("Doubled List: " + strings);
    }

    private static double averageVowels(ArrayList<String> strings) {
        int charCount = 0;
        int avgVowel = 0;

        for (String s : strings) {
            for (char c : s.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1)
                    avgVowel++;
                charCount++;
            }
        }

        return charCount != 0 ? (double) avgVowel / charCount : 0;
    }

    private static void doubleList(ArrayList<String> strings) {
        int initialSize = strings.size();

        for (int i = 0; i < initialSize; i++)
            strings.add(2*i, strings.get(2*i));
    }

    private static void removeInRange(ArrayList<String> strings, String start, String end) {
        for (int i = strings.size() - 1; i >= 0; i--) {
            if (strings.get(i).compareTo(start) >= 0 && strings.get(i).compareTo(end) <= 0)
                strings.remove(i);
        }
    }
}
