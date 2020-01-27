package classwork.cw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInRange {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>(Arrays.asList("to", "be", "or", "not", "to", "be", "that", "is", "the", "question"));
        System.out.println("List: " + strings);

        removeInRange(strings, "free", "rich");
        System.out.println("Removed-In-Range List: " + strings);
    }

    private static void removeInRange(List<String> strings, String start, String end) {
        for (int i = strings.size() - 1; i >= 0; i--) {
            if (strings.get(i).compareTo(start) >= 0 && strings.get(i).compareTo(end) <= 0)
                strings.remove(i);
        }
    }
}
