package com.scaler.model;

import java.util.Scanner;

public class InputAndDisplay {
    private final Scanner scanner;

    public InputAndDisplay(Scanner scanner) {
        this.scanner = scanner;
    }

    //public void displayBoard(int[][] board) {
    public void displayBoard(char[][] board){
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COLUMN_SIZE; j++) {
                System.out.print(board[i][j] + "  ");
                if(j < Constants.COLUMN_SIZE-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < Constants.ROW_SIZE-1){
                System.out.println("---+---+---");
            }
        }
    }

    // Here we can update this further by taking the box number as the user input
    public int[][] getUserMoveInput(){
        System.out.print("Enter the row (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column (0-2): ");
        int col = scanner.nextInt();
        return new int[][]{{row, col}};
    }
}
