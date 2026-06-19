package main.tictactoe;

import java.util.Scanner;

public class Game {
    Board board;
    Player p1, p2;
    Player current;
    Scanner sc = new Scanner(System.in);
    public Game(Player p1, Player p2){
        board = new Board();
        this.p1 = p1;
        this.p2 = p2;
        current = p1;
    }

    void switchRoles(){
        if(current.equals(p1)){
            current = p2 ;
        }
        else current = p1;
    }

    void placePiece(int i, int j){
        GameState gameState = GameState.PLAYING;

        if(current == p1){
           gameState =  board.placePiece(i, j, 'X');
        }
        else {
            gameState = board.placePiece(i, j, 'O');
        }

        showGameStatus(gameState);
    }

    void showGameStatus(GameState gameState){
        if(gameState == GameState.PLAYING){
            System.out.println("Game in Progress");
            switchRoles();
            makeMove();
        }
        else if(gameState == GameState.FINISH){
            System.out.println("Game finished");

        }
        else if(gameState == GameState.WON){
            System.out.println(current.name+" has won the game !");
        }
    }

    public void makeMove(){
        System.out.println("Enter move coordinates for "+current.name);
        int x = sc.nextInt();
        int y = sc.nextInt();
        placePiece(x, y);
    }

    public void endGame(){
        showGameStatus(GameState.FINISH);
    }
}
