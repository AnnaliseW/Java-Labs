import java.util.Scanner;

/**
 * HW-03 --VinGenerator
 * <p>
 * This program takes in input from user and returns a VIN
 *
 * @author Annalise Wang, L31
 * @version September 6, 2023
 */

public class VinGenerator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Origin Country Code:");
        int code = scan.nextInt();
        String code1 = Integer.toBinaryString(code);
        scan.nextLine();

        int numberzeros = 4 - code1.length();

        if (numberzeros == 1) {
            code1 = "0" + code1;
        } else if (numberzeros == 2) {
            code1 = "00" + code1;
        } else if (numberzeros == 3) {
            code1 = "000" + code1;
        }


        System.out.println("Enter the Vehicle Make:");
        String make = scan.nextLine();
        make = make.toUpperCase();
        make = make.substring(0, 2);


        System.out.println("Enter the Color of the Vehicle:");
        String color = scan.nextLine();
        color = color.toLowerCase();
        char first = color.charAt(0);
        int ascii1 = (int) first;

        char second = color.charAt(1);
        int ascii2 = (int) second;

        char third = color.charAt(2);
        int ascii3 = (int) third;

        int sum = ascii1 + ascii2 + ascii3;
        String newsum = Integer.toString(sum);
        newsum = newsum.substring(newsum.length() - 2);


        System.out.println("Enter the Model of the Vehicle:");
        String model = scan.nextLine();
        model = model.toUpperCase();
        char modelfirst = model.charAt(0);
        char modellast = model.charAt(model.length() - 1);


        System.out.println("Enter the Year of the Vehicle:");
        String year = scan.nextLine();
        year = year.substring(year.length() - 2);


        System.out.println("Enter the Delivery Destination:");
        String destination = scan.nextLine();
        destination = destination.toUpperCase();
        destination = destination.substring(0, 2);


        System.out.println("Enter the Fuel Type:");
        String fuel = scan.nextLine();
        fuel = fuel.toUpperCase();
        char newfuel = fuel.charAt(0);


        System.out.println("Enter the Estimated Kilometers Per Liter:");
        int kilometers = scan.nextInt();
        double miles = kilometers / 0.42514;
        int newmiles = (int) miles;
        scan.nextLine();


        String vin = " ";

        vin += code1;
        vin += make;
        vin += newsum;
        vin += modelfirst;
        vin += modellast;
        vin += year;
        vin += destination;
        vin += newfuel;
        vin += newmiles;

        String newvin = vin.replace('I', '1');

        String generated = newvin.replace('O', '0');

        System.out.println("The Assigned VIN is" + generated);


    } //End main method

} //End VinGenerator class
