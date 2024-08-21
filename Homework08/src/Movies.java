import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;


/**
 * Movies Class that will process a movie collection.
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 08 -- Movies
 *
 * @author Annalise Wang Purdue CS
 * @version October 14, 2023
 */


public class Movies {

    private static final String INVALID_RATING = "Rating must be one of the following: PG, G, PG-13, NR, R";
    private static final String INVALID_SCORE = "Score must be between 0 and 10";
    private static final String INVALID_DURATION = "Duration must be between 0 and 300";
    private static final String INVALID_YEAR = "Year must be before 2024";

    public void makeRatingFile(String rating) {
        File movieDataFile = null;
        BufferedReader bfr = null;
        FileReader fr = null;
        ArrayList<String> movieDataList = null;
        File ratingFile = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;


        try {
            movieDataFile = new File("movieData.txt");
            fr = new FileReader(movieDataFile);
            bfr = new BufferedReader(fr);
            movieDataList = new ArrayList<String>();
            String line = bfr.readLine();
            while (line != null) {
                movieDataList.add(line);
                line = bfr.readLine();
            }
            ratingFile = new File("ratings.txt");
            fos = new FileOutputStream(ratingFile, false);
            pw = new PrintWriter(fos);
            for (int i = 0; i < movieDataList.size(); i++) {
                String[] movieDataSplit = movieDataList.get(i).split(",");
                if (movieDataSplit[2].equals(rating)) {
                    pw.println(movieDataSplit[0] + " | " + movieDataSplit[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }


        }
    }

    public void makeScoreFile(double score, boolean greaterThan) {
        File movieDataFile = null;
        BufferedReader bfr = null;
        FileReader fr = null;
        ArrayList<String> movieDataList = null;
        PrintWriter pw = null;
        try {
            movieDataFile = new File("movieData.txt");
            fr = new FileReader(movieDataFile);
            bfr = new BufferedReader(fr);
            movieDataList = new ArrayList<String>();
            String line = bfr.readLine();
            while (line != null) {
                movieDataList.add(line);
                line = bfr.readLine();
            }
            File scoresFile = new File("scores.txt");
            FileOutputStream fos = new FileOutputStream(scoresFile, false);
            pw = new PrintWriter(fos);

            for (int i = 0; i < movieDataList.size(); i++) {
                String[] movieDataSplit = movieDataList.get(i).split(",");
                double movieDataScore = Double.parseDouble(movieDataSplit[5]);
                if (greaterThan == true) {
                    if (movieDataScore > score) {
                        pw.println(movieDataSplit[0] + " | " + movieDataSplit[4]);
                    }
                } else if (greaterThan == false) {
                    if (movieDataScore <= score) {
                        pw.println(movieDataSplit[0] + " | " + movieDataSplit[4]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
    }


    public void makeDurationFile(int duration, boolean greaterThan) {
        File movieDataFile = null;
        BufferedReader bfr = null;
        FileReader fr = null;
        ArrayList<String> movieDataList = null;
        PrintWriter pw = null;
        try {
            movieDataFile = new File("movieData.txt");
            fr = new FileReader(movieDataFile);
            bfr = new BufferedReader(fr);
            movieDataList = new ArrayList<String>();
            String line = bfr.readLine();
            while (line != null) {
                movieDataList.add(line);
                line = bfr.readLine();
            }
            File scoresFile = new File("durations.txt");
            FileOutputStream fos = new FileOutputStream(scoresFile, false);
            pw = new PrintWriter(fos);

            for (int i = 0; i < movieDataList.size(); i++) {
                String[] movieDataSplit = movieDataList.get(i).split(",");
                int movieDataDuration = Integer.parseInt(movieDataSplit[3]);
                if (greaterThan == true) {
                    if (movieDataDuration > duration) {
                        pw.println(movieDataSplit[0] + " | " + movieDataSplit[4]);
                    }
                } else if (greaterThan == false) {
                    if (movieDataDuration <= duration) {
                        pw.println(movieDataSplit[0] + " | " + movieDataSplit[4]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }


        }

    }

    public void makeYearFile(int year) {
        File movieDataFile = null;
        BufferedReader bfr = null;
        FileReader fr = null;
        ArrayList<String> movieDataList = null;
        PrintWriter pw = null;
        try {
            movieDataFile = new File("movieData.txt");
            fr = new FileReader(movieDataFile);
            bfr = new BufferedReader(fr);
            movieDataList = new ArrayList<String>();
            String line = bfr.readLine();
            while (line != null) {
                movieDataList.add(line);
                line = bfr.readLine();
            }
            File scoresFile = new File("years.txt");
            FileOutputStream fos = new FileOutputStream(scoresFile, false);
            pw = new PrintWriter(fos);

            for (int i = 0; i < movieDataList.size(); i++) {
                String[] movieDataSplit = movieDataList.get(i).split(",");
                int movieDataYear = Integer.parseInt(movieDataSplit[1]);
                if (movieDataYear == year) {
                    pw.println(movieDataSplit[0] + " | " + movieDataSplit[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }


        }
    }

    public void validateInput(String rating, double score, int duration, int year) throws InvalidInputException {
        String numbers = Integer.toString(year);

        if (!rating.equals("PG") && !rating.equals("G") && !rating.equals("PG-13")
                && !rating.equals("NR") && !rating.equals("R")) {
            throw new InvalidInputException(INVALID_RATING);
        }
        if (score > 10 || score < 0) {
            throw new InvalidInputException(INVALID_SCORE);
        }
        if (duration > 300 || duration < 0) {
            throw new InvalidInputException(INVALID_DURATION);
        }
        if (year > 2024 || numbers.length() != 4) {
            throw new InvalidInputException(INVALID_YEAR);
        }
    }


    public static void main(String[] args) throws InvalidInputException {
        Movies movies = new Movies();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Movie Rating:");

        String rating = scan.nextLine();

        System.out.println("Enter Movie Duration:");

        int duration = scan.nextInt();

        System.out.println("Enter Movie Score:");

        double score = scan.nextDouble();

        System.out.println("Will the filter be greater or less than?");

        boolean greaterThan = scan.nextBoolean();

        System.out.println("Enter Movie Year:");

        int year = scan.nextInt();

        movies.validateInput(rating, score, duration, year);
        movies.makeRatingFile(rating);
        movies.makeDurationFile(duration, greaterThan);
        movies.makeScoreFile(score, greaterThan);
        movies.makeYearFile(year);
    }


}
