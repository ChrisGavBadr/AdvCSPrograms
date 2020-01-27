package classwork.cw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageVowels {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>(Arrays.asList("to", "be", "or", "not", "to", "be", "that", "is", "the", "question"));
        System.out.println("List: " + strings);

        double avgVowel = averageVowels(strings);
        System.out.println("Average Vowel Count: " + avgVowel);
    }

    private static double averageVowels(List<String> strings) {
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
}
