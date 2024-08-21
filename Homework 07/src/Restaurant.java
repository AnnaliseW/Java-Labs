/**
 * Restaurant Class that models an ice cream restaurant
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 07 -- Restaurant
 *
 * @author Annalise Wang Purdue CS
 * @version October 04, 2023
 */
public class Restaurant {
    private String name;
    private Flavor[] flavors;
    private int[][] cupsSold;
    private int hours;
    private boolean summerDiscount;

    public Restaurant() {
        this.flavors = new Flavor[3];
        this.cupsSold = new int[3][7];
        this.name = null;
        this.hours = 0;
        this.summerDiscount = false;
    }

    public Restaurant(String name, Flavor[] flavors, int[][] cupsSold, int hours, boolean summerDiscount) {
        this.name = name;
        this.flavors = flavors;
        this.cupsSold = cupsSold;
        this.hours = hours;
        this.summerDiscount = summerDiscount;
    }

    public double totalSales() {
        double sumCost = 0;
        for (int k = 0; k < cupsSold.length; k++) {
            for (int i = 0; i < cupsSold[0].length; i++) {
                sumCost += cupsSold[k][i] * flavors[k].getCost();

            }
        }
        return sumCost;
    }

    public void calculateDiscounts(double discount) {
        if (summerDiscount == true) {
            for (int i = 0; i < flavors.length; i++) {
                flavors[i].setCost((1 - discount) * flavors[i].getCost());
            }
        }
    }

    public double closeRestaurant() {
        double sales = 0;
        sales = totalSales();
        this.hours = 0;
        this.name = null;
        this.flavors = null;
        this.cupsSold = null;
        summerDiscount = false;
        return sales;
    }

    public void addFlavor(Flavor newFlavor) {
        boolean containsNull = false;
        for (int i = 0; i < flavors.length; i++) {
            if (flavors[i] == null) {
                containsNull = true;
                flavors[i] = newFlavor;
                break;
            }
        }
        if (containsNull == false) {
            System.out.println("Error, no available space!");
        }


    }

    public Flavor[] getFlavors() {
        return flavors;
    }

    public void setFlavors(Flavor[] flavors) {
        this.flavors = flavors;
    }

    public int[][] getCupsSold() {
        return cupsSold;
    }

    public void setCupsSold(int[][] cupsSold) {
        this.cupsSold = cupsSold;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean hasSummerDiscount() {
        return summerDiscount;
    }

    public void setSummerDiscount(boolean summerDiscount) {
        this.summerDiscount = summerDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}



