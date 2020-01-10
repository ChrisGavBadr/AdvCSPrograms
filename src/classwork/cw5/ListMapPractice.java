package classwork.cw5;

import java.util.*;

public class ListMapPractice {

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4));
        Collections.shuffle(ints);
        Map<String, Integer> strNums = new TreeMap<String, Integer>();
        Map<Integer, Integer> a = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> b = new TreeMap<Integer, Integer>();

        initlialize(strNums, a, b);

        System.out.println("Original List: " + ints.toString());
        sortAndRemoveDuplicates(ints);
        System.out.println("Sorted List w/o Duplicates: " + ints.toString());
        ints = Arrays.asList(1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 4, 5);
        Collections.shuffle(ints);

        System.out.println("\nString->Integer Map: " + strNums.toString());
        int rarestInt = rarest(strNums);
        System.out.println("Rarest Integer: " + rarestInt);

        System.out.println("\nOriginal List: " + ints.toString());
        partition(ints, 3);
        System.out.println("Partitioned List: " + ints.toString());

        System.out.println("\nMap A: " + a.toString());
        System.out.println("Map B: " + b.toString());
        Map<Integer, Integer> intersection = intersect(a, b);
        System.out.println("Map A n B: " + intersection.toString());
    }

    public static void initlialize(Map<String, Integer> strNums, Map<Integer, Integer> a, Map<Integer, Integer> b) {
        strNums.put("A", 1);
        strNums.put("B", 1);
        strNums.put("C", 2);
        strNums.put("D", 2);
        strNums.put("E", 3);
        strNums.put("F", 3);
        strNums.put("G", 4);

        a.put(1, 4);
        a.put(5, 8);
        a.put(9, 1);
        a.put(16, 8);

        b.put(1, 4);
        b.put(7, 3);
        b.put(16, 8);
        b.put(4, 6);
    }

    public static void sortAndRemoveDuplicates(List<Integer> ints) {
        Collections.sort(ints);

        for (int i = ints.size() - 1; i > 0; i--) {
            if (ints.get(i) == ints.get(i - 1))
                ints.remove(i);
        }
    }

    public static int rarest(Map<String, Integer> strNums) {
        Map<Integer, Integer> cnts = new TreeMap<>();
        Iterator<String> strItr = strNums.keySet().iterator();
        int smallestCnt = strNums.size();
        int rarestInt = 0;

        while (strItr.hasNext()) {
            int val = strNums.get(strItr.next());
            if (cnts.containsKey(val))
                cnts.put(val, cnts.get(val) + 1);
            else
                cnts.put(val, 1);
        }

        Iterator<Integer> cntItr = cnts.keySet().iterator();

        while (cntItr.hasNext()) {
            int key = cntItr.next();
            int cnt = cnts.get(key);

            if (cnt < smallestCnt) {
                smallestCnt = cnt;
                rarestInt = key;
            }
        }

        return rarestInt;
    }

    public static void partition(List<Integer> ints, int E) {
        List<Integer> partition = new LinkedList<Integer>();
        Iterator<Integer> itr = ints.iterator();

        while (itr.hasNext()) {
            int num = itr.next();

            if (num < E)
                partition.add(0, num);
            else
                partition.add(num);
        }

        Collections.copy(ints, partition);
    }

    public static Map<Integer, Integer> intersect(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> intersection = new TreeMap<Integer, Integer>();
        Iterator<Integer> itrA = a.keySet().iterator();
        Iterator<Integer> itrB = b.keySet().iterator();

        while (itrA.hasNext()) {
            while (itrB.hasNext()) {
                int keyA = itrA.next();
                int keyB = itrB.next();

                if (keyA == keyB && a.get(keyA) == b.get(keyB))
                    intersection.put(keyA, a.get(keyA));
            }
        }

        return intersection;
    }
}
