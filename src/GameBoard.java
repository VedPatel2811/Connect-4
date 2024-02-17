import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameBoard {
    GameBoard(){
        MainGameBoard();
    }
    public JPanel MainGameBoard(){
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new GridLayout(6,7));

        basePanel.setPreferredSize(new Dimension(1000, 800));
        basePanel.setBackground(new Color(68,114,196));
        basePanel.setBorder(new EmptyBorder(0,25,0,0));
        basePanel.setBorder(BorderFactory.createLineBorder(new Color(53,90,156),2));



        for (int i = 0; i < 42 ; i++){
            JButton gameCoins = new JButton();
            gameCoins.setLayout(new BorderLayout());
            gameCoins.setBackground(new Color(68,114,196));
            gameCoins.setBorder(null);
            ImageIcon image = new ImageIcon("A12Blank.png");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(image);
            gameCoins.add(imageLabel, BorderLayout.CENTER);

            basePanel.add(gameCoins);
        }

        return basePanel;
    }

}
