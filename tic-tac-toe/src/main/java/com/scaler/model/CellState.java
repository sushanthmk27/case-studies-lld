package com.scaler.model;

/*
    Stores cell state, providing string representation
 */
public enum CellState {
    EMPTY,
    X,
    O;

    @Override
    public String toString() {
        return "CellState{}";
    }
}
