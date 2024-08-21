import java.util.Scanner;

public class OddFruitOut {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String welcome = "Hello, welcome to the Odd Fruit Out game!";
        String prompt = "Please enter a String of fruits separated by commas.";
        String result = "The odd fruit out is fruit number ";


        System.out.println(welcome);
        System.out.println(prompt);
        String list = s.nextLine();

        String s1 = "";
        String s2 = "";
        String oddOut = "";
        int index = 1;

        boolean nextWord = false;

        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == ',') {
                nextWord = true;
                index = index + 1;
            }

            if (nextWord == true) {
                s2 = s2 + list.charAt(i);
                if (s1.compareTo(s2) > 0) {
                    oddOut += s2;
                    return;
                } else if (s1.compareTo(s2) < 0) {
                    s1 = s2;
                    s2 = "";
                }

            } else if (nextWord == false) {
                s1 = s1 + list.charAt(i);
            }
        }

        System.out.println(oddOut);

            System.out.println(result + index + ": " + oddOut);






    }



}

