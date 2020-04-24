package apexams.exam1;

import java.util.ArrayList;

public class OnlinePurchaseManager {

    /**
     * An ArrayList of purchased Gizmo objects,
     * instantiated in the constructor.
     */
    private ArrayList<Gizmo> purchases;

    /**
     * Returns the number of purchased Gizmo objects that are
     * electronic whose manufacturer is maker, as described in
     * part (a).
     */
    public int countElectronicsByMaker(String maker) {
        int count = 0;
        for (Gizmo g : purchases) {
            if (g.getMaker().equals(maker) && g.isElectronic()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns true if any pair of adjacent purchased Gizmo objects
     * are equivalent, and false otherwise, as described in
     * part (b).
     */
    public boolean hasAdjacentEqualPair() {
        /* to be considered in part (b) */
    }

    /** There may be instance variables, constructors, and
     *  methods not shown.
     */
}