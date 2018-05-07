package com.company;

import java.util.Random;

public class ComputerPlayer extends Player {

    ComputerPlayer() {
        this.generateRandomName();
    }


    public void choose() {
        Random ran = new Random();
        this.choice =(int)(Math.random() * 3) + 1;
        Prompt.showMessage(String.format("%s chooses %s", this.name, GameResult.getObjectName(this.choice)));
    }

    private void generateRandomName() {
        StringBuilder sb = new StringBuilder();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        int nameLength = (int) (Math.random() * 8) + 4;

        for (int i = 0; i < nameLength; i++) {
            sb.append((i % 2 == 0) ? vowels[(int) ((Math.random() * vowels.length - 1) + 1)] : consonants[(int) ((Math.random() * consonants.length - 1) + 1)]);
        }
        sb.setCharAt(0, ("" + sb.charAt(0)).toUpperCase().charAt(0));

        this.name=sb.toString();
        Prompt.showMessage(String.format("%s has entered the game",this.name));
    }
}
