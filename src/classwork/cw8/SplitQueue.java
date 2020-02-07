package classwork.cw8;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SplitQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, -5, 3, -20, -6, 17, 9, -14, -8, -12, 12, -1, 5, 7, -18, -10, -9, -13, -2, 0, -3, -19, 20, -15, 8, 16, 14, -16, 6, 1, 15, 2, 13, -4, 19, -7, 4, -11, -17, 18, 11));

        System.out.println("Original Queue: " + q.toString());
        splitQueue(q);
        System.out.println("Polarized Queue: " + q.toString());
    }

    public static void splitQueue(Queue<Integer> q) {
        Queue<Integer> positives = new LinkedList<>();
        int queueSize = q.size();

        for (int i = 0; i < queueSize; i++) {
            if (q.peek() >= 0)
                positives.add(q.remove());
            else
                q.add(q.remove());
        }

        q.addAll(positives);
    }
}
