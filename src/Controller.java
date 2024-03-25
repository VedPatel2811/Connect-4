import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private GameBoard view;
    private GameInfo gameInfo;
    private StartGame startGame;
    private MenuBar menuBar;

    public Controller(Model model, GameBoard view, GameInfo gameInfo, StartGame startGame, MenuBar menuBar){
        this.model = model;
        this.view = view;
        this.gameInfo = gameInfo;
        this.startGame = startGame;
        this.menuBar = menuBar;


        menuBar.exitItem.addActionListener(new ExitButtonListener());
        menuBar.resetGame.addActionListener(new ResetGameListener());
        menuBar.rulesItem.addActionListener(new RulesListener());
        menuBar.updateItem.addActionListener(new GameUpdateListener());
        menuBar.infoItem.addActionListener(new GameInfoListener());
        menuBar.saveItem.addActionListener(new NextUpdate());
        menuBar.loadItem.addActionListener(new NextUpdate());
        menuBar.connectItem.addActionListener(new NextUpdate());
    }

    // ActionListener for the exit button
    static class ExitButtonListener implements ActionListener {
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

    static class RulesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,
                    "Connect 4 Guidelines:\n\n" +
                            "1. The gaming area consists of a grid with 7 columns and 6 rows.\n" +
                            "2. Players take turns placing their colored pieces into the columns.\n" +
                            "3. Pieces are dropped from the top and occupy the lowest open space in a column.\n" +
                            "4. The objective is to connect four pieces of your color either horizontally, vertically, or diagonally.\n" +
                            "5. The game concludes when a player achieves a winning arrangement or when the grid is full, resulting in a draw.\n" +
                            "6. Strategic play involves blocking your opponent's moves while advancing your own.\n" +
                            "7. Victory is claimed by the player who forms a sequence of four pieces.\n" +
                            "8. In case the grid fills up without a winner, the game is declared a draw.\n\n" +
                            "Have fun playing Connect 4!",
                    "Connect 4 Guidelines",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class ResetGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the game?",
                    "Exit Game", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                view.resetBoard();
                gameInfo.getPlayer1TurnLabel().setForeground(Color.YELLOW);
                gameInfo.getPlayer2TurnLabel().setForeground(new Color(32,56,100));

                gameInfo.setTime(240);
            }
        }
    }

    static class GameUpdateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "No updates available. Your game is already up to date.\nCurrent Game Version: 1.2", "Game Update",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class NextUpdate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "This Option will be available in the next Update.\n\nIn next update you can:\n\t- Save the Game.\n\t- Load the Saved Game.\n\t- Play this game with your friend remotely.\n\t- Chat while playing the game using chat box.", "",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class GameInfoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,
                    "Game Information:\n\n" +
                            "Creators:\n" +
                            "- Ved Patel\n" +
                            "- Steve\n\n" +
                            "Enjoy playing the game!",
                    "Game Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ActionListener for placing tokens
    class PlaceToken implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int col = view.getColumn(button);
            if (model.placeToken(col)) {
                view.updateBoard();
                if (model.checkForWinner()) {
                    int currentPlayer = model.getCurrentPlayer();
                    if(currentPlayer == 1) {
                        view.showWinner(startGame.getName1());
                    } else {
                        view.showWinner(startGame.getName2());
                    }
                    gameInfo.getPlayer1TurnLabel().setForeground(Color.YELLOW);
                    gameInfo.getPlayer2TurnLabel().setForeground(new Color(32,56,100));
                    gameInfo.round++;
                    gameInfo.updateText();
                } else if (model.isColumnFull()) {
                    view.showDraw();
                } else {
                    model.changeCurrentPlayer();
                    Color tempColor = gameInfo.player1Color;
                    gameInfo.player1Color = gameInfo.player2Color;
                    gameInfo.player2Color = tempColor;
                    gameInfo.getPlayer1TurnLabel().setForeground(gameInfo.player1Color);
                    gameInfo.getPlayer2TurnLabel().setForeground(gameInfo.player2Color);

                }
            }
        }
    }
}
