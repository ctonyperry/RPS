package com.company;

import java.util.ArrayList;

public class History {

    public History() {

        this.history = new ArrayList<GameResult>();
    }

    private ArrayList<GameResult> history;

    public ArrayList<GameResult> getHistory() {
        return this.history;
    }

    public void storeResults(GameResult gameResult) {
        history.add(gameResult);
    }

    public void listHistory() {
        int i = 0;
        Prompt.showMessage("---- History ----");
        for (GameResult result : getHistory()) {
            if(result.winnerName!=null) {
                String gameResultOutput = "Game %d:\n   Winner: %s (%s)\n   Loser: %s (%s)";
                Prompt.showMessage(String.format(gameResultOutput, i++, result.winnerName, result.winnerChoice, result.loserName, result.loserChoice));
            }else {
                String gameResultOutput = "Game %d: DRAW\n";

            }
        }
    }
}
