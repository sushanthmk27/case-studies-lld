package com.scaler.model;

/*
    Stores cell state, providing string representation
 */
public enum Cell {
    EMPTY,
    X,
    O;

    @Override
    public String toString() {
        return "Cell{}";
    }
}
