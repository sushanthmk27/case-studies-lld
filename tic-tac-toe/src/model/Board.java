package model;

public class Board {
    private int size;
    private Cell[][] cells;

    public Board(int size, Cell[][] cells) {
        this.size = size;
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
