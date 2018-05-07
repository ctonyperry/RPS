package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {
    //This class mostly exists as a way to easily replace the input output in case I had time.

    public static String getStringInput(boolean preserveCase) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return (preserveCase) ? reader.readLine() : reader.readLine().toLowerCase();
        } catch (IOException e) {
            showMessage("Invalid input, try again");
            getStringInput(preserveCase);
        }
        return null;
    }

    public static String getStringInput() {
        return getStringInput(false);
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static boolean playAgain() {
        showMessage("Play Again? (y or n)");

        boolean choice = (getStringInput().equals("n")) ? false : true;
        System.out.println(choice);
        //Only 'n' quits, any other input including just \n will play again
        return choice;
    }

    public static boolean isTwoPlayerGame() {
        showMessage("(1) or (2) players?");
        boolean isTwoPlayerGame = false;
        int playerCount = Integer.parseInt(getStringInput());
        if (playerCount == 1 || playerCount == 2) {
            isTwoPlayerGame = (playerCount == 2) ? true : false;
        }

        return isTwoPlayerGame;
    }


}
