package minesweeper;

public class Game {
    private Board board;
    boolean finish = false;
    boolean won = false;
    int[] move;
    int round = 0;

    public Game() {
        board = new Board();
        Play(board);
        move = new int[2];
    }
    
    public void Play(Board board) {
        do {
            round++;
            System.out.println("Round " +round);
            board.show();
            finish = board.setPosition();
            
            if(!finish) {
                board.openNeighbor();
                finish = board.won();
            }
        } while(!finish);
        
        if(!board.won()) {
            System.out.println("There was a mine! You lost!");
        } else {
            System.out.println("Congratulations, you left the 8 mine fields free in " 
                +round +" rounds");
            board.showMines();
        }
    }
}
