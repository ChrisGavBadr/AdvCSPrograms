package classwork.cw5;

import java.util.*;

public class MapIntersections {

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4));
        Collections.shuffle(ints);
        Map<Integer, Integer> a = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> b = new TreeMap<Integer, Integer>();
        initializeMaps(a, b);

        System.out.println("\nMap A: " + a.toString());
        System.out.println("Map B: " + b.toString());
        Map<Integer, Integer> intersection = intersect(a, b);
        System.out.println("Map A n B: " + intersection.toString());
    }

    public static void initializeMaps(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        a.put(1, 4);
        a.put(5, 8);
        a.put(9, 1);
        a.put(16, 8);

        b.put(1, 4);
        b.put(7, 3);
        b.put(16, 8);
        b.put(4, 6);
    }

    public static Map<Integer, Integer> intersect(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> intersection = new TreeMap<Integer, Integer>();
        Iterator<Integer> itrA = a.keySet().iterator();
        Iterator<Integer> itrB = b.keySet().iterator();

        while (itrA.hasNext()) {
            while (itrB.hasNext()) {
                int keyA = itrA.next();
                int keyB = itrB.next();

                if (keyA == keyB && a.get(keyA).equals(b.get(keyB)))
                    intersection.put(keyA, a.get(keyA));
            }
        }

        return intersection;
    }
}
