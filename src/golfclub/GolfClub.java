package golfclub;

import javax.swing.*;
import java.util.*;

public class GolfClub {

    private static double EPSILON = 0.00000001;     // Used for floating-point errors

    // Initializes Golf Club database and initiates program
    public static void main(String[] args) {
        List<Member> golfClubDatabase = new ArrayList<>();
        golfClubDatabase.add(new Member("Baduria", "Christina", 6.553));
        golfClubDatabase.add(new Member("Baduria", "Jose", 10.486));
        golfClubDatabase.add(new Member("Baduria", "Christian", 16.777));
        golfClubDatabase.add(new Member("Baduria", "Jacquelyn", 4.096));
        golfClubDatabase.add(new Member("Baduria", "Caitlyn", 2.560));

        run(golfClubDatabase);
    }

    // Runs entire database program
    public static void run(List<Member> database) {
        Scanner s = new Scanner(System.in);
        int action;
        mergeSort(database);

        System.out.println("**** Running Golf Club Database ****");
        System.out.println("Hello! Welcome to the Golf Club database! This database includes information on members' " +
                            "\nfirst/last names and their golf averages.");

        do {
            action = promptNextAction();
            if (action == 0) {
                performSearchMemberAction(database);
            } else if (action == 1) {
                performAddMemberAction(database);
            }
        } while (action != 2);
    }

    // Prompts user for next action (search member, add member, or exit database)
    private static int promptNextAction() {
        Scanner s = new Scanner(System.in);
        int action;

        System.out.println("----\nWhat action do you want to take?");
        System.out.println("\t[0] - Search for a current Golf Club member");
        System.out.println("\t[1] - Add a new Golf Club member to the database");
        System.out.println("\t[2] - Exit database");

        do {
            System.out.print("Action: ");
            action = s.nextInt();

            if (action != 0 && action != 1 && action != 2) {
                System.out.println("Invalid input, try again.");
            } else if (action == 2) {
                System.out.print("Type '2' again to confirm, or type another action: ");
                action = s.nextInt();
            }
        } while (action != 0 && action != 1 && action != 2);

        return action;
    }

    // Searches member prompted by user and displays the member's information
    private static void performSearchMemberAction(List<Member> database) {
        Scanner s = new Scanner(System.in);
        System.out.print("----\nEnter First Name: ");
        String firstName = s.next().toUpperCase();
        System.out.print("Enter Last Name: ");
        String lastName = s.next().toUpperCase();

        int idx = binarySearch(database, lastName, firstName);

        if (idx != -1) {
            displayInformation(database, lastName, firstName);
        } else {
            System.out.printf("\nSorry, %s %s does not exist in the database. Returning to main menu...\n", firstName, lastName);
        }
    }

    // Adds member prompted by user to database
    private static void performAddMemberAction(List<Member> database) {
        Scanner s = new Scanner(System.in);
        double golfAverage;

        System.out.print("----\nEnter First Name: ");
        String firstName = s.next().toUpperCase();
        System.out.print("Enter Last Name: ");
        String lastName = s.next().toUpperCase();
        System.out.printf("%s %s's Golf Average: ", firstName, lastName);
        golfAverage = s.nextDouble();

        while (golfAverage < 1) {
            System.out.println("Impossible golf average, try again.");
            System.out.printf("%s %s's Golf Average: ", firstName, lastName);
            golfAverage = s.nextDouble();
        }

        database.add(new Member(lastName, firstName, golfAverage));
        mergeSort(database);
        System.out.printf("%s %s was successfully added to the database. Returning to main menu...\n", firstName, lastName);
    }

    // Displays member's #, full name, and golf average
    private static void displayInformation(List<Member> database, String lastName, String firstName) {
        int idx = binarySearch(database, lastName, firstName);
        System.out.printf("\nGolf Club Member %d: %s, %s\n", idx, database.get(idx).getLastName(), database.get(idx).getFirstName());
        System.out.printf("\tGolf Average: %.3f\n", database.get(idx).getGolfAverage());
    }

    // Searches for member in database using recursive binary search algorithm
    private static int binarySearch(List<Member> database, String lastName, String firstName) {
        return binarySearch(database, lastName, firstName, 0, database.size() - 1);
    }

    // Performs recursive binary search algorithm
    private static int binarySearch(List<Member> database, String lastName, String firstName, int min, int max) {
        int mid =  (max + min) / 2;

        if (min > max) {
            return -1;
        } else if (lastName.compareToIgnoreCase(database.get(mid).getLastName()) < 0) {
            return binarySearch(database, lastName, firstName, min, mid - 1);
        } else if (lastName.compareToIgnoreCase(database.get(mid).getLastName()) > 0) {
            return binarySearch(database, lastName, firstName, mid + 1, max);
        } else if (firstName.compareToIgnoreCase(database.get(mid).getFirstName()) < 0) {
            return binarySearch(database, lastName, firstName, min, mid - 1);
        } else if (firstName.compareToIgnoreCase(database.get(mid).getFirstName()) > 0) {
            return binarySearch(database, lastName, firstName, mid + 1, max);
        } else {
            return mid;
        }
    }

    // Sorts database using recursive merge sorting algorithm
    private static void mergeSort(List<Member> database) {
        if (database.size() >= 2) {
            int mid = database.size() / 2;
            List<Member> left = new ArrayList<>(database.subList(0, mid));
            List<Member> right = new ArrayList<>(database.subList(mid, database.size()));

            mergeSort(left);
            mergeSort(right);
            merge(database, left, right);
        }
    }

    // Merges left partition and right partition into sorted database
    private static void merge(List<Member> database, List<Member> left, List<Member> right) {
        int j = 0;
        int k = 0;

        for (int i = 0; i < database.size(); i++) {
            if (k >= right.size() || (j < left.size() && left.get(j).getLastName().compareToIgnoreCase(right.get(k).getLastName()) < 0)) {
                database.set(i, left.get(j));
                j++;
            } else if (j >= left.size() || (k < right.size() && left.get(j).getLastName().compareToIgnoreCase(right.get(k).getLastName()) > 0)) {
                database.set(i, right.get(k));
                k++;
            } else if (k >= right.size() || (j < left.size() && left.get(j).getFirstName().compareToIgnoreCase(right.get(k).getFirstName()) < 0)) {
                database.set(i, left.get(j));
                j++;
            } else if (j >= left.size() || (k < right.size() && left.get(j).getFirstName().compareToIgnoreCase(right.get(k).getFirstName()) > 0)) {
                database.set(i, right.get(k));
                k++;
            } else if (k >= right.size() || (j < left.size() && left.get(j).getGolfAverage() - right.get(k).getGolfAverage() < EPSILON)) {
                database.set(i, left.get(j));
                j++;
            } else {
                database.set(i, right.get(k));
                k++;
            }
        }
    }
}
