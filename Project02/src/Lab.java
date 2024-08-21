/**
 * A class representing labs program
 * <p>
 * Purdue University -- CS18000 -- Fall 2023-- Project 02 -- Lab
 *
 * @author Annalise Wang Purdue CS
 * @version October 12, 2023
 */
public class Lab {
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning, Session afternoon, int capacity, String location) {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }

    public Lab(int capacity, String location) {
        this.capacity = capacity;
        this.location = location;
        this.morning = new Session();
        this.afternoon = new Session();
    }

    public Session getMorning() {
        return morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setMorning(Session morning) {
        this.morning = morning;
    }

    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String listAvailabilities() {
        if (getMorning().getEnrollment() == 0 && getAfternoon().getEnrollment() == 0) {
            return "Morning: Available\n" + "Afternoon: Available\n";
        } else if (getMorning().getEnrollment() == 0) {
            return "Morning: Available\n";
        } else if (getAfternoon().getEnrollment() == 0) {
            return "Afternoon: Available\n";
        } else {
            return "No Availabilities";
        }
    }

    public String listReservations() {
        if (getMorning().getEnrollment() > 0 && getAfternoon().getEnrollment() > 0) {
            return "Morning: Reserved\n" + "Afternoon: Reserved\n";
        } else if (getMorning().getEnrollment() > 0) {
            return "Morning: Reserved\n";
        } else if (getAfternoon().getEnrollment() > 0) {
            return "Afternoon: Reserved\n";
        } else {
            return "No Reservations";
        }
    }

    public String toString() {
        String morningReservation = "";
        String afternoonReservation = "";
        if (getMorning().getEnrollment() > 0) {
            morningReservation += this.morning.toString();
        } else {
            morningReservation += "Available}";
        }
        if (getAfternoon().getEnrollment() > 0) {
            afternoonReservation += this.afternoon.toString();
        } else {
            afternoonReservation += "Available}";
        }
        return "Lab{Capacity - " + this.capacity + ", Location - " + this.location
                + ", Morning: " + morningReservation + ", Afternoon: " + afternoonReservation;
    }


}
