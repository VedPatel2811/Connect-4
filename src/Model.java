/**
 * Represents the model for the Connect Four game.
 * This class contains the game logic and state, including the game board, current player, and methods for placing tokens, checking for winners, and resetting the board.
 */
public class Model {
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final int EMPTY = 0;
    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;
    private int[][] board;
    private int currentPlayer;

    /**
     * Constructs a Model object.
     * Initializes the game board and sets the current player to PLAYER1.
     */
    public Model(){
        board = new int[ROWS][COLUMNS];
        currentPlayer = PLAYER1;
    }
    /**
     * Places a token in the specified column.
     *
     * @param col The column to place the token in
     * @return True if the token was successfully placed, false otherwise
     */
    public boolean placeToken(int col){
        if (col<0 || col>=COLUMNS || board[0][col] != EMPTY){
            return false; //column is invalid or column is not empty
        }
        for(int row = ROWS - 1; row>=0; row--){
            if(board[row][col]==EMPTY){
                board[row][col]= currentPlayer;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a winner on the game board.
     *
     * @return True if there is a winner, false otherwise
     */
    public boolean checkForWinner(){
        for(int row = 0; row<ROWS; row++){ //just check for horizontal win
            for (int col = 0; col<=COLUMNS-4; col++){
                if(board[row][col]!=EMPTY && board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2] && board[row][col] == board[row][col + 3]){
                    return true;
                }
            }
        }
        for (int col = 0; col < COLUMNS; col++) { //just check for vertical win
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] != EMPTY && board[row][col] == board[row + 1][col] && board[row][col] == board[row + 2][col] && board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }
        for (int row = 0; row <= ROWS - 4; row++) { //checking from left to right diagonal
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] != EMPTY && board[row][col] == board[row + 1][col + 1] && board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }
        for (int row = 0; row <= ROWS - 4; row++) { //checking from right to left diagonal
            for (int col = COLUMNS - 1; col >= 3; col--) {
                if (board[row][col] != EMPTY && board[row][col] == board[row + 1][col - 1] && board[row][col] == board[row + 2][col - 2] && board[row][col] == board[row + 3][col - 3]) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Checks if the game board is full.
     *
     * @return True if the board is full, false otherwise
     */
    public boolean isColumnFull(){
        for (int row = 0; row<ROWS; row++){
            for(int col = 0; col<COLUMNS; col++){
                if(board[row][col]==EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Gets the current player.
     *
     * @return The current player (PLAYER1 or PLAYER2)
     */
    public int getCurrentPlayer(){
        return currentPlayer;
    }
    /**
     * Changes the current player.
     */
    public void changeCurrentPlayer(){
        if(currentPlayer==PLAYER1){
            currentPlayer=PLAYER2;
        } else {
            currentPlayer=PLAYER1;
        }
    }
    /**
     * Gets the chip at the specified row and column on the game board.
     *
     * @param row The row index
     * @param col The column index
     * @return The value of the chip at the specified position
     */
    public int getChipAt(int row, int col) {
        return board[row][col];
    }
    /**
     * Resets the game board and sets the current player to PLAYER1.
     */
    public void resetBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY;
            }
        }
        currentPlayer = PLAYER1;
    }
}
