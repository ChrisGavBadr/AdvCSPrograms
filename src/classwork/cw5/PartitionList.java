package classwork.cw5;

import java.util.*;

public class PartitionList {

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4));
        Collections.shuffle(ints);
        int separator = 3;

        System.out.println("\nOriginal List: " + ints.toString());
        partition(ints, separator);
        System.out.println("Partitioned List: " + ints.toString());
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
}
