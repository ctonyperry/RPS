package com.company;

import com.sun.istack.internal.Nullable;

import java.awt.print.Paper;

public class Game {

    int numPlayers;

    Player[] players;
    History gameHistory = new History();

    public Game() {
        mainMenu();
    }

    public void mainMenu() {
        Prompt.showMessage("(P)lay, (H)istory or (Q)uit");

        switch (Prompt.getStringInput(false)) {
            case "p":
                startGame();
                break;

            case "h":
                gameHistory.listHistory();
                break;

            case "q":
                System.exit(0);
                break;

            default:
                Prompt.showMessage("Invalid selection");
        }
        mainMenu();
    }

    public void getPlayers() {

        boolean isTwoPlayer = Prompt.isTwoPlayerGame();
        players = new Player[2];
        players[0] = new HumanPlayer();
        players[1] = (isTwoPlayer) ? new HumanPlayer()  : new ComputerPlayer();
    }

    public void startGame() {

        if (players == null || players.length < 2) {
            getPlayers();
        }

        players[0].choose();
        players[1].choose();

        GameResult gameResult = new GameResult(players);
        gameHistory.storeResults(gameResult);

        if (Prompt.playAgain()) {
            startGame();
        }
    }

    public void quit() {
        System.exit(0);
    }
}
