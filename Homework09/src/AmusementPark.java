import java.util.ArrayList;

/**
 * AmusementPark Class that will simulate Amusement Parks
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 09 -- AmusementPark
 *
 * @author Annalise Wang Purdue CS
 * @version October 18, 2023
 */

public class AmusementPark extends Object implements Park {
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;

    public AmusementPark(String name, double admissionCost, double land,
                         ArrayList<Ride> rides, boolean indoor, boolean outdoor,
                         boolean arcade, boolean bowling, boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    public boolean isArcade() {
        return this.arcade;
    }

    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    public boolean isBowling() {
        return this.bowling;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    public double getAdmissionCost() {
        return this.admissionCost;
    }

    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getLand() {
        return this.land;
    }

    public void addRide(Ride ride) throws WrongRideException {
        if (!(ride instanceof Rollercoaster)) {
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
        } else {
            rides.add(ride);
        }
    }

    public void removeRide(Ride ride) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.remove(i);
            }
        }
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public boolean isIndoor() {
        return indoor;
    }


    public boolean isOutdoor() {
        return outdoor;
    }


    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }


    public boolean[] getSeasons() {
        return seasons;
    }

    public void enlarge(double addedLand, double maxLand, boolean addedIndoor,
                        boolean addedOutdoor) throws SpaceFullException {
        if (this.land + addedLand > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park!");
        } else {
            this.land = this.land + addedLand;
            if (indoor == false && addedIndoor == true) {
                this.indoor = true;
            }
            if (outdoor == false && addedOutdoor == true) {
                this.outdoor = true;
            }
        }
    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight,
                           int newMaxRiders, boolean newSimulated) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.get(i).setName(newName);
                rides.get(i).setColor(newColor);
                rides.get(i).setMinHeight(newMinHeight);
                rides.get(i).setMaxRiders(newMaxRiders);
                if (rides.get(i) instanceof Rollercoaster) {
                    Rollercoaster hasRollercoaster = (Rollercoaster) rides.get(i);
                    hasRollercoaster.setSimulated(newSimulated);
                }
            }
        }
    }

    public void close() {
        this.setName("");
        this.setAdmissionCost(0);
        this.land = 0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.arcade = false;
        this.bowling = false;
    }


}

