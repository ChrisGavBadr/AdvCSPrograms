package classwork.cw2.tickets1;

public class Student extends Ticket {

    Student(double price, String time, String type) {
        super(0.75*price, time, type);
    }
}
