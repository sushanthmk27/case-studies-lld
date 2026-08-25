package com.scaler.model;

//Future scope - can be turned into an interface to allow for different types of players (human, AI, etc.)
public class Player {
    public String name;

    //public Cell symbol;
    public char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
