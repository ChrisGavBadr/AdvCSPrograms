package classwork.cw5;

import java.util.*;

public class SortAndRemoveDuplicates {

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4));
        Collections.shuffle(ints);

        System.out.println("Original List: " + ints.toString());
        sortAndRemoveDuplicates(ints);
        System.out.println("Sorted List w/o Duplicates: " + ints.toString());
    }

    public static void sortAndRemoveDuplicates(List<Integer> ints) {
        Collections.sort(ints);

        for (int i = ints.size() - 1; i > 0; i--) {
            if (ints.get(i).equals(ints.get(i - 1)))
                ints.remove(i);
        }
    }
}
