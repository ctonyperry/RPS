package com.company;

public enum GameChoice {
    ROCK('r'), PAPER('p'), SCISSORS('s');

    private final char choiceCode;

    GameChoice(char choiceCode){
        this.choiceCode = choiceCode;
    }

    public char getChoiceCode(){
        return this.choiceCode;
    }
}
