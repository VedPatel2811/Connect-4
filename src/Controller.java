import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private GameBoard view;

    public Controller(Model model, GameBoard view){
        this.model = model;
        this.view = view;
    }

    class PlaceToken implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button =(JButton) e.getSource();
            int col = view.getColumn(button);
            if(model.placeToken(col)){
                view.updateBoard();
                if(model.checkForWinner()){
                    view.showWinner(model.getCurrentPlayer());
                } else if (model.isColumnFull()) {
                    view.showDraw();
                } else {
                    model.changeCurrentPlayer();
                }
            }
        }
    }

    class ResetGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            model.resetBoard();
            view.resetBoard();
        }
    }
}
