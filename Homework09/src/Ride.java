/**
 * Ride Class that will simulate Rides
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 09 -- Ride
 *
 * @author Annalise Wang Purdue CS
 * @version October 18, 2023
 */
public class Ride extends Object {
    private String color;
    private int maxRiders;
    private int minHeight;
    private String name;

    public Ride() {
        this.name = "";
        this.color = "";
        this.minHeight = 0;
        this.maxRiders = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public boolean equals(Object o) {
        if (o instanceof Ride) {
            Ride objectO = (Ride) o;
            return objectO.getName().equals(this.getName()) && objectO.getColor().equals(this.getColor())
                    && objectO.getMinHeight() == this.getMinHeight() && objectO.getMaxRiders() == this.getMaxRiders();
        } else {
            return false;
        }
    }

    public String toString() {
        return "Name: " + this.name + "\nColor: " + this.color + "\nMinHeight: "
                + this.minHeight + " inches\nMaxRiders: " + this.maxRiders;
    }
}