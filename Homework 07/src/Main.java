// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String name = "Restaurant";
        Flavor f1 = new Flavor("Vanilla", 2.00);
        Flavor f2 = new Flavor("Choc", 3.00);
        Flavor f3 = new Flavor("Straw", 4.00);
        Flavor[] flavors = {f1, f2, f3};
        int[][] cupsSold = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int hours = 4;
        boolean summer = true;
        Restaurant r = new Restaurant(name, flavors, cupsSold, hours, summer);

    }


}