/**
 * Rollercoaster Class that will simulate Rollercoasters
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 09 -- Rollercoaster
 *
 * @author Annalise Wang Purdue CS
 * @version October 18, 2023
 */
public class Rollercoaster extends Ride {
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight,
                         int maxRiders, boolean simulated) {
        this.setName(name);
        this.setColor(color);
        this.setMinHeight(minHeight);
        this.setMaxRiders(maxRiders);
        this.simulated = simulated;
    }

    public boolean isSimulated() {
        return this.simulated;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    @Override

    public boolean equals(Object o) {
        if (o instanceof Rollercoaster) {
            Rollercoaster objectO = (Rollercoaster) o;
            return objectO.getName().equals(this.getName()) && objectO.getColor().equals(this.getColor())
                    && objectO.getMinHeight() == this.getMinHeight() && objectO.getMaxRiders() == this.getMaxRiders()
                    && objectO.isSimulated() == this.isSimulated();
        } else {
            return false;
        }

    }

    @Override

    public String toString() {
        return "Name: " + this.getName() + "\nColor: " + this.getColor() + "\nMinHeight: "
                + this.getMinHeight() + " inches\nMaxRiders: " + this.getMaxRiders() + "\nSimulated: "
                + this.isSimulated();
    }


}
