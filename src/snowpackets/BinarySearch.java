package snowpackets;

import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        List<Comparable> s = new ArrayList<>(Arrays.asList("Hello", "my", "name", "is", "Christian", "Baduria"));
        Collections.sort(s);
        String target = "Christian";

        System.out.println("List: " + s.toString());
        System.out.println("Target: " + target);

        int idx = binarySearch(s, target);

        if (idx < 0)
            System.out.println("Target not found.");
        else
            System.out.println("Target found! \"" + target + "\" is located at index " + idx + ".");
    }

    public static int binarySearch(List<Comparable> s, Comparable target) {
        return binarySearch(s, target, 0, s.size() - 1);
    }

    public static int binarySearch(List<Comparable> s, Comparable target, int min, int max) {
        int mid =  (max + min) / 2;

        if (min > max)
            return -1;
        else if (target.compareTo(s.get(mid)) < 0)
            return binarySearch(s, target, min, mid - 1);
        else if (target.compareTo(s.get(mid)) > 0)
            return binarySearch(s, target, mid + 1, max);
        else
            return mid;
    }
}
