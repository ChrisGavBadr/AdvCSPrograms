package apexams.exam1;

public class CheckDigit {
    /**
     * Returns the check digit for num, as described in part (b).
     * Precondition: The number of digits in num is between one and
     * six, inclusive.
     * num >= 0
     */
    public static int getCheck(int num) {
        /* to be considered in part (b) */
    }

    /**
     * Returns true if numWithCheckDigit is valid, or false
     * otherwise, as described in part (b).
     * Precondition: The number of digits in numWithCheckDigit
     * is between two and seven, inclusive.
     * numWithCheckDigit >= 0
     */
    public static boolean isValid(int numWithCheckDigit) {
        for (int i = 0; i < getNumberOfDigits(numWithCheckDigit); i++) {
            if (getDigits(numWithCheckDigit, i) != getCheck(numWithCheckDigit)) {
                return false;
            }
        }
    }

    /**
     * Returns the number of digits in num.
     */
    public static int getNumberOfDigits(int num) {
        /* implementation not shown */
    }

    /**
     * Returns the nthdigit of num.
     * Precondition: n >= 1 and n <= the number of digits in num
     */
    public static int getDigits(int num, int n) {
        /* implementation not shown */
    }

    /** There may be instance variables, constructors, and
     *  methods not shown.
     */
}