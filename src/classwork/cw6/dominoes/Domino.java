package classwork.cw6.dominoes;

public class Domino {

    private int first;
    private int second;

    Domino(int first, int second) {
        this.first = first;
        this.second = second;
    }

    Domino() {
        this.first = (int) (7*Math.random());
        this.second = (int) (7*Math.random());
    }

    public int first() {
        return this.first;
    }

    public int second() {
        return this.second;
    }

    public String toString() {
        return String.format("(%d|%d)", first, second);
    }
}
