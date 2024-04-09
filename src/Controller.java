import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class responsible for handling user interactions and game logic.
 */
public class Controller {
    private final Model model;
    private final GameBoard view;
    private final GameInfo gameInfo;
    private final StartGame startGame;
    private Timer gameTimer; // Timer for game time
    private int elapsedTime; // Elapsed time in seconds

    private Timer playerTurnTimer; // Timer for game time
    private int elapsedTime2; // Elapsed time in seconds

    /**
     * Constructs a Controller object with references to various components.
     *
     * @param model     The game model.
     * @param view      The game board view.
     * @param gameInfo  The game information view.
     * @param startGame The start game view.
     * @param menuBar   The menu bar view.
     */
    public Controller(Model model, GameBoard view, GameInfo gameInfo, StartGame startGame, MenuBar menuBar){
        this.model = model;
        this.view = view;
        this.gameInfo = gameInfo;
        this.startGame = startGame;

        // Initialize menu bar actions
        menuBar.exitItem.addActionListener(new ExitButtonListener());
        menuBar.resetGame.addActionListener(new ResetGameListener());
        menuBar.rulesItem.addActionListener(new RulesListener());
        menuBar.updateItem.addActionListener(new GameUpdateListener());
        menuBar.infoItem.addActionListener(new GameInfoListener());
        menuBar.saveItem.addActionListener(new NextUpdate());
        menuBar.loadItem.addActionListener(new NextUpdate());
        menuBar.connectItem.addActionListener(new NextUpdate());

        // Initialize game timer
        gameTimer = new Timer(1000, new ActionListener() {
            /**
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++; // Increment elapsed time by 1 second
                updateGameTime(elapsedTime); // Update game time label

            }
        });
        gameTimer.start(); // Start the timer
        // Initialize player turn timer
        playerTurnTimer = new Timer(1000, new ActionListener() {
            /**
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime2++; // Increment elapsed time by 1 second
                updatePlayerTurnTime(elapsedTime2); // Update game time label
            }
        });
        playerTurnTimer.start(); // Start the timer
    }

    /**
     * ActionListener for the exit button.
     */
    static class ExitButtonListener implements ActionListener {
        /**
         * Show confirmation dialog
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show confirmation dialog
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?",
                    "Exit Game", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    /**
     * ActionListener for displaying game rules.
     */
    static class RulesListener implements ActionListener{
        /**
         *  Show Rules
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,
                    """
                            Connect 4 Guidelines:
                            1. The gaming area consists of a grid with 7 columns and 6 rows.
                            2. Players take turns placing their colored pieces into the columns.
                            3. Pieces are dropped from the top and occupy the lowest open space in a column.
                            4. The objective is to connect four pieces of your color either horizontally, vertically, or diagonally.
                            5. The game concludes when a player achieves a winning arrangement or when the grid is full, resulting in a draw.
                            6. Strategic play involves blocking your opponent's moves while advancing your own.
                            7. Victory is claimed by the player who forms a sequence of four pieces.
                            8. In case the grid fills up without a winner, the game is declared a draw.

                            Have fun playing Connect 4!""",
                    "Connect 4 Guidelines",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * ActionListener for resetting the game.
     */
    class ResetGameListener implements ActionListener{
        /**
         * shows conformation panel
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the game?",
                    "Exit Game", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                view.resetBoard();
                gameInfo.getPlayer1TurnLabel().setForeground(Color.YELLOW);
                gameInfo.getPlayer2TurnLabel().setForeground(new Color(32,56,100));
                gameInfo.updateText();
                stopGameTimer(); // Stop the old timer
                resetGameTimer(); // Reset game timer to 4 minutes
                stopPlayerTurnTimer();
                resetPlayerTurnTimer();
            }
        }
    }

    /**
     * ActionListener for displaying game update information.
     */
    static class GameUpdateListener implements ActionListener{
        /**
         * Show for future update
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "No updates available. Your game is already up to date.\nCurrent Game Version: 1.2", "Game Update",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * ActionListener for displaying upcoming updates.
     */
    static class NextUpdate implements ActionListener{
        /**
         * Show instruction for next update
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "This Option will be available in the next Update.\n\nIn next update you can:\n\t- Save the Game.\n\t- Load the Saved Game.\n\t- Play this game with your friend remotely.\n\t- Chat while playing the game using chat box.", "",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * ActionListener for displaying game information.
     */
    static class GameInfoListener implements ActionListener{
        /**
         * Show Game Information
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,
                    """
                            Game Information:

                            Creators:
                            - Ved Patel
                            - Steve

                            Enjoy playing the game!""",
                    "Game Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * ActionListener for placing a token on the board.
     */
    class PlaceToken implements ActionListener {
        /**
         * Action require to change token
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int col = view.getColumn(button);
            if (model.placeToken(col)) {
                view.updateBoard();
                if (model.checkForWinner()) {
                    int currentPlayer = model.getCurrentPlayer();
                    if(currentPlayer == 1) {
                        view.showWinner(startGame.name1);
                    } else {
                        view.showWinner(startGame.name2);
                    }
                    gameInfo.getPlayer1TurnLabel().setForeground(Color.YELLOW);
                    gameInfo.getPlayer2TurnLabel().setForeground(new Color(32,56,100));
                    gameInfo.round++;
                    gameInfo.updateText();
                    stopGameTimer(); // Stop the old timer
                    resetGameTimer(); // Reset game timer to 4 minutes
                    stopPlayerTurnTimer();
                    resetPlayerTurnTimer();
                } else if (model.isColumnFull()) {
                    view.showDraw();
                } else {
                    Color tempColor = gameInfo.player1Color;
                    gameInfo.player1Color = gameInfo.player2Color;
                    gameInfo.player2Color = tempColor;
                    gameInfo.getPlayer1TurnLabel().setForeground(gameInfo.player1Color);
                    gameInfo.getPlayer2TurnLabel().setForeground(gameInfo.player2Color);
                    stopPlayerTurnTimer(); // Stop the old player turn timer
                    resetPlayerTurnTimer(); //
                    model.changeCurrentPlayer(); // Change the player
                }
            }
        }
    }

    /**
     * Stops the game timer.
     */
    public void stopGameTimer() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }

    /**
     * Resets the game timer with the specified initial time.
     *
     */
    public void resetGameTimer() {
        elapsedTime = 0;
        if (gameTimer != null) {
            gameTimer.stop();
        }
        gameTimer = new Timer(1000, new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++; // Increment elapsed time by 1 second
                updateGameTime(elapsedTime); // Update game time label
            }
        });
        gameTimer.start(); // Start the timer
    }

    /**
     * Starts the player turn timer.
     */
    public void startPlayerTurnTimer() {
        playerTurnTimer = new Timer(1000, new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime2++; // Increment elapsed time by 1 second
                updatePlayerTurnTime(elapsedTime2); // Update player turn time label
            }
        });
        playerTurnTimer.start(); // Start the timer
    }

    /**
     * Stops the player turn timer.
     */
    public void stopPlayerTurnTimer() {
        if (playerTurnTimer != null) {
            playerTurnTimer.stop();
        }
    }

    /**
     * Resets the player turn timer with the specified initial time.
     *
     */
    public void resetPlayerTurnTimer() {
        elapsedTime2 = 0;
        if (playerTurnTimer != null) {
            playerTurnTimer.stop();
        }
        startPlayerTurnTimer();
    }

    /**
     * Updates the game time label based on the elapsed time.
     * @param elapsedTime The elapsed time in seconds.
     */
    public void updateGameTime(int elapsedTime) {
        int remainingTime = gameInfo.gameTime - elapsedTime;
        if (remainingTime < 0) {
            remainingTime = 0; // Ensure the time is non-negative
            gameTimer.stop(); // Stop the timer if time runs out
            // Optionally, you can handle end of game logic here
        }
        gameInfo.timer2Label.setText("Game time: " + gameInfo.formatTime(remainingTime));
    }

    /**
     * Updates the player turn time label based on the elapsed time.
     * @param elapsedTime The elapsed time in seconds.
     */
    public void updatePlayerTurnTime(int elapsedTime) {
        int remainingTime = gameInfo.playerTurnTime - elapsedTime;
        if (remainingTime < 0) {
            remainingTime = 0; // Ensure the time is non-negative
            playerTurnTimer.stop(); // Stop the timer if time runs out
            // Optionally, you can handle end of turn logic here
        }
        gameInfo.timer1Label.setText("Timer: " + remainingTime + "s");
    }
}