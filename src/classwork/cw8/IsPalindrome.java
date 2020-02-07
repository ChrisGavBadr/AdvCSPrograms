package classwork.cw8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPalindrome {

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(4, 3, 2, 1, 0, 1, 2, 3, 4));
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(4, 3, 2, 1, 1, 2, 3, 4));
        Queue<Integer> q3 = new LinkedList<>(Arrays.asList(4, 3, 1, 2, 3, 4));

        Queue<Queue<Integer>> tests = new LinkedList<>(Arrays.asList(q1, q2, q3));

        while (!tests.isEmpty()) {
            Queue<Integer> q = tests.remove();
            System.out.println("Queue: " + q.toString());
            System.out.println("Palindrome Status: " + isPalindrome(q));
        }
    }

    public static boolean isPalindrome(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        s.addAll(q);

        while (!q.isEmpty()) {
            if (!q.remove().equals(s.pop()))
                return false;
        }

        return true;
    }
}
