package classwork.cw7;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BogoSort {

    public static void main(String[] args) {
        List<Integer> vals = new LinkedList<Integer>(Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println("Original List: " + vals.toString());
        int iterations = bogoSort(vals);
        System.out.println("Sorted List: " + vals.toString());
        System.out.println("Bogo Sort Efficiency: " + iterations + " iterations");
    }

    private static int bogoSort(List<Integer> a) {
        int iterations = 0;

        while (!isSorted(a)) {
            Collections.shuffle(a);
            iterations++;
        }

        return iterations;
    }

    private static boolean isSorted(List<Integer> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }
}
