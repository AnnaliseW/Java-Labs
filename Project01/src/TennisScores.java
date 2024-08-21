import java.util.Scanner;

/**
 * A Tennis Scores calculator.
 *
 * @author Annalise Wang  Purdue CS
 * @version September 26, 2023
 */
public class TennisScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter Player One Name: ");
        String playerOne = scanner.nextLine();
        System.out.println("Enter Player Two Name: ");
        String playerTwo = scanner.nextLine();
        System.out.println("Enter Game Scores: ");
        String scores = scanner.nextLine();

        scanner.close();

        // The values of each of the scores are defined below, you should use these int variables in your calculations.
        int currentScoreIndex = 0;
        int playerOneGameOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int playerOneGameNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int playerOneGameTen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameEleven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameEleven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameTwelve = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameTwelve = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int playerOneGameThirteen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int playerTwoGameThirteen = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        // Todo: Implement your solution below!

        int[] games = {playerOneGameOne, playerTwoGameOne,
                playerOneGameTwo, playerTwoGameTwo,
                playerOneGameThree, playerTwoGameThree,
                playerOneGameFour, playerTwoGameFour,
                playerOneGameFive, playerTwoGameFive,
                playerOneGameSix, playerTwoGameSix,
                playerOneGameSeven, playerTwoGameSeven,
                playerOneGameEight, playerTwoGameEight,
                playerOneGameNine, playerTwoGameNine,
                playerOneGameTen, playerTwoGameTen,
                playerOneGameEleven, playerTwoGameEleven,
                playerOneGameTwelve, playerTwoGameTwelve,
                playerOneGameThirteen, playerTwoGameThirteen};


        String playerOneWinLoseCount = "";
        String playerTwoWinLoseCount = "";
        int playerOneWins = 0;
        int playerTwoWins = 0;
        String winner = "";

        int playerOneScoreCount = 0;
        int playerTwoScoreCount = 0;
        int playerOnePerfectGames = 0;
        int playerTwoPerfectGames = 0;


        for (int i = 0; i < games.length - 3; i = i + 2) {
            if (games[i] > games[i + 1] && games[i] >= 4 && games[i] - games[i + 1] >= 2) {
                playerOneWinLoseCount += "W-";
                playerTwoWinLoseCount += "L-";
                playerOneWins++;

            }
            if (games[i + 1] > games[i] && games[i + 1] >= 4 && games[i + 1] - games[i] >= 2) {
                playerOneWinLoseCount += "L-";
                playerTwoWinLoseCount += "W-";
                playerTwoWins++;
            }

        }

        if (games[24] > games[25] && games[25] >= 4 && games[24] - games[25] >= 2) {
            playerOneWinLoseCount += "W";
            playerTwoWinLoseCount += "L";
            playerOneWins++;
        }
        if (games[25] > games[24] && games[24] >= 4 && games[25] - games[24] >= 2) {
            playerOneWinLoseCount += "L";
            playerTwoWinLoseCount += "W";
            playerTwoWins++;
        }


        for (int i = 0; i < games.length - 1; i = i + 2) {
            if (games[i] >= 4 && games[i + 1] == 0) {
                playerOnePerfectGames++;
            } else if (games[i + 1] >= 4 && games[i] == 0) {
                playerTwoPerfectGames++;
            }
        }

        for (int i = 0; i < games.length; i = i + 2) {
            playerOneScoreCount += games[i];
        }
        for (int i = 1; i < games.length; i = i + 2) {
            playerTwoScoreCount += games[i];
        }

        if (playerOneWins > playerTwoWins) {
            winner += playerOne;
        } else if (playerTwoWins > playerOneWins) {
            winner += playerTwo;
        }

        System.out.println("The winner is: " + winner);
        System.out.println(playerOne + " scored " + playerOneScoreCount + " points.");
        System.out.println(playerTwo + " scored " + playerTwoScoreCount + " points.");
        System.out.println(playerOne + " Game Log: " + playerOneWinLoseCount);
        System.out.println(playerTwo + " Game Log: " + playerTwoWinLoseCount);
        System.out.println(playerOne + " Perfect Games: " + playerOnePerfectGames);
        System.out.println(playerTwo + " Perfect Games: " + playerTwoPerfectGames);

    }
}