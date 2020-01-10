package classwork.cw3.tickets2;

public class StudentAdvance implements Tickets {

    private double price;
    private int id;
    private String time = "Advance";
    private String type = "Student";

    private static int totalTickets = 0;

    public StudentAdvance(double price) {
        this.price = 0.75*price - 2;
        this.id = totalTickets;
        this.time = time;
        this.type = type;

        totalTickets++;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public int getID() {
        return id;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public String getType() {
        return type;
    }
}
