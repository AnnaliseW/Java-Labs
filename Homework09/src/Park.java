import java.util.ArrayList;

/**
 * Park Class that will simulate Parks
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 09 -- Park
 *
 * @author Annalise Wang Purdue CS
 * @version October 18, 2023
 */

// finished
public interface Park {
    void setName(String name);

    String getName();

    void setAdmissionCost(double admissionCost);

    double getAdmissionCost();

    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;

    double getLand();

    void addRide(Ride ride) throws WrongRideException;

    void removeRide(Ride ride);

    ArrayList<Ride> getRides();

    boolean isIndoor();

    boolean isOutdoor();

    void setSeasons(boolean[] seasons);

    boolean[] getSeasons();

    void close();

}
