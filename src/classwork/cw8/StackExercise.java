package classwork.cw8;

import java.util.Arrays;
import java.util.Stack;

public class StackExercise {

    public static void main(String[] args) {
        Stack<Comparable> a = new Stack<>();
        a.addAll(Arrays.asList(5, 1, 9, 2, 5, 1, 7));
        Stack<Comparable> results = new Stack<>();
        int stackSize = a.size();

        System.out.println("A: " + a.toString());

        for (int i = 0; i < stackSize; i++) {
            int idx1 = getFirstLargerElementIdx(a, i);
            int idx2 = getFirstSmallerElementIdx(a, idx1);
            Comparable val = getFromStack(a, idx2);
            results.push(val);

            System.out.println(i + ": " + idx1 + " " + idx2 + " " + val);
        }

        System.out.println("A[F(G(i)]: " + results.toString());
    }

    // F(i)
    public static int getFirstLargerElementIdx(Stack<Comparable> a, int idx) {
        if (idx < 0) {
            return -1;
        }

        Stack<Comparable> reversedStack = getReversedStack(a);
        Stack<Comparable> backup = new Stack<>();
        int idxFx = -1;

        for (int i = 0; i < idx; i++) {
            backup.push(reversedStack.pop());
            idxFx++;
        }

        Comparable comparingElement = reversedStack.pop();
        backup.push(comparingElement);
        idxFx++;

        while (!reversedStack.empty()) {
            Comparable val = reversedStack.pop();
            backup.push(val);
            idxFx++;
            if (val.compareTo(comparingElement) > 0) {
                return idxFx;
            }
        }

        return -1;
    }

    // G(i)
    public static int getFirstSmallerElementIdx(Stack<Comparable> a, int idx) {
        if (idx < 0) {
            return -1;
        }

        Stack<Comparable> reversedStack = getReversedStack(a);
        Stack<Comparable> backup = new Stack<>();
        int idxFx = -1;

        for (int i = 0; i < idx; i++) {
            backup.push(reversedStack.pop());
            idxFx++;
        }

        Comparable comparingElement = reversedStack.pop();
        backup.push(comparingElement);
        idxFx++;

        while (!reversedStack.empty()) {
            Comparable val = reversedStack.pop();
            backup.push(val);
            idxFx++;
            if (val.compareTo(comparingElement) < 0) {
                return idxFx;
            }
        }

        return -1;
    }

    public static Comparable getFromStack(Stack<Comparable> a, int idx) {
        if (idx < 0) {
            return -1;
        }

        Stack<Comparable> backup = new Stack<>();
        try {
            Comparable element;
            int originalSize = a.size();

            for (int i = 0; i < originalSize - idx; i++) {
                backup.push(a.pop());
            }

            element = backup.peek();
            reconstructStack(a, backup);

            return element;
        } catch (Exception e) {
            System.out.println("Exception Occurred: " + e.getMessage());
            reconstructStack(a, backup);
            return -1;
        }
    }

    public static Stack<Comparable> getReversedStack(Stack<Comparable> a) {
        Stack<Comparable> reversedStack = new Stack<>();
        Stack<Comparable> backup = new Stack<>();

        while (!a.empty()) {
            reversedStack.push(a.peek());
            backup.push(a.pop());
        }

        reconstructStack(a, backup);
        return reversedStack;
    }

    public static void reconstructStack(Stack<Comparable> a, Stack<Comparable> backup) {
        while (!backup.empty()) {
            a.push(backup.pop());
        }
    }
}
