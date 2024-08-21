import java.util.Scanner;
/**
 * HW-03 --OddFruitOut
 * <p>
 * This program takes a list of fruit and returns the one in the wrong order
 *
 * @author Annalise Wang, L31
 * @version September 20, 2023
 */

public class OddFruitOut {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String welcome = "Hello, welcome to the Odd Fruit Out game!";
        String prompt = "Please enter a String of fruits separated by commas.";
        String result = "The odd fruit out is fruit number ";


        System.out.println(welcome);
        System.out.println(prompt);
        String list = s.nextLine();

        int totalFruit = 1;


        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == ',') {
                totalFruit++;
            }
        }

        String[] fruitList = new String[totalFruit];

        int beginning = 0;
        int end = 0;
        int fruitPositionArray = 0;

        while (end < list.length()) {
            if (list.charAt(end) == ',') {
                fruitList[fruitPositionArray] = list.substring(beginning, end);
                fruitPositionArray++;
                beginning = end + 1;
            }
            end++;
        }

        fruitList[fruitPositionArray] = list.substring(beginning);

        String violatesRule = "";
        int wrongIndex = 2;
        int indexPosition = 0;


        for (int i = 0; i < fruitList.length - 1; i++) {
            String word1 = fruitList[i];
            String word2 = fruitList[i + 1];
            if (word1.compareTo(word2) > 0) {
                violatesRule += word2;
                indexPosition = wrongIndex;
            } else if (word1.compareTo(word2) < 0) {
                wrongIndex++;
            }
        }

        System.out.println(result + indexPosition + ": " + violatesRule);

    }
}


