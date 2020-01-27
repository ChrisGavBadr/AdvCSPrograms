package classwork.cw6;

public class MultiplyEvens {

    public static void main(String[] args) {
        int idx = 9;
        System.out.println("Multiply Evens #" + idx + ": " + multiplyEvens(idx));
    }

    private static int multiplyEvens(int idx) throws IllegalArgumentException {
        if (idx <= 0)
            throw new IllegalArgumentException("Index must be a positive integer.");
        else if (idx == 1)
            return 2;
        else
            return 2*idx*multiplyEvens(idx - 1);
    }
}
