package com.scaler.model;

//Future scope - can be turned into an interface to allow for different types of players (human, AI, etc.)
public class Player {
    private String name;

    private Cell symbol;

    public Player(String name, Cell symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getSymbol() {
        return symbol;
    }

    public void setSymbol(Cell symbol) {
        this.symbol = symbol;
    }
}
