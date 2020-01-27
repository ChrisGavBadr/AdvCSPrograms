package classwork.cw7;

import java.util.*;

public class StringBinarySearch {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> words = new LinkedList<String>(Arrays.asList("Did", "you", "know", "that", "my", "name", "is", "Christian", "Baduria", "?"));
        System.out.println("Original List: " + words.toString());
        Collections.sort(words);
        System.out.println("Sorted List: " + words.toString());
        System.out.print("Target: ");
        String target = s.next();

        int idx = stringBinarySearch(words, target);

        if (idx < 0)
            System.out.println("Target not found.");
        else
            System.out.println("Target found! \"" + target + "\" is located at index " + idx + ".");
    }

    private static int stringBinarySearch(List<String> s, String target) {
        return stringBinarySearch(s, target, 0, s.size() - 1);
    }

    private static int stringBinarySearch(List<String> s, String target, int min, int max) {
        int mid =  (max + min) / 2;

        if (min > max)
            return -1;
        else if (target.compareTo(s.get(mid)) < 0)
            return stringBinarySearch(s, target, min, mid - 1);
        else if (target.compareTo(s.get(mid)) > 0)
            return stringBinarySearch(s, target, mid + 1, max);
        else
            return mid;
    }
}
