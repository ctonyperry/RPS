package com.company;

public enum MenuChoice {
    PLAY('p'),
    HISTORY('h'),
    QUIT('q'),
    AGAIN('a'),
    YES('y'),
    NO('n');

    private final char choiceCode;

    MenuChoice(char choiceCode){
        this.choiceCode = choiceCode;
    }

    public char getChoiceCode(){
        return this.choiceCode;
    }
}
