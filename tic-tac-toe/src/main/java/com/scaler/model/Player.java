package com.scaler.model;

//Future scope - can be turned into an interface to allow for different types of players (human, AI, etc.)
public class Player {
    public String name;

    //public CellState symbol;
    public CellState symbol;

    public Player(String name, CellState symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CellState getSymbol() {
        return symbol;
    }

    public void setSymbol(CellState symbol) {
        this.symbol = symbol;
    }
}
