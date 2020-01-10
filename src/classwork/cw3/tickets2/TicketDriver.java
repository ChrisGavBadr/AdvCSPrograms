package classwork.cw3.tickets2;

public class TicketDriver {

    public static void main(String[] args) {
        int visitors = 16;
        double price = 12;
        StudentAdvance[] tickets = new StudentAdvance[visitors];

        for (int i = 0; i < tickets.length; i++)
            tickets[i] = new StudentAdvance(price);

        for (StudentAdvance ticket : tickets) {
            System.out.printf("Ticket %d\n", ticket.getID());
            System.out.printf("\tTicket Type: %s\n", ticket.getType());
            System.out.printf("\tTime Bought: %s\n", ticket.getTime());
            System.out.printf("\tOriginal Price: $%.2f\n", price);
            System.out.printf("\tNew Price: $%.2f\n", ticket.getPrice());
        }
    }
}
