import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static javax.swing.JOptionPane.NO_OPTION;

/**
 * PORT NUMBER - 5025
 * Search Client to search for words in a text file
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework11 -- SearchClient
 *
 * @author Annalise Wang Purdue CS
 * @version November 1, 2023
 */

public class SearchClient {

    public static void main(String[] args) {
        boolean searchAgain = true;

        int welcome = JOptionPane.showOptionDialog(null, "Welcome to our Database!",
                "Search Client", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (welcome == -1) {
            return;
        }


        String hostName = JOptionPane.showInputDialog(null, "Please enter a host name",
                "Search Client", JOptionPane.QUESTION_MESSAGE);

        if (hostName == null || hostName.isEmpty()) {
            return;
        }
        String portString = (JOptionPane.showInputDialog(null, "Please enter a port number",
                "Search Client", JOptionPane.QUESTION_MESSAGE));
        if (portString == null || portString.isEmpty()) {
            return;
        }
        int portNumber = Integer.parseInt(portString);

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            socket = new Socket(hostName, portNumber);

            int connected = JOptionPane.showOptionDialog(null, "Client connected!",
                    "Search Client", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (connected == -1) {
                return;
            }
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error! Could not connect",
                    "Search Client", JOptionPane.ERROR_MESSAGE);
            return;
        }


        do {
            try {
                //host name should be "localhost"


                String searchText = JOptionPane.showInputDialog(null, "Please enter search text",
                        "Search Client", JOptionPane.QUESTION_MESSAGE);
                if (searchText == null || searchText.isEmpty()) {
                    return;
                }

                writer.write(searchText);
                writer.println();
                writer.flush();


                String receivedTitles = reader.readLine();

                if (receivedTitles.isEmpty()) {
                    int noTitles = JOptionPane.showOptionDialog(null, "No titles found with your search text",
                            "Search Client", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, null, null);
                    if (noTitles == -1) {
                        return;
                    }
                } else {
                    String[] allMatchingTitles = receivedTitles.split(";");
                    String titles = (String) JOptionPane.showInputDialog(null, "Titles that matched your search text",
                            "Search Client", JOptionPane.QUESTION_MESSAGE, null, allMatchingTitles,
                            allMatchingTitles[0]);
                    if (titles == null || titles.isEmpty()) {
                        return;
                    }

                    writer.write(titles);
                    writer.println();
                    writer.flush();

                    String pageDescription = reader.readLine();
                    int description = JOptionPane.showOptionDialog(null, "" + pageDescription,
                            "Search Client", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, null, null);
                    if (description == -1) {
                        return;
                    }
                }

                int response = JOptionPane.showConfirmDialog(null, "Would you like to search again?",
                        "Search Client", JOptionPane.YES_NO_OPTION);
                if (response == -1) {
                    return;
                }
                if (response == NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank you for using our Database!",
                            "Search Client", JOptionPane.INFORMATION_MESSAGE);
                    searchAgain = false;

                }


            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error! Could not connect",
                        "Search Client", JOptionPane.ERROR_MESSAGE);
            }
        } while (searchAgain);
        writer.close();
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

