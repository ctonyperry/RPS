package com.company;

public class HumanPlayer extends Player{

    HumanPlayer(){
        this.name = getName();
    }

    private String getName() {
        Prompt.showMessage("Enter player name:");
        return Prompt.getStringInput(true);
    }

    @Override
    public void choose() {

        Prompt.showMessage(String.format("%s, choose (r)ock, (p)aper or (s)cissors?", this.name));

        switch (Prompt.getStringInput()) {
            case "r":
                this.choice = 1;
                break;

            case "p":
                this.choice = 2;
                break;

            case "s":
                this.choice = 3;
                break;

            default:
                Prompt.showMessage("Invalid choice, try again");
                choose();
                break;
        }
    }
}
