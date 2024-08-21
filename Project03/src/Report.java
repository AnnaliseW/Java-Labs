import java.util.ArrayList;
import java.io.*;

/**
 * A class representing reports
 * <p>
 * Purdue University -- CS18000 -- Fall 2023-- Project 03 -- Reports
 *
 * @author Annalise Wang Purdue CS
 * @version October 22, 2023
 */

public class Report {
    private int minPrice;
    private int maxPrice;
    private ArrayList<Company> companyList;

    public Report(int minPrice, int maxPrice, ArrayList<Company> companyList) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.companyList = companyList;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    public void generateReport() {
        File reviewFile = null;
        FileReader fr = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;

        try {
            reviewFile = new File("Report.txt");
            fos = new FileOutputStream(reviewFile, false);
            pw = new PrintWriter(fos);
            String response = "";
            boolean inRange = true;
            for (int i = 0; i < companyList.size(); i++) {
                pw.println(companyList.get(i).getName() + " Report");
                for (int j = 0; j < companyList.get(i).getPrices().length; j++) {
                    try {
                        Validator.checkPrice(companyList.get(i).getPrices()[j]);
                    } catch (InvalidPriceException e) {
                        e.printStackTrace();
                    }
                    if (!(companyList.get(i).getPrices()[j] >= getMinPrice()) ||
                            !(companyList.get(i).getPrices()[j] <= getMaxPrice())) {
                        inRange = false;
                    }
                    if (companyList.get(i).getPrices()[j] < getMinPrice()) {
                        pw.println("Below Minimum Price at " + j + " with " + companyList.get(i).getPrices()[j] + ".");
                    } else if (companyList.get(i).getPrices()[j] > getMaxPrice()) {
                        pw.println("Above Maximum at " + j + " with " + companyList.get(i).getPrices()[j] + ".");

                    }

                }
                if (inRange == true) {
                    pw.println("All prices are within the range.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }

    }

    public void generateReportMax() {
        File reviewFile = null;
        FileReader fr = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;

        try {
            reviewFile = new File("ReportMax.txt");
            fos = new FileOutputStream(reviewFile, false);
            pw = new PrintWriter(fos);
            String response = "";
            for (int i = 0; i < companyList.size(); i++) {
                int maximum = Integer.MIN_VALUE;
                response = companyList.get(i).getName();
                for (int j = 0; j < companyList.get(i).getPrices().length; j++) {
                    if (companyList.get(i).getPrices()[j] > maximum) {
                        maximum = companyList.get(i).getPrices()[j];
                    }
                }
                response += "-" + maximum;
                pw.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }


}
