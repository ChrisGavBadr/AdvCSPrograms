package classwork.cw7;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        List<Comparable> n = new LinkedList<>(Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8));

        System.out.println("Unsorted List: " + n.toString());
        quickSort(n);
        System.out.println("Sorted List: " + n.toString());
    }

    private static void quickSort(List<Comparable> a) {
        quickSort(a, 0, a.size() - 1);
    }

    private static void quickSort(List<Comparable> a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);

            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static int partition(List<Comparable> a, int low, int high) {
        Comparable pivot = a.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a.get(j).compareTo(pivot) < 0) {
                i++;
                Collections.swap(a, i, j);
            }
        }

        Collections.swap(a, i + 1, high);

        return i + 1;
    }
}
