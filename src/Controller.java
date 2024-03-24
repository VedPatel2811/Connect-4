import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private GameBoard view;
    private GameInfo gameInfo;
    private StartGame startGame;

    public Controller(Model model, GameBoard view, GameInfo gameInfo, StartGame startGame){
        this.model = model;
        this.view = view;
        this.gameInfo = gameInfo;
        this.startGame=startGame;
    }

    class PlaceToken implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int col = view.getColumn(button);
            if (model.placeToken(col)) {
                view.updateBoard();
                if (model.checkForWinner()) {
                    int currentPlayer = model.getCurrentPlayer();
                    if(currentPlayer==1){
                        view.showWinner(startGame.getName1());
                    } else {
                        view.showWinner(startGame.getName2());
                        Color tempColor = gameInfo.player1Color;
                        gameInfo.player1Color = gameInfo.player2Color;
                        gameInfo.player2Color = tempColor;
                        gameInfo.getPlayer1TurnLabel().setForeground(gameInfo.player1Color);
                        gameInfo.getPlayer2TurnLabel().setForeground(gameInfo.player2Color);
                    }

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