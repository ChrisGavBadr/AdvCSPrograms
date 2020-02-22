package golfclub;

public class Member {

    private String lastName;
    private String firstName;
    private double golfAverage;

    public Member(String lastName, String firstName, double golfAverage) {
        this.lastName = lastName.toUpperCase();
        this.firstName = firstName.toUpperCase();
        this.golfAverage = golfAverage;
    }

    @Override
    public String toString() {
        return "Member{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", golfAverage=" + golfAverage +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGolfAverage() {
        return golfAverage;
    }

    public void setGolfAverage(double golfAverage) {
        this.golfAverage = golfAverage;
    }
}
