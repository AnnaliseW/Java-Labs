import java.io.*;

/**
 * A class representing validators
 * <p>
 * Purdue University -- CS18000 -- Fall 2023-- Project 03 -- Validator
 *
 * @author Annalise Wang Purdue CS
 * @version October 22, 2023
 */

public class Validator {
    public static int checkPrice(int price) throws InvalidPriceException {
        if (price >= 0) {
            return price;
        } else {
            throw new InvalidPriceException("Invalid Price Format: " + price);
        }
    }

    public static int checkValueFormat(String line, String valueType) throws WrongFormatException {
        String[] typeOfValue = line.split(":");
        String word = typeOfValue[0];
        if ((valueType.equals("MaxValue") && word.equals("Max")) ||
                (valueType.equals("MinValue") && word.equals("Min")) ||
                (valueType.equals("CompanyNumberValue") && word.equals("CompanyNumber"))) {
            int position = line.indexOf(':');
            String value = line.substring(position + 1);
            return Integer.parseInt(value);
        } else {
            throw new WrongFormatException("Invalid " + valueType + " error");
        }
    }

    public static void checkFile(String fileName) throws FileNotFoundException {
        File checking = new File(fileName);
        if (!checking.exists()) {
            throw new FileNotFoundException("File: " + fileName + " is invalid");
        }

    }


}
