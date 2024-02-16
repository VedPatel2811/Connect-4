import javax.swing.*;
import java.awt.*;

public class GameBoard {
    GameBoard(){
        MainGameBoard();
    }
    public JPanel MainGameBoard(){
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new GridLayout(6,7));

        basePanel.setBounds(480, 125, 1000, 865);
        basePanel.setBackground(new Color(68,114,196));

        /*for (int i = 0; i < 42 ; i++){
            JButton gameCoins = new JButton();
            gameCoins.setPreferredSize(new Dimension(140, 140));
            gameCoins.setBackground(new Color(143,170,220));
            gameCoins.setBorder(BorderFactory.createLineBorder(new Color(20,40,76),1));
            basePanel.add(gameCoins);
        }*/

        return basePanel;
    }

}
