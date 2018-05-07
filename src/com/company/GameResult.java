package com.company;

public class GameResult {

    String winnerName;
    String loserName;
    String winnerChoice;
    String loserChoice;
    boolean isDraw;

    public GameResult(Player winner, Player loser, boolean isDraw) {

        this.winnerName = winner.name;
        this.loserName = loser.name;
        this.winnerChoice = getObjectName(winner.choice);
        this.loserChoice = getObjectName(loser.choice);
        this.isDraw = isDraw;
    }

    public GameResult(Player[] players) {
        Player playerOne = players[0];
        Player playerTwo = players[1];

        String winString = "-- %s wins --";

        Player winner = null;
        this.isDraw = false;

        /*
        used following algorithm from https://stackoverflow.com/questions/20271325/algorithm-for-scissor-paper-stone
        to get rid of unwieldy switch statement
        */
        if (playerTwo.choice % 3 + 1 == playerOne.choice) {
            this.winnerName = playerOne.name;
            this.loserName = playerTwo.name;
            this.winnerChoice = getObjectName(playerOne.choice);
            this.loserChoice = getObjectName(playerTwo.choice);

        } else if (playerOne.choice % 3 + 1 == playerTwo.choice) {
            this.winnerName = playerTwo.name;
            this.loserName = playerOne.name;
            this.winnerChoice = getObjectName(playerTwo.choice);
            this.loserChoice = getObjectName(playerOne.choice);

        } else {
            this.isDraw = true;
            System.out.println("-- Draw --");
        }
        if (!isDraw)
            Prompt.showMessage(String.format(winString, winnerName));

    }


    public static String getObjectName(int objectCode) {
        String returnValue = null;
        switch (objectCode) {
            case 1:
                returnValue = "Rock";
                break;

            case 2:
                returnValue = "Paper";
                break;

            case 3:
                returnValue = "Scissors";
                break;

        }
        return returnValue;
    }

}
