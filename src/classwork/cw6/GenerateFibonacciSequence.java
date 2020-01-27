package classwork.cw6;

public class GenerateFibonacciSequence {

    public static void main(String[] args) {
        int idx = 16;

        System.out.println("Fibonacci #" + idx + ": " + genFibs(idx));
        System.out.println("Golden Ratio Approximation #" + idx + ": " + (double) genFibs(idx + 1) / genFibs(idx));
    }

    private static int genFibs(int idx) throws IllegalArgumentException {
        if (idx < 1)
            throw new IllegalArgumentException("Index must be a positive integer.");
        else if (idx == 1)
            return 0;
        else if (idx == 2)
            return 1;
        else
            return genFibs(idx - 1) + genFibs(idx - 2);
    }
}
