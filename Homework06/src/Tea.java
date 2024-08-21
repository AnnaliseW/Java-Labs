/**
 * Tea Class that models a type of tea sold at a tea shop
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 06 -- Tea Shop
 *
 * @author Annalise Wang Purdue CS
 * @version September 27, 2023
 */
public class Tea {

    private String name;
    private double price;
    private int stockAvailable;
    private String type;
    private int caffeineLevel;
    private int steepTemperature;
    private double steepTime;

    public Tea(String name, double price, String type, int stockAvailable) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.stockAvailable = stockAvailable;

        if (type.equals("Black")) {
            caffeineLevel = 5;
            steepTemperature = 212;
            steepTime = 4.5;
        } else if (type.equals("Oolong")) {
            caffeineLevel = 4;
            steepTemperature = 200;
            steepTime = 2.0;
        } else if (type.equals("Green")) {
            caffeineLevel = 3;
            steepTemperature = 185;
            steepTime = 2.5;
        } else if (type.equals("White")) {
            caffeineLevel = 2;
            steepTemperature = 160;
            steepTime = 1.5;
        } else if (type.equals("Herbal")) {
            caffeineLevel = 1;
            steepTemperature = 212;
            steepTime = 5.0;
        } else {
            System.out.println("This is not a type of tea sold here");
        }

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public int getCaffeineLevel() {
        return caffeineLevel;
    }

    public double getSteepTime() {
        return steepTime;
    }

    public int getSteepTemperature() {
        return steepTemperature;
    }


    public void restock(int quantity) {
        if (quantity < 0) {
            System.out.println("Error, invalid order");
            return;
        }
        this.stockAvailable = quantity + stockAvailable;
    }


    public double purchaseTea(int quantity) {
        int stockSold = 0;
        if (quantity < 0) {
            System.out.println("Error, invalid order");
        } else if (stockAvailable < quantity) {
            stockSold += stockAvailable;
            this.stockAvailable = 0;
        } else if (stockAvailable > quantity) {
            stockSold += quantity;
            this.stockAvailable = stockAvailable - quantity;
        }
        return price * stockSold;

    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return "Tea Name : " + name + '\n' +
                "Type: " + type + '\n' +
                "Stock Available: " + stockAvailable + '\n' +
                "Price: $" + price + '\n' +
                "Steep Time: " + steepTime + '\n' +
                "Steep Temperature: " + steepTemperature + '\n' +
                "Caffeine Level: " + caffeineLevel;
    }
}
