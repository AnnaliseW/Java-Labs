import java.io.*;

/**
 * Map Navigator Class that will simulate a map navigator based on player moves
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework 10 -- MapNavigator
 *
 * @author Annalise Wang Purdue CS
 * @version October 26, 2023
 */
public class MapNavigator extends Thread {

    private static int currentRow;
    private static int currentColumn;
    private static int moveNumber;
    private static boolean started;
    private static char[][] map;
    private int playerNumber;
    private String fileName;


    public MapNavigator(int playerNumber, String fileName) {
        this.playerNumber = playerNumber;
        this.fileName = fileName;
        started = false;
    }


    public static Object obj = new Object();

    public void printMap() {
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++) {
                if (i == currentColumn && k == currentRow) {
                    map[k][i] = 'X';
                } else {
                    map[k][i] = ' ';
                }

            }
        }

        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    System.out.print("[" + map[k][i]);
                }
                if (i == 9) {
                    System.out.print("|" + map[k][i] + "]");
                    System.out.println();
                }
                if (i != 0 && i != 9) {
                    System.out.print("|" + map[k][i]);
                }
            }
            System.out.println("---------------------");
        }

    }


    public void moveLeft() {
        map[currentRow][currentColumn] = ' ';
        if (currentColumn == 0) {
            currentColumn = 9;
        } else {
            currentColumn = currentColumn - 1;
        }
        moveNumber++;

    }


    public void moveRight() {
        map[currentRow][currentColumn] = ' ';
        if (currentColumn == 9) {
            currentColumn = 0;
        } else {
            currentColumn = currentColumn + 1;
        }
        moveNumber++;
    }

    public void moveUp() {
        map[currentRow][currentColumn] = ' ';
        if (currentRow == 0) {
            currentRow = 9;
        } else {
            currentRow = currentRow - 1;
        }
        moveNumber++;

    }

    public void moveDown() {
        map[currentRow][currentColumn] = ' ';
        if (currentRow == 9) {
            currentRow = 0;
        } else {
            currentRow = currentRow + 1;
        }

        moveNumber++;
    }

    public void startGame() {
        synchronized (obj) {
            if (started == false) {
                moveNumber = 1;
                currentRow = 4;
                currentColumn = 4;
                System.out.println("Welcome! Initial map:");
                printMap();
                started = true;
            }
        }
    }


    public void readMoves(String file) {

        try {
            File playerInputFile = new File(file);
            FileReader fr = new FileReader(playerInputFile);
            BufferedReader bfr = new BufferedReader(fr);
            String line = bfr.readLine();

            while (line != null) {
                int numberMove = Integer.parseInt(line);
                if (numberMove == 1) {
                    synchronized (obj) {
                        System.out.println("Move Number: " + moveNumber);
                        System.out.println("Player: " + playerNumber);
                        System.out.println("Move: Left");
                        moveLeft();
                        printMap();
                    }

                } else if (numberMove == 2) {
                    synchronized (obj) {
                        System.out.println("Move Number: " + moveNumber);
                        System.out.println("Player: " + playerNumber);
                        System.out.println("Move: Right");
                        moveRight();
                        printMap();
                    }

                } else if (numberMove == 3) {
                    synchronized (obj) {
                        System.out.println("Move Number: " + moveNumber);
                        System.out.println("Player: " + playerNumber);
                        System.out.println("Move: Up");
                        moveUp();
                        printMap();
                    }

                } else if (numberMove == 4) {
                    synchronized (obj) {
                        System.out.println("Move Number: " + moveNumber);
                        System.out.println("Player: " + playerNumber);
                        System.out.println("Move: Down");
                        moveDown();
                        printMap();
                    }

                } else {
                    System.out.println("Error, invalid input!");
                }

                line = bfr.readLine();
            }
            fr.close();
            bfr.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void run() {
        map = new char[10][10];
        startGame();
        readMoves(fileName);
    }

    public static void main(String[] args) {
        try {
            MapNavigator[] mapNavigators = {new MapNavigator(1 , "/Users/annalisewang/IdeaProjects/LABS/Homework10/PlayerOneMoves.txt"),
                    new MapNavigator(2 , "/Users/annalisewang/IdeaProjects/LABS/Homework10/PlayerTwoMoves.txt"),
                    new MapNavigator(3 , "/Users/annalisewang/IdeaProjects/LABS/Homework10/PlayerThreeMoves.txt"),
                    new MapNavigator(4 , "/Users/annalisewang/IdeaProjects/LABS/Homework10/PlayerFourMoves.txt")};

            for (int i = 0; i < mapNavigators.length; i++) {
                mapNavigators[i].start();
            }
            for (int i = 0; i < mapNavigators.length; i++) {
                mapNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }


}
