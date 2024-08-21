import java.io.*;
import java.util.ArrayList;

/**
 * A class representing data system
 * <p>
 * Purdue University -- CS18000 -- Fall 2023-- Project 03 -- DataSystem
 *
 * @author Annalise Wang Purdue CS
 * @version October 22, 2023
 */

public class DataSystem {
    public static void main(String[] args) {

        try {
            String fileName = args[0];
            try {
                Validator.checkFile(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            ArrayList<Company> companyList = new ArrayList<>();
            String line = "";
            int count = 0;
            String name = null;
            int minValue = 0;
            int maxValue = 0;
            int companyValue = 0;
            Report report;
            while ((line = bfr.readLine()) != null) {
                if (count == 0) {
                    int position = line.indexOf(':');
                    String beginning = line.substring(0, position);
                    String valueType = "MaxValue";
                    try {
                        Validator.checkValueFormat(line, valueType);
                    } catch (WrongFormatException e) {
                        e.printStackTrace();
                    }
                    maxValue = Integer.parseInt(line.substring(position + 1));
                    count++;
                } else if (count == 1) {
                    int position = line.indexOf(':');
                    String beginning = line.substring(0, position);
                    String valueType = "MinValue";
                    try {
                        Validator.checkValueFormat(line, valueType);
                    } catch (WrongFormatException e) {
                        e.printStackTrace();
                    }
                    minValue = Integer.parseInt(line.substring(position + 1));
                    count++;
                } else if (count == 2) {
                    int position = line.indexOf(':');
                    String beginning = line.substring(0, position);
                    String valueType = "CompanyNumberValue";
                    count++;
                    try {
                        Validator.checkValueFormat(line, valueType);
                    } catch (WrongFormatException e) {
                        e.printStackTrace();
                    }
                    companyValue = Integer.parseInt(line.substring(position + 1));
                    String pricesWithCommas = "";
                    String companyNames = "";
                    for (int j = 3; j < companyValue + 3; j++) {
                        line = bfr.readLine();
                        int newPosition = line.indexOf(':');
                        companyNames = line.substring(0, newPosition);
                        pricesWithCommas = line.substring(newPosition + 1);
                        String[] pricesSeparated = pricesWithCommas.split(",");
                        int[] prices = new int[pricesSeparated.length];
                        for (int i = 0; i < prices.length; i++) {
                            prices[i] = Integer.parseInt(pricesSeparated[i]);
                        }
                        Company company = new Company(companyNames, prices);
                        companyList.add(company);

                    }

                }
            }
            bfr.close();
            report = new Report(minValue, maxValue, companyList);
            report.generateReport();
            report.generateReportMax();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




