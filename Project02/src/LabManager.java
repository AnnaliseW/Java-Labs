/**
 * Three labs to manage
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Project 02 -- Lab Manager
 *
 * @author Annalise Wang Purdue CS
 * @version October 12, 2023
 */
public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;


    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }


    public Lab getLabOne() {
        return labOne;
    }

    public Lab getLabTwo() {
        return labTwo;
    }

    public Lab getLabThree() {
        return labThree;
    }

    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }

    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }

    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }

    public int calculateTotalCapacity() {
        int calculatedCapacity = 0;
        calculatedCapacity += labOne.getCapacity();
        calculatedCapacity += labTwo.getCapacity();
        calculatedCapacity += labThree.getCapacity();
        calculatedCapacity = calculatedCapacity * 2;
        return calculatedCapacity;
    }

    public double calculateTotalUtilization() {
        double allLabsEnrolllment = 0;

        allLabsEnrolllment = labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment() +
                labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment() +
                labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment();

        double allLabsCapacity = (labOne.getCapacity() + labTwo.getCapacity() + labThree.getCapacity()) * 2;

        double totalUtility = allLabsEnrolllment / allLabsCapacity;
        return totalUtility;
    }

    public int calculateAvailableSeats() {
        int availableSeatslabOne = 0;
        int availableSeatslabTwo = 0;
        int availableSeatslabThree = 0;
        availableSeatslabOne += (labOne.getCapacity() - labOne.getMorning().getEnrollment());
        availableSeatslabOne += (labOne.getCapacity() - labOne.getAfternoon().getEnrollment());

        availableSeatslabTwo += (labTwo.getCapacity() - labTwo.getMorning().getEnrollment());
        availableSeatslabTwo += (labTwo.getCapacity() - labTwo.getAfternoon().getEnrollment());

        availableSeatslabThree += (labThree.getCapacity() - labThree.getMorning().getEnrollment());
        availableSeatslabThree += (labThree.getCapacity() - labThree.getAfternoon().getEnrollment());

        int totalAvailable = availableSeatslabOne + availableSeatslabTwo + availableSeatslabThree;
        return totalAvailable;
    }

    public String listReservedLabs() {
        String oneReserved = labOne.listReservations();
        String twoReserved = labTwo.listReservations();
        String threeReserved = labThree.listReservations();

        return "Lab One\n" + oneReserved + "Lab Two\n" + twoReserved + "Lab Three\n" + threeReserved;
    }

    public String listAvailableLabs() {
        String oneAvailable = labOne.listAvailabilities();
        String twoAvailable = labTwo.listAvailabilities();
        String threeAvailable = labThree.listAvailabilities();

        return "Lab One\n" + oneAvailable + "Lab Two\n" + twoAvailable + "Lab Three\n" + threeAvailable;
    }

    public String addReservation(String location, String time, String name, int enrollment) {

        if (getLabOne().getLocation().equalsIgnoreCase(location)) {
            if (getLabOne().getCapacity() >= enrollment) {
                if (getLabOne().getMorning().getEnrollment() == 0 &&
                        time.equalsIgnoreCase("morning")) {
                    Session s = new Session(name, enrollment);
                    labOne.setMorning(s);
                    return "Reservation added!";
                } else if (getLabOne().getAfternoon().getEnrollment() == 0 &&
                        time.equalsIgnoreCase("afternoon")) {
                    Session s = new Session(name, enrollment);
                    labOne.setAfternoon(s);
                    return "Reservation added!";
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Capacity exceeded";
            }
        } else if (getLabTwo().getLocation().equalsIgnoreCase(location)) {
            if (getLabTwo().getCapacity() >= enrollment) {
                if (getLabTwo().getMorning().getEnrollment() == 0 &&
                        time.equalsIgnoreCase("morning")) {
                    Session s = new Session(name, enrollment);
                    labTwo.setMorning(s);
                    return "Reservation added!";

                } else if (getLabTwo().getAfternoon().getEnrollment() == 0 &&
                        time.equalsIgnoreCase("afternoon")) {
                    Session s = new Session(name, enrollment);
                    labTwo.setAfternoon(s);
                    return "Reservation added!";
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Capacity exceeded";
            }
        } else if (getLabThree().getLocation().equalsIgnoreCase(location)) {
            if (getLabThree().getCapacity() >= enrollment) {
                if (getLabThree().getMorning().getEnrollment() == 0 &&
                        time.equalsIgnoreCase("morning")) {
                    Session s = new Session(name, enrollment);
                    labThree.setMorning(s);
                    return "Reservation added!";
                } else if (getLabThree().getAfternoon().getEnrollment() == 0 &&
                        time.equalsIgnoreCase("afternoon")) {
                    Session s = new Session(name, enrollment);
                    labThree.setAfternoon(s);
                    return "Reservation added!";
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Capacity exceeded";
            }
        } else {
            return "Error. Invalid location";
        }

    }

    public String removeReservation(String location, String time) {

        if (getLabOne().getLocation().equalsIgnoreCase(location)) {
            if (getLabOne().getMorning().getEnrollment() != 0 && time.equalsIgnoreCase("morning")) {
                Session s = new Session("", 0);
                labOne.setMorning(s);
                return "Reservation removed!";
            } else if (getLabOne().getAfternoon().getEnrollment() != 0 && time.equalsIgnoreCase("afternoon")) {
                Session s = new Session("", 0);
                labOne.setAfternoon(s);
                return "Reservation removed!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (getLabTwo().getLocation().equalsIgnoreCase(location)) {
            if (getLabTwo().getMorning().getEnrollment() != 0 && time.equalsIgnoreCase("morning")) {
                Session s = new Session("", 0);
                labTwo.setMorning(s);
                return "Reservation removed!";

            } else if (getLabTwo().getAfternoon().getEnrollment() != 0 && time.equalsIgnoreCase("afternoon")) {
                Session s = new Session("", 0);
                labTwo.setAfternoon(s);
                return "Reservation removed!";

            } else {
                return "Error. Invalid time.";
            }
        } else if (getLabThree().getLocation().equalsIgnoreCase(location)) {
            if (getLabThree().getMorning().getEnrollment() != 0 && time.equalsIgnoreCase("morning")) {
                Session s = new Session("", 0);
                labThree.setMorning(s);
                return "Reservation removed!";

            } else if (getLabThree().getAfternoon().getEnrollment() != 0 && time.equalsIgnoreCase("afternoon")) {
                Session s = new Session("", 0);
                labThree.setAfternoon(s);
                return "Reservation removed!";

            } else {
                return "Error. Invalid time.";
            }
        } else {
            return "Error. Invalid location";
        }
    }


    public String modifyReservation(String location, String time, String name, int enrollment) {

        if (getLabOne().getLocation().equalsIgnoreCase(location)) {
            if (getLabOne().getCapacity() >= enrollment) {
                if (getLabOne().getMorning().getEnrollment() != 0 &&
                        time.equalsIgnoreCase("morning")) {
                    Session s = new Session(name, enrollment);
                    labOne.setMorning(s);
                    return "Reservation modified!";
                } else if (getLabOne().getAfternoon().getEnrollment() != 0 &&
                        time.equalsIgnoreCase("afternoon")) {
                    Session s = new Session(name, enrollment);
                    labOne.setAfternoon(s);
                    return "Reservation modified!";
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Capacity exceeded";
            }
        } else if (getLabTwo().getLocation().equalsIgnoreCase(location)) {
            if (getLabTwo().getCapacity() >= enrollment) {
                if (getLabTwo().getMorning().getEnrollment() != 0 &&
                        time.equalsIgnoreCase("morning")) {
                    Session s = new Session(name, enrollment);
                    labTwo.setMorning(s);
                    return "Reservation modified!";
                } else if (getLabTwo().getAfternoon().getEnrollment() != 0 &&
                        time.equalsIgnoreCase("afternoon")) {
                    Session s = new Session(name, enrollment);
                    labTwo.setAfternoon(s);
                    return "Reservation modified!";
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Capacity exceeded";
            }
        } else if (getLabThree().getLocation().equalsIgnoreCase(location)) {
            if (getLabThree().getCapacity() >= enrollment) {
                if (getLabThree().getMorning().getEnrollment() != 0 &&
                        time.equalsIgnoreCase("morning")) {
                    Session s = new Session(name, enrollment);
                    labThree.setMorning(s);
                    return "Reservation modified!";
                } else if (getLabThree().getAfternoon().getEnrollment() != 0 &&
                        time.equalsIgnoreCase("afternoon")) {
                    Session s = new Session(name, enrollment);
                    labThree.setAfternoon(s);
                    return "Reservation modified!";
                } else {
                    return "Error. Invalid time.";
                }
            } else {
                return "Error. Capacity exceeded";
            }
        } else {
            return "Error. Invalid location";
        }

    }

    public String toString() {
        return "LabManager{" + labOne.toString() + "," + labTwo.toString() + "," +
                labThree.toString() + "}";
    }


}



