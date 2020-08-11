package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private int[][] mines;
    private char[][] board;
    private int row, column;
    Random random = new Random();
    Scanner e = new Scanner(System.in);
    
    public Board() {
        mines = new int[10][10];
        board = new char[10][10];
        
        // places 0 in all positions of the mine board
        startMines();
        
        // randomly place 10 mines on mine board
        drawMines();
        
        // fill the mine with the number of neighboring mines
        fillTips();
        
        // start the display tray with _
        startBoard();
    }
    
    public boolean won() {
        int count = 0;
        
        for(int rows =1; rows < 9; rows++) {
            for(int columns = 1; columns < 9; columns++) {
                if(board[rows][columns] == '_')  {
                    count++;
                }
            }
        }
        
        // If count == 10 return true, else return false
        return count == 10;
    }
    
    public void openNeighbor() {
        // i => row and j => column
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if( (mines[row+i][column+j] != -1) && (row != 0 && row != 9 && column != 0 && column != 9) ){
                    board[row+i][column+j] = Character.forDigit(mines[row+i][column+j], 10);
                }
            }
        }
    }
    
    public int getPosition(int row, int column) {
        return mines[row][column];
    }
    
    public boolean setPosition() {
        do{
            System.out.print("\nRow: ");
            row = e.nextInt();
        
            System.out.print("\nColumn: ");
            column = e.nextInt();
            
            if((board[row][column] != '_') && ((row < 9 && row > 0)
                    && (column < 9 && column > 0)))
                System.out.println("This field is already being displayed");
            
            if(row < 1 || row > 8 || column < 1 || column > 8)
                System.out.println("Choose numbers between 1 and 8");
            
        } while((row < 1 && row > 8) && (column < 1 && column > 8)
                || (board[row][column] != '_'));
        
        
        return getPosition(row, column) == -1;     
    }
    
    public void show() {
        System.out.println("\n     Rows");
    }
}
