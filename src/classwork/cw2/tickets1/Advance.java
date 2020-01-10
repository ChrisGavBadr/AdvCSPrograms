package classwork.cw2.tickets1;

public class Advance extends Student {

    Advance(double price, String time, String type) {
        super(price - 2, time, type);
    }
}
