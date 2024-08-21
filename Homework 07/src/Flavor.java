/**
 * Flavor Class that models cost and name of flavors
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 07 -- Flavor
 *
 * @author Annalise Wang Purdue CS
 * @version October 4, 2023
 */
public class Flavor {
    private String name;
    private double cost;

    public Flavor() {
        this.name = null;
        this.cost = 0;
    }

    public Flavor(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
