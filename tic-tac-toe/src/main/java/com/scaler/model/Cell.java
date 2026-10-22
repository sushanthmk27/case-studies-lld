package com.scaler.model;

public class Cell {
    private final int cellNumber;

    private CellState cellSymbol;

    public Cell(int cellNumber, CellState cellSymbol){
        this.cellNumber = cellNumber;
        this.cellSymbol = cellSymbol;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public CellState getCellSymbol() {
        return cellSymbol;
    }

    public void setCellSymbol(CellState cellSymbol) {
        this.cellSymbol = cellSymbol;
    }

    
}
