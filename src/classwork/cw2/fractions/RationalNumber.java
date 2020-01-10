package classwork.cw2.fractions;

public class RationalNumber {

    private int numerator;
    private int denominator;

    RationalNumber(int numerator, int denominator) {
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        int gcf = 1;
        for (int i = 2; i <= Math.min(Math.abs(numerator), Math.abs(denominator)); i++) {
            if (numerator % i == 0 && denominator % i == 0)
                gcf = i;
        }

        this.numerator = numerator / gcf;
        this.denominator = denominator / gcf;
    }

    public void print() {
        System.out.println(numerator + " / " + denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
