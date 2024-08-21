/**
 * Waterslide Class that will simulate Waterslides
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 09 -- Waterslide
 *
 * @author Annalise Wang Purdue CS
 * @version October 18, 2023
 */
public class Waterslide extends Ride {
    private double splashDepth;

    public Waterslide(String name, String color, int minHeight,
                      int maxRiders, double splashDepth) {
        this.setName(name);
        this.setColor(color);
        this.setMinHeight(minHeight);
        this.setMaxRiders(maxRiders);
        this.splashDepth = splashDepth;
    }

    public double getSplashDepth() {
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Waterslide) {
            Waterslide objectO = (Waterslide) o;
            return objectO.getName().equals(this.getName()) && objectO.getColor().equals(this.getColor()) &&
                    objectO.getMinHeight() == this.getMinHeight() && objectO.getMaxRiders() == this.getMaxRiders()
                    && objectO.getSplashDepth() == this.getSplashDepth();
        } else {
            return false;
        }
    }

    @Override

    public String toString() {
        return "Name: " + this.getName() + "\nColor: " + this.getColor() + "\nMinHeight: "
                + this.getMinHeight() + " inches\nMaxRiders: " + this.getMaxRiders() + "\nSplashDepth: "
                + this.splashDepth + " feet";
    }
}
