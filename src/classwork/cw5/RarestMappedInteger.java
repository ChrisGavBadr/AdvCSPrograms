package classwork.cw5;

import java.util.*;

public class RarestMappedInteger {

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 4, 5));
        Collections.shuffle(ints);
        Map<String, Integer> strNums = new TreeMap<String, Integer>();
        initializeMap(strNums);

        System.out.println("\nString->Integer Map: " + strNums.toString());
        int rarestInt = rarest(strNums);
        System.out.println("Rarest Integer: " + rarestInt);
    }

    public static void initializeMap(Map<String, Integer> a) {
        a.put("A", 1);
        a.put("B", 1);
        a.put("C", 2);
        a.put("D", 2);
        a.put("E", 3);
        a.put("F", 3);
        a.put("G", 4);
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
}
