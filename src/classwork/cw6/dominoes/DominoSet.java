package classwork.cw6.dominoes;

import java.util.*;

public class DominoSet {

    public static void main(String[] args) {
        List<Domino> dominoSet = new ArrayList<Domino>();
        List<Domino> dominoChain = new ArrayList<Domino>();
        dominoSet.add(new Domino(1, 2));
        dominoSet.add(new Domino(2, 6));
        dominoSet.add(new Domino(5, 4));
        dominoSet.add(new Domino(2, 5));
        dominoSet.add(new Domino(4, 3));
        dominoSet.add(new Domino(3, 1));

        boolean hasChain = hasChain(dominoSet, dominoChain, 1, 1);
        System.out.println(hasChain + ": " + dominoChain.toString());
    }

    public static boolean hasChain(List<Domino> dominoSet, List<Domino> dominoChain, int start, int end) {
        for (int i = 0; i < dominoSet.size(); i++) {
            if (start == dominoSet.get(i).first()) {
                dominoChain.add(dominoSet.get(i));
                dominoSet.remove(i);
                if (end != dominoChain.get(dominoChain.size() - 1).second()) {
                    if (hasChain(dominoSet, dominoChain, dominoChain.get(dominoChain.size() - 1).second(), end)) {
                        return true;
                    } else {
                        dominoSet.add(i, dominoChain.get(dominoChain.size() - 1));
                        dominoChain.remove(dominoChain.get(dominoChain.size() - 1));
                    }
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}