import java.util.ArrayList;
import java.util.Arrays;

/**
 * IceCream Class that models Ice Cream
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 07 -- Ice Cream
 *
 * @author Annalise Wang Purdue CS
 * @version October 4, 2023
 */
public class IceCream {
    private Restaurant[] restaurants;
    private boolean summer;
    private int newBusinesses;
    private int newBusinessThreshold;

    public IceCream(Restaurant[] restaurants, boolean summer, int newBusinesses, int newBusinessThreshold) {
        this.restaurants = restaurants;
        this.summer = summer;
        this.newBusinesses = newBusinesses;
        this.newBusinessThreshold = newBusinessThreshold;
    }

    public int closeBusinesses() {
        int numberClosed = 0;

        while (this.newBusinesses > this.newBusinessThreshold) {
            double minSales = Integer.MAX_VALUE;
            ArrayList<Restaurant> newRestaurants = new ArrayList<Restaurant>();
            newRestaurants.addAll(Arrays.asList(restaurants));


            for (int i = 0; i < newRestaurants.size(); i++) {
                if (newRestaurants.get(i).totalSales() < minSales) {
                    minSales = newRestaurants.get(i).totalSales();

                }
            }
            for (int i = 0; i < newRestaurants.size(); i++) {
                if (newRestaurants.get(i).totalSales() == minSales) {
                    newRestaurants.remove(i);
                    newRestaurants.get(i).closeRestaurant();
                }
            }
            this.newBusinesses = newBusinesses - 1;
            numberClosed += 1;
        }
        this.newBusinesses = 0;
        return numberClosed;
    }

    public void applySummerDiscounts() {
        if (summer == true) {
            for (int i = 0; i < restaurants.length; i++) {
                if (restaurants[i].hasSummerDiscount()) {
                    if (restaurants[i].hasSummerDiscount()) {
                        if (restaurants[i].totalSales() <= 150) {
                            restaurants[i].calculateDiscounts(.25);
                        } else if (restaurants[i].totalSales() > 150 && restaurants[i].totalSales() <= 300) {
                            restaurants[i].calculateDiscounts(.15);
                        } else {
                            restaurants[i].calculateDiscounts(.10);
                        }
                    }
                }
            }


        }
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isSummer() {
        return summer;
    }

    public void setSummer(boolean summer) {
        this.summer = summer;
    }

    public int getNewBusinesses() {
        return newBusinesses;
    }

    public void setNewBusinesses(int newBusinesses) {
        this.newBusinesses = newBusinesses;
    }

    public int getNewBusinessThreshold() {
        return newBusinessThreshold;
    }

    public void setNewBusinessThreshold(int newBusinessThreshold) {
        this.newBusinessThreshold = newBusinessThreshold;
    }
}



