package classwork.cw6;

public class RecursivePractice {

    public static void main(String[] args) {
        int idx = 9;

        System.out.println("Fibonacci #" + idx + ": " + genFibo(idx));
        System.out.println("Golden Ratio Approximation #" + idx + ": " + (double) genFibo(idx + 1) / genFibo(idx));
        System.out.println("Multiply Evens #" + idx + ": " + multiplyEvens(idx));
    }

    public static int genFibo(int idx) throws IllegalArgumentException {
        if (idx < 1)
            throw new IllegalArgumentException("Index must be a positive integer.");
        else if (idx == 1)
            return 0;
        else if (idx == 2)
            return 1;
        else
            return genFibo(idx - 1) + genFibo(idx - 2);
    }

    public static int multiplyEvens(int idx) throws IllegalArgumentException {
        if (idx <= 0)
            throw new IllegalArgumentException("Index must be a positive integer.");
        else if (idx == 1)
            return 2;
        else
            return 2*idx*multiplyEvens(idx - 1);
    }
}
