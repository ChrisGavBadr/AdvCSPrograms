package apexams.exam2;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    /**
     * The open and close delimiters.
     */
    private String openDel;
    private String closeDel;

    /**
     * Constructs a Delimiters object where open is the open
     * delimiter and close is the close delimiter.
     * Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    /**
     * Returns an ArrayList of delimiters from the array
     * tokens, as described in part (a).
     */
    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> delimiters = new ArrayList<>();
        for (String d : tokens) {
            if (d.equals(openDel) || d.equals(closeDel)) {
                delimiters.add(d);
            }
        }
        return delimiters;
    }

    /**
     * Returns true is the delimiters are balanced and false
     * otherwise, as described in part (b).
     * Precondition: delimiters contains only valid open and close
     * delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        if (delimiters.size() % 2 != 0) {
            return false;
        }
        int balance = 0;
        for (int i = 0; i <= delimiters.size(); i++) {
            if (delimiters.get(i).equals(openDel)) {
                balance++;
            } else if (delimiters.get(i).equals(closeDel)) {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

/** There may be instance variables, constructors, and methods
 *  that are not shown.
 */
}

