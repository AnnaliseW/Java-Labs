import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * PORT NUMBER - 5025
 * Search Server to search for words in a text file
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework11 -- SearchServer
 *
 * @author Annalise Wang Purdue CS
 * @version November 1, 2023
 */

public class SearchServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5025);

        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        //how to loop it again?


        while (true) {


            String searchMessage = reader.readLine();


            File searchDatabase = new File("/Users/annalisewang/IdeaProjects/LABS/Homework11/searchDatabase.txt");
            ArrayList<String> matchingText = new ArrayList<>();
            ArrayList<String> foundMatchingTitles = new ArrayList<>();
            try {
                BufferedReader bfr = new BufferedReader(new FileReader(searchDatabase));
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    matchingText.add(line);
                }
                bfr.close();

            } catch (IOException e) {
                //catch error and display?
            }


            for (int i = 0; i < matchingText.size(); i++) {
                String[] movieDataSplit = matchingText.get(i).split(";");
                if (movieDataSplit[1].contains(searchMessage) || movieDataSplit[2].contains(searchMessage)) {
                    foundMatchingTitles.add(movieDataSplit[1]);

                }
            }
            String allTitles = "";
            for (int i = 0; i < foundMatchingTitles.size(); i++) {
                allTitles += foundMatchingTitles.get(i) + ";";
            }
            writer.write(allTitles);
            writer.println();
            writer.flush();

            String chosenTitle = reader.readLine();
            String pageDescription = "";

            for (int i = 0; i < matchingText.size(); i++) {
                String[] movieDataSplit = matchingText.get(i).split(";");
                if (movieDataSplit[1].equals(chosenTitle)) {
                    pageDescription = movieDataSplit[2];
                }
            }

            writer.write(pageDescription);
            writer.println();
            writer.flush();
        }
    }
}
