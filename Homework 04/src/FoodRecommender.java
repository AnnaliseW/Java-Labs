/**
 * A Food Recommender Program.
 * <p>
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 04 -- Food Recommender
 *
 * @author Annalise Wang Purdue CS
 * @version September 13, 2023
 */

import java.util.Scanner;

public class FoodRecommender {

    public static final String WELCOME_MESSAGE = "Welcome to the Food Recommender!";
    public static final String INITIAL_FOOD = "Do you want to have good food?";
    public static final String SPICY = "Do you like spicy food?";
    public static final String CHINESE = "Do you want to try spicy Chinese Food?";
    public static final String INDIAN = "Do you want to try spicy Indian Food?";
    public static final String ETHIOPIAN = "Do you want to try spicy Ethiopian food?";
    public static final String SEA_FOOD = "Do you like sea food?";
    public static final String SUSHI = "Do you like traditional sushi?";
    public static final String BEEF = "Do you like beef?";
    public static final String PORK = "Do you like pork?";
    public static final String LAMB = "Do you like lamb?";
    public static final String SOUP = "Do you want soup with beef?";
    public static final String GOODBYE_MESSAGE = "Thank you for using" +
            " the Food Recommender!";


    public static final String HOT_POT = "Sichuan hot pot is a great choice!";
    public static final String VINDALOO = "Vindaloo is a great choice!";
    public static final String DORO_WAT = "Doro wat is very good!";
    public static final String PENNE = "Penne all’arrabbiata is delicious!";
    public static final String SALMON_SUSHI = "Salmon sushi will fulfill you!";
    public static final String BBQ_SUSHI = "BBQ bacon sushi is a great combination of sushi and meat!";
    public static final String FRUIT_SALAD = "Sweet fruit salad is a great choice!";
    public static final String PORK_QUESADILLAS = "Pork quesadillas are very tasty!";
    public static final String LAMB_CHOPS = "Rosemary roast lamb chops are a great choice!";
    public static final String BIBIMBAP = "Beef and veggie bibimbap will fulfill you!";
    public static final String PHO_SOUP = "Vietnamese beef and noodle pho soup is very good!";
    // ------------------------- DO NOT MODIFY ABOVE -------------------------


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.println(WELCOME_MESSAGE);

        System.out.println(INITIAL_FOOD);
        String goodfood = s.nextLine();

        if (goodfood.equals("no") || goodfood.equals("No")) {
            System.out.println(GOODBYE_MESSAGE);
        } else if (goodfood.equals("yes") || goodfood.equals("Yes")) {

            System.out.println(SPICY);
            String spicy = s.nextLine();
            if (spicy.equals("yes") || spicy.equals("Yes")) {
                System.out.println(CHINESE);
                String chinese = s.nextLine();
                if (chinese.equals("Yes") || chinese.equals("yes")) {
                    System.out.println(HOT_POT);
                    System.out.println(GOODBYE_MESSAGE);
                } else if (chinese.equals("No") || chinese.equals("no")) {
                    System.out.println(INDIAN);
                    String indian = s.nextLine();
                    if (indian.equals("Yes") || indian.equals("yes")) {
                        System.out.println(VINDALOO);
                        System.out.println(GOODBYE_MESSAGE);
                    } else if (indian.equals("No") || indian.equals("no")) {
                        System.out.println(ETHIOPIAN);
                        String ethiopian = s.nextLine();
                        if (ethiopian.equals("Yes") || ethiopian.equals("yes")) {
                            System.out.println(DORO_WAT);
                            System.out.println(GOODBYE_MESSAGE);
                        } else if (ethiopian.equals("No") || ethiopian.equals("no")) {
                            System.out.println(PENNE);
                            System.out.println(GOODBYE_MESSAGE);
                        }
                    }
                }
            } else if (spicy.equals("no") || spicy.equals("No")) {
                System.out.println(SEA_FOOD);
                String seafood = s.nextLine();
                if (seafood.equals("Yes") || seafood.equals("yes")) {
                    System.out.println(SUSHI);
                    String sushi = s.nextLine();
                    if (sushi.equals("Yes") || sushi.equals("yes")) {
                        System.out.println(SALMON_SUSHI);
                        System.out.println(GOODBYE_MESSAGE);
                    } else if (sushi.equals("No") || sushi.equals("no")) {
                        System.out.println(BBQ_SUSHI);
                        System.out.println(GOODBYE_MESSAGE);
                    }
                } else if (seafood.equals("No") || seafood.equals("no")) {
                    System.out.println(BEEF);
                    String beef = s.nextLine();
                    if (beef.equals("Yes") || beef.equals("yes")) {
                        System.out.println(SOUP);
                        String soup = s.nextLine();
                        if (soup.equals("Yes") || soup.equals("yes")) {
                            System.out.println(PHO_SOUP);
                            System.out.println(GOODBYE_MESSAGE);
                        } else if (soup.equals("No") || soup.equals("no")) {
                            System.out.println(BIBIMBAP);
                            System.out.println(GOODBYE_MESSAGE);
                        }
                    } else if (beef.equals("No") || beef.equals("no")) {
                        System.out.println(PORK);
                        String pork = s.nextLine();
                        if (pork.equals("Yes") || pork.equals("yes")) {
                            System.out.println(PORK_QUESADILLAS);
                            System.out.println(GOODBYE_MESSAGE);
                        } else if (pork.equals("No") || pork.equals("no")) {
                            System.out.println(LAMB);
                            String lamb = s.nextLine();
                            if (lamb.equals("Yes") || lamb.equals("yes")) {
                                System.out.println(LAMB_CHOPS);
                                System.out.println(GOODBYE_MESSAGE);
                            } else if (lamb.equals("No") || lamb.equals("no")) {
                                System.out.println(FRUIT_SALAD);
                                System.out.println(GOODBYE_MESSAGE);
                            }
                        }
                    }
                }

            }


        }

    }
}