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

        basePanel.setBounds(420, 125, 1050, 865);
        basePanel.setBackground(new Color(68,114,196));

        return basePanel;
    }

}
