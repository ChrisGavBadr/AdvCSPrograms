package classwork.cw2.tickets1;

public class Ticket {

    private double price;
    private static int totalTickets = 0;
    private int id;
    private String time;
    private String type;


    Ticket(double price, String time, String type) {
        this.price = price;
        this.id = totalTickets;
        this.time = time;
        this.type = type;

        totalTickets++;
    }

    public double getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}
