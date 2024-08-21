import java.util.ArrayList;

/**
 * WaterPark Class that will simulate WaterParks
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 09 -- WaterPark
 *
 * @author Annalise Wang Purdue CS
 * @version October 18, 2023
 */
public class WaterPark extends Object implements Park {
    private String name;
    private double admissionCost;
    private double land;
    private ArrayList<Ride> rides;
    private boolean indoor;
    private boolean outdoor;
    private boolean lazyRiver;
    private boolean wavePool;
    private boolean[] seasons;

    public WaterPark(String name,
                     double admissionCost,
                     double land,
                     ArrayList<Ride> rides,
                     boolean indoor,
                     boolean outdoor,
                     boolean lazyRiver,
                     boolean wavePool,
                     boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }

    public boolean isLazyRiver() {
        return lazyRiver;
    }

    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    public boolean isWavePool() {
        return wavePool;
    }

    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
    }


    public double getAdmissionCost() {
        return admissionCost;
    }


    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public double getLand() {
        return land;
    }

    public void addRide(Ride ride) throws WrongRideException {
        if (!(ride instanceof Waterslide)) {
            throw new WrongRideException("A waterpark can only have waterslide rides!");
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
                           int newMaxRiders, double newSplashDepth) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.get(i).setName(newName);
                rides.get(i).setColor(newColor);
                rides.get(i).setMinHeight(newMinHeight);
                rides.get(i).setMaxRiders(newMaxRiders);
                if (rides.get(i) instanceof Waterslide) {
                    Waterslide thisWaterslide = (Waterslide) rides.get(i);
                    thisWaterslide.setSplashDepth(newSplashDepth);
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
        this.wavePool = false;
        this.lazyRiver = false;
    }


}
