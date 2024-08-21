import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

/**
 * Several Menus for users to navigate their labs.
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Project 02 -- Time Keeper
 *
 * @author Annalise Wang Purdue CS
 * @version October 12, 2023
 */

public class TimeKeeper {

    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println(welcomePrompt);
        System.out.println(initializeMenu);
        int exitOrStay = s.nextInt();
        s.nextLine();

        if (exitOrStay != 1 && exitOrStay != 2) {
            boolean continueAgain = true;
            while (continueAgain == true) {
                System.out.println(invalidInput);
                System.out.println(initializeMenu);
                int newResponse = s.nextInt();
                s.nextLine();
                if (newResponse == 2) {
                    System.out.println(exitMessage);
                    continueAgain = false;
                } else if (newResponse == 1) {
                    continueAgain = false;

                    System.out.println(enterLabCapacity + 1 + ":");
                    int answer1Capacity = s.nextInt();
                    s.nextLine();
                    System.out.println(enterLabLocation + 1 + ":");
                    String answer1Location = s.nextLine();
                    System.out.println(enterLabCapacity + 2 + ":");
                    int answer2Capacity = s.nextInt();
                    s.nextLine();
                    System.out.println(enterLabLocation + 2 + ":");
                    String answer2Location = s.nextLine();
                    System.out.println(enterLabCapacity + 3 + ":");
                    int answer3Capacity = s.nextInt();
                    s.nextLine();
                    System.out.println(enterLabLocation + 3 + ":");
                    String answer3Location = s.nextLine();


                    Lab labOne = new Lab(answer1Capacity, answer1Location);
                    Lab labTwo = new Lab(answer2Capacity, answer2Location);
                    Lab labThree = new Lab(answer3Capacity, answer3Location);
                    boolean continueOngoingMenu = true;


                    while (continueOngoingMenu == true) {

                        System.out.println(ongoingMenu);
                        int responseOngoingMenu = s.nextInt();
                        s.nextLine();


                        if (responseOngoingMenu == 1) {
                            System.out.println(labOne.toString());
                            System.out.println(labTwo.toString());
                            System.out.println(labThree.toString());
                        } else if (responseOngoingMenu == 2) {
                            System.out.println("Lab One");
                            System.out.println(labOne.listAvailabilities());
                            System.out.println("Lab Two");
                            System.out.println(labTwo.listAvailabilities());
                            System.out.println("Lab Three");
                            System.out.println(labThree.listAvailabilities());
                        } else if (responseOngoingMenu == 3) {
                            System.out.println("Lab One");
                            System.out.println(labOne.listReservations());
                            System.out.println("\nLab Two");
                            System.out.println(labTwo.listReservations());
                            System.out.println("\nLab Three");
                            System.out.println(labThree.listReservations());
                        } else if (responseOngoingMenu == 4) {
                            System.out.println(labLocationPrompt);
                            String locationReservation = s.nextLine();
                            System.out.println(reservationTimePrompt);
                            String timeReservation = s.nextLine();
                            System.out.println(reservationNamePrompt);
                            String nameReservation = s.nextLine();
                            System.out.println(reservationEnrollmentPrompt);
                            int expectedEnrollmentReservation = s.nextInt();
                            s.nextLine();
                            LabManager reservation = new LabManager(labOne, labTwo, labThree);
                            System.out.println(reservation.addReservation(locationReservation, timeReservation,
                                    nameReservation, expectedEnrollmentReservation));
                        } else if (responseOngoingMenu == 5) {
                            System.out.println(labLocationPrompt);
                            String locationReservation = s.nextLine();
                            System.out.println(reservationTimePrompt);
                            String timeReservation = s.nextLine();
                            LabManager reservation = new LabManager(labOne, labTwo, labThree);
                            System.out.println(reservation.removeReservation(locationReservation, timeReservation));
                        } else if (responseOngoingMenu == 6) {
                            System.out.println(labLocationPrompt);
                            String locationReservation = s.nextLine();
                            System.out.println(reservationTimePrompt);
                            String timeReservation = s.nextLine();
                            System.out.println(reservationNameUpdate);
                            String newName = s.nextLine();
                            System.out.println(reservationEnrollmentUpdate);
                            int updatedEnrollment = s.nextInt();
                            s.nextLine();
                            LabManager reservation = new LabManager(labOne, labTwo, labThree);
                            System.out.println(reservation.modifyReservation(locationReservation,
                                    timeReservation, newName, updatedEnrollment));
                        } else if (responseOngoingMenu == 8) {
                            System.out.println("Thank you for using Time Keeper!");
                            continueOngoingMenu = false;
                        } else if (responseOngoingMenu == 7) {
                            boolean continueStatisticsMenu = true;

                            while (continueStatisticsMenu == true) {
                                System.out.println(statisticsMenu);
                                int responseStatisticsMenu = s.nextInt();
                                s.nextLine();
                                if (responseStatisticsMenu == 1) {
                                    LabManager calculate = new LabManager(labOne, labTwo, labThree);
                                    System.out.println(totalCapacity + calculate.calculateTotalCapacity());
                                } else if (responseStatisticsMenu == 2) {
                                    LabManager calculate = new LabManager(labOne, labTwo, labThree);
                                    double rounded = calculate.calculateTotalUtilization();
                                    String rounded1 = String.format("%.2f", rounded);

                                    System.out.println(totalUtilization + rounded1);
                                } else if (responseStatisticsMenu == 3) {
                                    LabManager calculate = new LabManager(labOne, labTwo, labThree);
                                    System.out.println(availableSeats + calculate.calculateAvailableSeats());
                                } else if (responseStatisticsMenu == 4) {
                                    continueStatisticsMenu = false;

                                }
                            }
                        } else {
                            System.out.println("Invalid input. Please try again.");
                        }


                    }

                } else {
                    continueAgain = true;

                }
            }

        } else if (exitOrStay == 2) {
            System.out.println(exitMessage);
        } else if (exitOrStay == 1) {
            System.out.println(enterLabCapacity + 1 + ":");
            int answer1Capacity = s.nextInt();
            s.nextLine();
            System.out.println(enterLabLocation + 1 + ":");
            String answer1Location = s.nextLine();
            System.out.println(enterLabCapacity + 2 + ":");
            int answer2Capacity = s.nextInt();
            s.nextLine();
            System.out.println(enterLabLocation + 2 + ":");
            String answer2Location = s.nextLine();
            System.out.println(enterLabCapacity + 3 + ":");
            int answer3Capacity = s.nextInt();
            s.nextLine();
            System.out.println(enterLabLocation + 3 + ":");
            String answer3Location = s.nextLine();


            Lab labOne = new Lab(answer1Capacity, answer1Location);
            Lab labTwo = new Lab(answer2Capacity, answer2Location);
            Lab labThree = new Lab(answer3Capacity, answer3Location);
            boolean continueOngoingMenu = true;


            while (continueOngoingMenu == true) {

                System.out.println(ongoingMenu);
                int responseOngoingMenu = s.nextInt();
                s.nextLine();


                if (responseOngoingMenu == 1) {
                    System.out.println(labOne.toString());
                    System.out.println(labTwo.toString());
                    System.out.println(labThree.toString());
                } else if (responseOngoingMenu == 2) {
                    System.out.println("Lab One");
                    System.out.println(labOne.listAvailabilities());
                    System.out.println("Lab Two");
                    System.out.println(labTwo.listAvailabilities());
                    System.out.println("Lab Three");
                    System.out.println(labThree.listAvailabilities());
                } else if (responseOngoingMenu == 3) {
                    System.out.println("Lab One");
                    System.out.println(labOne.listReservations());
                    System.out.println("\nLab Two");
                    System.out.println(labTwo.listReservations());
                    System.out.println("\nLab Three");
                    System.out.println(labThree.listReservations());
                } else if (responseOngoingMenu == 4) {
                    System.out.println(labLocationPrompt);
                    String locationReservation = s.nextLine();
                    System.out.println(reservationTimePrompt);
                    String timeReservation = s.nextLine();
                    System.out.println(reservationNamePrompt);
                    String nameReservation = s.nextLine();
                    System.out.println(reservationEnrollmentPrompt);
                    int expectedEnrollmentReservation = s.nextInt();
                    s.nextLine();
                    LabManager reservation = new LabManager(labOne, labTwo, labThree);
                    System.out.println(reservation.addReservation(locationReservation, timeReservation,
                            nameReservation, expectedEnrollmentReservation));
                } else if (responseOngoingMenu == 5) {
                    System.out.println(labLocationPrompt);
                    String locationReservation = s.nextLine();
                    System.out.println(reservationTimePrompt);
                    String timeReservation = s.nextLine();
                    LabManager reservation = new LabManager(labOne, labTwo, labThree);
                    System.out.println(reservation.removeReservation(locationReservation, timeReservation));
                } else if (responseOngoingMenu == 6) {
                    System.out.println(labLocationPrompt);
                    String locationReservation = s.nextLine();
                    System.out.println(reservationTimePrompt);
                    String timeReservation = s.nextLine();
                    System.out.println(reservationNameUpdate);
                    String newName = s.nextLine();
                    System.out.println(reservationEnrollmentUpdate);
                    int updatedEnrollment = s.nextInt();
                    s.nextLine();
                    LabManager reservation = new LabManager(labOne, labTwo, labThree);
                    System.out.println(reservation.modifyReservation(locationReservation,
                            timeReservation, newName, updatedEnrollment));
                } else if (responseOngoingMenu == 8) {
                    System.out.println("Thank you for using Time Keeper!");
                    continueOngoingMenu = false;
                } else if (responseOngoingMenu == 7) {
                    boolean continueStatisticsMenu = true;

                    while (continueStatisticsMenu == true) {
                        System.out.println(statisticsMenu);
                        int responseStatisticsMenu = s.nextInt();
                        s.nextLine();
                        if (responseStatisticsMenu == 1) {
                            LabManager calculate = new LabManager(labOne, labTwo, labThree);
                            System.out.println(totalCapacity + calculate.calculateTotalCapacity());
                        } else if (responseStatisticsMenu == 2) {
                            LabManager calculate = new LabManager(labOne, labTwo, labThree);
                            double rounded = calculate.calculateTotalUtilization();
                            String rounded1 = String.format("%.2f", rounded);
                            System.out.println(totalUtilization + rounded1);
                        } else if (responseStatisticsMenu == 3) {
                            LabManager calculate = new LabManager(labOne, labTwo, labThree);
                            System.out.println(availableSeats + calculate.calculateAvailableSeats());
                        } else if (responseStatisticsMenu == 4) {
                            continueStatisticsMenu = false;

                        }
                    }
                } else {
                    System.out.println("Invalid input. Please try again.");
                }


            }

        }

    }

}







