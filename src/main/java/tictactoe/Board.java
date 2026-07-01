package tictactoe;

enum GameState{

    PLAYING,
    WON,
    FINISH
}

public class Board {

    char[][] grid ;
    final int n = 3 ;
    int count = n*n ;
    Board(){
        grid = new char[n][n];
    }

    GameState placePiece(int i, int j, char state){
        if(count < 1) return GameState.FINISH ;

        grid[i][j] = state ;

        if(validate( i,  j)){
            return GameState.WON;
        }

        return GameState.PLAYING;
    }

    boolean validate(int r, int c){
        char val  = grid[r][c];
        boolean gameState = true;
        for(int col = 0 ; col < n ; col++){
            if(grid[r][col]!=val) {
                gameState = false ;
                break;
            }
        }

        if(gameState) return true ;


        gameState = true ;
        for(int row = 0 ; row < n  ; row++){
            if(grid[row][c]!=val) {
                gameState = false ;
                break ;
            }
        }

        if(gameState) return true ;

        gameState = true ;
        int row = 0 ;
        int col = 0 ;

        while(row < n && col < n){
                if(grid[row][col]!=val){
                    gameState = false;
                    break;
                }
                row++;
                col++;
            }

        if(gameState) return true ;

        gameState = true ;

        row = 0 ;
        col = n - 1 ;

        while(row < n && col >=0){
            if(grid[row][col]!=val){
                gameState = false;
                break;
            }
            row++;
            col--;
        }

        return gameState;

    }

}
