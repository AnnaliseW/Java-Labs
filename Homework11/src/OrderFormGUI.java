import javax.swing.*;

import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class OrderFormGUI {
    public static void main(String[] args) {
        /** DO NOT CHANGE VALUES BELOW **/
        boolean hoodieInStock = true;
        boolean tshirtInStock = false;
        boolean longsleeveInStock = true;
        String item = "";
        int quantity = 0;
        String name = "";
        /** DO NOT CHANGE VALUES ABOVE **/

        boolean repeat = true;

        while (repeat == true) {
            boolean stock = false;


            //TODO: display error GUI if item selected is out of stock
            String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
            do {
                item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (item.equals("Hoodie") && hoodieInStock == false) {
                    JOptionPane.showMessageDialog(null, "Hoodie out of stock!",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    stock = true;
                }
                else if (item.equals("T-shirt") && tshirtInStock == false) {
                    JOptionPane.showMessageDialog(null, "T-shirt out of stock!",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    stock = true;
                }
                else if (item.equals("Long sleeve") && longsleeveInStock == false) {
                    JOptionPane.showMessageDialog(null, "Long sleeve out of stock!",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    stock = true;
                } else {
                    stock = false;
                }
            } while (stock == true);


            //TODO: display error GUI if input is not an int or if input is less than 1
            String quantity1 = "";
            boolean repeat1 = false;
            do {

                try {
                    quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
                            JOptionPane.QUESTION_MESSAGE));

                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(null, "Enter a number greater than 0",
                                "Order Form", JOptionPane.ERROR_MESSAGE);
                        repeat1 = true;
                    } else if (quantity > 0) {
                        repeat1 = false;
                    }

                    quantity1 = "";
                    quantity1 += quantity;
                    int quantity2 = Integer.parseInt(quantity1);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter an integer",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    repeat1 = true;

                }
            } while (repeat1 == true);

            //TODO: display error GUI if input does not include a space
            boolean repeat2 = false;
            do {
                name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);

                if (!name.contains(" ")) {
                    JOptionPane.showMessageDialog(null, "Enter first and last name",
                            "Order Form", JOptionPane.ERROR_MESSAGE);
                    repeat2 = true;
                } else {
                    repeat2 = false;
                }
            } while (repeat2 == true);


            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

            //TODO: loop through order form again if YES
            int response = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);


            if (response == NO_OPTION) {
                repeat = false;
            }
        }


    }
}
